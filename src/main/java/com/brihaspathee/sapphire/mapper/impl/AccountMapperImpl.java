package com.brihaspathee.sapphire.mapper.impl;

import com.brihaspathee.sapphire.domain.document.Account;
import com.brihaspathee.sapphire.mapper.interfaces.AccountMapper;
import com.brihaspathee.sapphire.model.AccountDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, February 2025
 * Time: 6:35 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.mapper.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AccountMapperImpl implements AccountMapper {

    /**
     * Converts an Account entity to its corresponding AccountDto representation.
     *
     * @param account the Account entity that needs to be converted
     * @return the AccountDto object containing the mapped data from the Account entity
     */
    @Override
    public AccountDto toDto(Account account) {
        return null;
    }
}
