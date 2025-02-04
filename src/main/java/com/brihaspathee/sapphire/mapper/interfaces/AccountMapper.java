package com.brihaspathee.sapphire.mapper.interfaces;

import com.brihaspathee.sapphire.domain.document.Account;
import com.brihaspathee.sapphire.model.AccountDto;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, February 2025
 * Time: 6:34 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.mapper.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface AccountMapper {

    /**
     * Converts an Account entity to its corresponding AccountDto representation.
     *
     * @param account the Account entity that needs to be converted
     * @return the AccountDto object containing the mapped data from the Account entity
     */
    AccountDto toDto(Account account);
}
