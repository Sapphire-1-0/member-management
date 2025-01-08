package com.brihaspathee.sapphire.controller.interfaces;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 31, December 2024
 * Time: 4:24 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.controller.interfaces
 * To change this template use File | Settings | File and Code Template
 */
@RequestMapping("/api/v1/sapphire/member")
@Validated
public interface IndexAPI {

    /**
     * Recreate all the indexes in the system
     */
    @PostMapping("/recreate")
    void recreateAllIndexes() throws IOException;
}
