package com.brihaspathee.sapphire.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 02, February 2025
 * Time: 4:14 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PremiumSpanDto {

    /**
     * Represents the unique identifier for a premium span.
     * This field is used to differentiate one premium span from another
     * within the system, ensuring accurate and efficient identification
     * and referencing across related entities or operations.
     */
    private String premiumSpanId;

    /**
     * Represents a unique code that identifies the premium span.
     * This code serves as an identifier for grouping or distinguishing
     * various premium-related data within a specific period or context.
     */
    private String premiumSpanCode;

    /**
     * Represents the start date of the premium span.
     * This field specifies the initial date that marks the beginning
     * of the premium coverage for the given premium span period.
     */
    private LocalDate startDate;

    /**
     * Represents the end date of the premium span.
     * This field specifies the final date that marks the conclusion
     * of the premium coverage within the given premium span period.
     */
    private LocalDate endDate;

    /**
     * Represents the total premium amount for a given premium span.
     * This field captures the aggregate sum of all premiums without considering
     * reductions or subsidies such as Advance Premium Tax Credit (APTC), Cost-Sharing
     * Reduction (CSR), or other assistance programs. The value reflects the full
     * price payable for the premium span.
     */
    private BigDecimal premiumAmountTotal;

    /**
     * Represents the sum of amounts that an individual or entity is responsible for
     * in a premium span. This value accounts for the cost that must be covered
     * directly by the responsible party, excluding subsidies such as Advance Premium
     * Tax Credit (APTC) or Cost-Sharing Reduction (CSR).
     */
    private BigDecimal totalResponsibleAmount;

    /**
     * Represents the Advance Premium Tax Credit (APTC) amount associated with a premium span.
     * This value is used to capture the portion of the premium that is subsidized
     * through APTC, aimed at reducing monthly insurance payments for eligible individuals.
     */
    private BigDecimal aptcAmount;

    /**
     * Represents the Cost-Sharing Reduction (CSR) amount associated with the premium span.
     * This value is used to capture the portion of the premium or medical cost that is subsidized
     * by a CSR plan, intended to reduce out-of-pocket expenses for eligible individuals.
     */
    private BigDecimal csrAmount;

    /**
     * Represents an additional payment amount that does not fall under standard payment categories.
     * This value is used to capture miscellaneous or other undefined payments associated with
     * the premium span.
     */
    private BigDecimal otherPayAmount;

    /**
     * Represents a list of premium details for individual members within a premium span.
     * Each item in the list is described by the MemberPremiumDto class, which contains
     * specific information such as member code, premium amount, and other related attributes.
     * This field is used to associate and manage premium-related data for all members
     * included in a given premium span.
     */
    private List<MemberPremiumDto> memberPremiumDtos;
}
