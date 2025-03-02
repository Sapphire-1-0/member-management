package com.brihaspathee.sapphire.controller.impl;

import com.brihaspathee.sapphire.controller.interfaces.WelcomeAPI;
import com.brihaspathee.sapphire.dto.auth.UserContext;
import com.brihaspathee.sapphire.dto.auth.UserDto;
import com.brihaspathee.sapphire.model.WelcomeDto;
import com.brihaspathee.sapphire.service.interfaces.WelcomeService;
import com.brihaspathee.sapphire.web.response.SapphireAPIResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<SapphireAPIResponse<WelcomeDto>> getWelcomeMessage() {
        UserDto userDto = UserContext.getUser();
        log.info("User Dto:{}", userDto);
        SapphireAPIResponse<WelcomeDto> response = SapphireAPIResponse.<WelcomeDto>builder()
                .response(WelcomeDto.builder()
                        .welcomeMessage("Hello! Welcome to Sapphire's member management service! " +
                                "Your connectivity to this service is just fine")
                        .build())
                .developerMessage("Successfully fetched the welcome message")
                .statusCode(200)
                .message("Success")
                .reason("Success")
                .status(HttpStatus.OK)
                .build();
        return ResponseEntity.ok(response);
    }

    /**
     * A welcome endpoint to test connectivity with premium billing
     * @return - welcome message
     */
    @Override
    public ResponseEntity<SapphireAPIResponse<WelcomeDto>> getPBWelcomeMessage() {
        WelcomeDto welcomeDto = welcomeService.getWelcomeMessageFromPremiumBilling();

        SapphireAPIResponse<WelcomeDto> response = SapphireAPIResponse.<WelcomeDto>builder()
                .response(welcomeDto)
                .developerMessage("Successfully fetched the welcome message")
                .statusCode(200)
                .message("Success")
                .reason("Success")
                .status(HttpStatus.OK)
                .build();
        return ResponseEntity.ok(response);
    }
}
