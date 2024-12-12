package com.brihaspathee.sapphire.service.interfaces;

import com.brihaspathee.sapphire.model.WelcomeDto;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 11, December 2024
 * Time: 3:14 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.service.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface WelcomeService {

    /**
     * This method is used to check connectivity to premium billing service
     * @return - the message received from premium billing
     */
    WelcomeDto getWelcomeMessageFromPremiumBilling();
}
