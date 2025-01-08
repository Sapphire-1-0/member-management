package com.brihaspathee.sapphire.controller.impl;

import com.brihaspathee.sapphire.controller.interfaces.IndexAPI;
import com.brihaspathee.sapphire.service.interfaces.IndexService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 31, December 2024
 * Time: 4:26 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.controller.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class IndexAPIImpl implements IndexAPI {

    /**
     * Index service instance
     */
    private final IndexService indexService;

    /**
     * Recreate all the indexes in the system
     */
    @Override
    public void recreateAllIndexes() throws IOException {
        indexService.recreateIndexes();
    }
}
