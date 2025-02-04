package com.brihaspathee.sapphire.model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 01, February 2025
 * Time: 6:52 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {

    /**
     * Represents the unique identifier for a member.
     */
    private String memberId;

    /**
     * A unique code representing a member.
     */
    private String memberCode;

    /**
     * Represents the last name of a member.
     */
    private String lastName;

    /**
     * Represents the first name of a member.
     */
    private String firstName;

    /**
     * Represents the middle name of a member.
     */
    private String middleName;

    /**
     * Represents the date of birth of a member.
     * This field captures the birth date in the format of a LocalDate.
     */
    private LocalDate dateOfBirth;

    /**
     * Represents a list of addresses associated with a member.
     * Each address in the list is described using the AddressDto class.
     * This field is used to capture multiple addresses linked to a specific
     * member, which can include residential, business, and other types of
     * addresses.
     */
    private List<AddressDto> addressDtos;

}
