package com.brihaspathee.sapphire.service.interfaces;

import com.brihaspathee.sapphire.domain.document.Account;
import com.brihaspathee.sapphire.model.AccountDto;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 01, February 2025
 * Time: 5:20 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.service.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface AccountService {

    /**
     * Saves an account into the system.
     *
     * @param accountDto the account object to be saved
     * @return the account object after it has been saved
     */
    AccountDto saveAccount(AccountDto accountDto);
}
