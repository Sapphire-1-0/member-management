package com.brihaspathee.sapphire.model;

import lombok.Builder;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 09, December 2024
 * Time: 3:53 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.model
 * To change this template use File | Settings | File and Code Template
 */
@Builder
public record WelcomeDto(

        /**
         * A welcome message
         */
        String welcomeMessage
) {
}
