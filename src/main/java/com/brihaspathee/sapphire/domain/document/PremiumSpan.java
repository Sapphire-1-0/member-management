package com.brihaspathee.sapphire.domain.document;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 02, February 2025
 * Time: 4:05 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.domain.document
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@Document(collection = "premiumSpans", collation = "premiumSpans")
@NoArgsConstructor
@AllArgsConstructor
public class PremiumSpan {

    /**
     * Represents the unique identifier for the premium span.
     * This field is used to uniquely identify and reference a premium span
     * within the system, ensuring proper tracking and distinction between spans.
     */
    private String premiumSpanId;

    /**
     * Represents a code associated with a premium span.
     * This field is used to uniquely identify and manage a specific premium span within the system.
     * It serves as a distinguishing attribute to ensure accurate tracking and retrieval
     * of premium-related data.
     */
    private String premiumSpanCode;

    /**
     * Represents the start date of the premium span.
     * This field indicates the date when the premium span begins
     * and is used to define the effective start of the coverage period.
     */
    private LocalDate startDate;

    /**
     * Represents the end date of a premium span.
     * This field defines the final date up to which the premium span is applicable.
     * It is used to determine the validity period and ensures proper handling
     * of premium adjustments, calculations, and coverage span transitions.
     */
    private LocalDate endDate;

    /**
     * Represents the total premium amount for a premium span.
     * This value captures the aggregate financial amount before any adjustments,
     * such as APTC (Advance Premium Tax Credit), CSR (Cost Sharing Reduction), or other subsidies.
     * It serves as the base amount on which calculations for the total financial
     * responsibility and adjustments are applied in the context of the premium span.
     */
    private BigDecimal premiumAmountTotal;

    /**
     * Represents the total amount that the responsible party is obligated to pay
     * within the context of a premium span. This value reflects the aggregate
     * financial responsibility after considering adjustments such as subsidies,
     * APTC (Advance Premium Tax Credit), CSR (Cost Sharing Reduction), or other
     * applicable factors. The amount is used in determining the final payment
     * obligations for the premium span.
     */
    private BigDecimal totalResponsibleAmount;

    /**
     * Represents the Advance Premium Tax Credit (APTC) amount associated with the premium span.
     * This field captures the portion of the premium that is subsidized through APTC,
     * a financial assistance program designed to help individuals and families afford health insurance plans.
     * The APTC amount is factored into the calculation of the total premium responsibility.
     */
    private BigDecimal aptcAmount;

    /**
     * Represents the Cost Sharing Reduction (CSR) amount applicable to the premium span.
     * This value captures the portion of the premium that is reduced through cost-sharing
     * provisions, typically provided under certain health insurance programs or subsidies.
     * It is used in the calculation of the total premium responsibilities for the covered entities.
     */
    private BigDecimal csrAmount;

    /**
     * Represents the additional payment amount associated with a premium span.
     * This field captures any payment that does not fall under predefined categories
     * such as APTC (Advance Premium Tax Credit) or CSR (Cost Sharing Reduction).
     * It can include miscellaneous payments, adjustments, or other contributions
     * relevant to the total premium calculation.
     */
    private BigDecimal otherPayAmount;

    /**
     * Represents the list of premium details associated with individual members
     * within a premium span. Each item in the list contains detailed information
     * about the premiums, including member-specific premium amounts, identifiers,
     * and any additional data needed for premium calculations and tracking.
     * This field serves as a linkage between the premium span and the respective
     * members contributing to or associated with it.
     */
    private List<MemberPremium> memberPremiums;
}
