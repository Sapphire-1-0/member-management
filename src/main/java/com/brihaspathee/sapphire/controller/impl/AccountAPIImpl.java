package com.brihaspathee.sapphire.controller.impl;

import com.brihaspathee.sapphire.controller.interfaces.AccountAPI;
import com.brihaspathee.sapphire.dto.auth.UserContext;
import com.brihaspathee.sapphire.dto.auth.UserDto;
import com.brihaspathee.sapphire.model.AccountDto;
import com.brihaspathee.sapphire.service.interfaces.AccountService;
import com.brihaspathee.sapphire.web.response.SapphireAPIResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 01, February 2025
 * Time: 5:28 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.controller.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class AccountAPIImpl implements AccountAPI {

    /**
     * Service layer dependency used for managing account-related operations.
     * This instance is injected and utilized within the controller implementation
     * to delegate account operations to the underlying service layer.
     */
    private final AccountService accountService;

    /**
     * Creates a new account based on the provided account details.
     *
     * @param accountDto The details of the account to be created.
     * @return A ResponseEntity containing the created account details.
     */
    @Override
    public ResponseEntity<AccountDto> createAccount(AccountDto accountDto) {
//        AccountDto savedAccount = accountService.saveAccount(accountDto);
        log.info("Trying to create account - this log is from AccountAPIImpl");
        UserDto userDto = UserContext.getUser();
        if(userDto != null) {
            log.info("User name:{}", userDto.getUsername());
            log.info("User Id:{}", userDto.getUserId());
            log.info("Service Id:{}", userDto.getServiceId());
            log.info("Account Type:{}", userDto.getAccountType());
        }
        AccountDto savedAccount = AccountDto.builder().build();
        return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<SapphireAPIResponse<String>> getAllAccounts() {
        log.info("Trying to get all accounts");
        UserDto userDto = UserContext.getUser();
        if(userDto != null) {
            log.info("User name:{}", userDto.getUsername());
            log.info("User Id:{}", userDto.getUserId());
            log.info("Service Id:{}", userDto.getServiceId());
            log.info("Account Type:{}", userDto.getAccountType());
        }
        SapphireAPIResponse<String> response = SapphireAPIResponse.<String>builder()
                .response("Test for get all accounts")
                .developerMessage("Successfully fetched all accounts")
                .statusCode(200)
                .message("Success")
                .timestamp(LocalDateTime.now())
                .reason("Success")
                .status(HttpStatus.OK)
                .build();
        return ResponseEntity.ok(response);
    }
}
