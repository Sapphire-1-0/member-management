package com.brihaspathee.sapphire.controller.impl;

import com.brihaspathee.sapphire.controller.interfaces.WelcomeAPI;
import com.brihaspathee.sapphire.model.WelcomeDto;
import com.brihaspathee.sapphire.service.interfaces.WelcomeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 09, December 2024
 * Time: 3:54 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.controller.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class WelcomeAPIImpl implements WelcomeAPI {

    /**
     * Instance of welcome service
     */
    private final WelcomeService welcomeService;

    /**
     * A welcome endpoint to test connectivity
     * @return - welcome message
     */
    @Override
    public ResponseEntity<WelcomeDto> getWelcomeMessage() {
        return ResponseEntity.ok(WelcomeDto.builder()
                .welcomeMessage("Hello! Welcome to Sapphire's member management service! " +
                        "Your connectivity to this service is just fine")
                .build());
    }

    /**
     * A welcome endpoint to test connectivity with premium billing
     * @return - welcome message
     */
    @Override
    public ResponseEntity<WelcomeDto> getPBWelcomeMessage() {
        return ResponseEntity.ok(welcomeService.getWelcomeMessageFromPremiumBilling());
    }
}
