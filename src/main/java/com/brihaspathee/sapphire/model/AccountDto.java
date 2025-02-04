package com.brihaspathee.sapphire.model;

import lombok.*;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 01, February 2025
 * Time: 5:22 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    /**
     * Represents the unique identifier for an account.
     */
    private String accountId;

    /**
     * Represents the unique identifier for an account.
     */
    private String accountNumber;

    /**
     * Represents the line of business associated with the account.
     */
    private String lineOfBusiness;

    /**
     * Represents a list of members associated with the account.
     * Each member in the list is described using the MemberDto class.
     */
    private List<MemberDto> memberDtos;

    /**
     * Represents a list of enrollment span data transfer objects (EnrollmentSpanDto).
     * Each enrollment span contains detailed information regarding a specific
     * enrollment period or coverage span within the system, including data such as
     * span identifiers, associated plans, dates, and related business entities.
     * This field is used to manage and consolidate multiple enrollment spans for an account.
     */
    private List<EnrollmentSpanDto> enrollmentSpanDtos;
}
