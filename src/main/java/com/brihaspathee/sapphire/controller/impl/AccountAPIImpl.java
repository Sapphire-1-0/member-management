package com.brihaspathee.sapphire.controller.impl;

import com.brihaspathee.sapphire.controller.interfaces.AccountAPI;
import com.brihaspathee.sapphire.model.AccountDto;
import com.brihaspathee.sapphire.service.interfaces.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

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
        AccountDto savedAccount = accountService.saveAccount(accountDto);
        return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
    }
}
