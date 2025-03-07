package com.brihaspathee.sapphire.controller.interfaces;

import com.brihaspathee.sapphire.domain.document.Account;
import com.brihaspathee.sapphire.model.AccountDto;
import com.brihaspathee.sapphire.web.response.SapphireAPIResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 01, February 2025
 * Time: 5:25 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.controller.interfaces
 * To change this template use File | Settings | File and Code Template
 */
@RequestMapping("/api/v1/sapphire/mms/secured/account")
@Validated
public interface AccountAPI {

    /**
     * Creates a new account with the provided account details.
     *
     * @param accountDto contains the details of the account to be created
     * @return a ResponseEntity containing the created AccountDto
     */
    @PostMapping("/create")
    ResponseEntity<AccountDto> createAccount(@Valid @RequestBody AccountDto accountDto);

    @GetMapping
    ResponseEntity<SapphireAPIResponse<String>> getAllAccounts();
}
