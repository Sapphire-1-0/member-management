package com.brihaspathee.sapphire.service.impl;

import com.brihaspathee.sapphire.domain.document.Account;
import com.brihaspathee.sapphire.domain.document.EnrollmentSpan;
import com.brihaspathee.sapphire.domain.document.Member;
import com.brihaspathee.sapphire.domain.repository.AccountRepository;
import com.brihaspathee.sapphire.helper.interfaces.EnrollmentSpanHelper;
import com.brihaspathee.sapphire.model.AccountDto;
import com.brihaspathee.sapphire.model.EnrollmentSpanDto;
import com.brihaspathee.sapphire.service.interfaces.AccountService;
import com.brihaspathee.sapphire.service.interfaces.MemberElasticService;
import com.brihaspathee.sapphire.service.interfaces.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 01, February 2025
 * Time: 5:21 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.service.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    /**
     * Repository for performing CRUD operations and database interaction
     * related to Account entities in the system.
     */
    private final AccountRepository accountRepository;

    /**
     * Service that provides operations for managing members within the system.
     * This member service is utilized to handle member-related functionalities
     * such as saving member details and performing associated business logic.
     */
    private final MemberService memberService;

    /**
     * Helper component responsible for processing and managing operations
     * related to enrollment spans. It provides functionalities such as saving
     * enrollment span details and performing associated business logic.
     */
    private final EnrollmentSpanHelper enrollmentSpanHelper;

    /**
     * Saves the provided account information into the system.
     *
     * @param accountDto the account object containing the account details to be saved
     * @return the saved account object after persistence
     */
    @Override
    public AccountDto saveAccount(AccountDto accountDto) {
        List<Member> members = memberService.saveMembers(accountDto.getMemberDtos());
        List<EnrollmentSpanDto> savedEnrollmentSpans = enrollmentSpanHelper.saveEnrollmentSpans(accountDto.getEnrollmentSpanDtos());
        Account account = Account.builder()
                .accountNumber(accountDto.getAccountNumber())
                .lineOfBusiness(accountDto.getLineOfBusiness())
                .members(members)
                .enrollmentSpans(savedEnrollmentSpans.stream().map(enrollmentSpanDto -> EnrollmentSpan.builder()
                        .enrollmentSpanId(enrollmentSpanDto.getEnrollmentSpanId())
                        .enrollmentSpanCode(enrollmentSpanDto.getEnrollmentSpanCode())
                        .spanStatus(enrollmentSpanDto.getSpanStatus())
                        .businessUnit(enrollmentSpanDto.getBusinessUnit())
                        .startDate(enrollmentSpanDto.getStartDate())
                        .endDate(enrollmentSpanDto.getEndDate())
                        .planId(enrollmentSpanDto.getPlanId())
                        .groupPolicyId(enrollmentSpanDto.getGroupPolicyId())
                        .build()).toList())
                .build();

        account = accountRepository.save(account);
        accountDto.setAccountId(account.getAccountId());
        return accountDto;
    }
}
