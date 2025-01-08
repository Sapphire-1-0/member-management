package com.brihaspathee.sapphire.service.impl;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.CreateIndexRequest;
import co.elastic.clients.elasticsearch.indices.DeleteIndexRequest;
import co.elastic.clients.json.JsonData;
import com.brihaspathee.sapphire.domain.elastic.index.Indexes;
import com.brihaspathee.sapphire.service.interfaces.IndexService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 31, December 2024
 * Time: 3:50 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.service.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class IndexServiceImpl implements IndexService {

    /**
     * Elastic search client instance
     */
    private final ElasticsearchClient elasticsearchClient;

    /**
     * The list of indexes in the system
     */
    private static final List<String> INDICES = List.of(Indexes.MEMBER_INDEX);

    /**
     * Method to recreate all the indexes in the system
     */
    @Override
    public void recreateIndexes() throws IOException {

        try (InputStream inputStream = loadSettingsFromFile("static/es-settings.json")) {

            // Loop through indexes to delete and recreate them
            for (final String index : INDICES) {
                // check if the index exist
                if (indexExists(index)) {
                    // if it exists then delete the index
                    elasticsearchClient.indices().delete(DeleteIndexRequest.of(d -> d.index(index)));
                    log.info("Index {} deleted.", index);
                }
                // recreate the index
                elasticsearchClient.indices().create(CreateIndexRequest.of(c -> c
                        .index(index)
                        .settings(s -> s.withJson(inputStream))
                ));
                log.info("Index {} created.", index);
            }
        }catch (Exception e) {
            log.error(e.getMessage());
        }

    }

    /**
     * Check if the index exists
     * @return - return true if index exists or false if it doesn't
     */
    private boolean indexExists(String index) throws IOException {
        return elasticsearchClient.indices().exists(e -> e.index(index)).value();
    }

    /**
     * Load the settings file from the classpath
     * @param filePath - the path where the settings file exists
     * @return - return settings as an input stream
     * @throws IOException - The exception that is generated
     */
    private InputStream loadSettingsFromFile(String filePath) throws IOException {
        ClassPathResource resource = new ClassPathResource(filePath);
        return resource.getInputStream();
    }
}
