package com.brihaspathee.sapphire.model;

import lombok.*;

import java.math.BigDecimal;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 02, February 2025
 * Time: 4:11 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberPremiumDto {

    /**
     * Represents a unique code assigned to a member.
     * This field is used to identify or differentiate a member
     * within the system, ensuring uniqueness and allowing for
     * efficient referencing in various operations or contexts.
     */
    private String memberCode;

    /**
     * Represents the premium amount associated with a member's coverage or policy.
     * This field stores the value of the premium, typically as a string, which may
     * include numeric values and formatting (e.g., currency symbols or decimal points).
     */
    private BigDecimal premiumAmount;

    /**
     * Represents the unique identifier of*/
    private String exchangeMemberId;
}
