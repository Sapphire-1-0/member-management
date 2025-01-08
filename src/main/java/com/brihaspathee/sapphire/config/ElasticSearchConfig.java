package com.brihaspathee.sapphire.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.ExistsRequest;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Component;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 12, December 2024
 * Time: 5:30 AM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.config
 * To change this template use File | Settings | File and Code Template
 */
@Component
@EnableElasticsearchRepositories(basePackages = "com.brihaspathee.sapphire.domain.elastic.repository")
public class ElasticSearchConfig {

    @Bean
    public ElasticsearchClient elasticsearchClient() {
        // Set up credentials

        // Create the RestClient
        RestClientBuilder restClientBuilder = RestClient.builder(new HttpHost("localhost", 9200, "http"));

        RestClient restClient = restClientBuilder.build();

        // Use the new Elasticsearch Java API Client
        RestClientTransport transport = new
                RestClientTransport(restClient, new JacksonJsonpMapper());
        return new ElasticsearchClient(transport);
    }
}
