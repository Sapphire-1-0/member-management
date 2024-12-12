package com.brihaspathee.sapphire.service.impl;

import com.brihaspathee.sapphire.feign.client.PremiumBillingClient;
import com.brihaspathee.sapphire.model.WelcomeDto;
import com.brihaspathee.sapphire.service.interfaces.WelcomeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 11, December 2024
 * Time: 3:15 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.service.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class WelcomeServiceImpl implements WelcomeService {

    /**
     * The feign client to get the data from premium billing service
     */
    private final PremiumBillingClient premiumBillingClient;

    /**
     * Check connectivity with premium billing service
     * @return - Message returned from premium billing service
     */
    @Override
    public WelcomeDto getWelcomeMessageFromPremiumBilling() {
        WelcomeDto welcomeMessage = premiumBillingClient.welcomeMessage();
        return welcomeMessage;
    }
}
