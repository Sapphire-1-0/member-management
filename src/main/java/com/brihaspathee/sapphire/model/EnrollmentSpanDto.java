package com.brihaspathee.sapphire.model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 02, February 2025
 * Time: 6:29 AM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentSpanDto {

    /**
     * Represents the unique identifier for an enrollment span.
     * This field is used to distinctly identify and reference a
     * specific enrollment span object within the system.
     */
    private String enrollmentSpanId;

    /**
     * Represents a unique code associated with an enrollment span.
     * This field is used to identify*/
    private String enrollmentSpanCode;

    /**
     * Represents the business unit associated with the enrollment span.
     * This field identifies the specific division or unit of the organization
     * to which the enrollment span is linked, enabling the categorization
     * and management of spans at the business unit level.
     */
    private String businessUnit;

    /**
     * Represents the status of the enrollment span.
     * This field indicates the current lifecycle or processing state
     * of the enrollment span, such as active, inactive, or terminated.
     */
    private String spanStatus;

    /**
     * Represents the start date of the enrollment span.
     * This field captures the date when the enrollment period*/
    private LocalDate startDate;

    /**
     * Represents the end date of the enrollment span.
     * This field captures the date when the enrollment period ends.
     */
    private LocalDate endDate;

    /**
     * Represents the unique identifier for a plan associated with an enrollment span.
     * This field is used to link the enrollment span to a specific insurance plan,
     * which defines the coverage details and associated benefits.
     */
    private String planId;

    /**
     * Represents the unique group policy identifier associated with an
     * enrollment span. This field is used to link the enrollment span
     * with a specific group policy, which governs the terms and conditions
     * of the coverage.
     */
    private String groupPolicyId;

    /**
     * Represents the effectuation date for an enrollment span.
     * This date indicates when the enrollment becomes effective.
     * It is stored as a LocalDate.
     */
    private LocalDate effectuationDate;

    /**
     * Represents the date through which payment has been made for a specific
     * enrollment span or entity. This field captures the last date of paid
     * coverage within the associated span. The value is stored as a LocalDate.
     */
    private LocalDate paidThruDate;

    /**
     * Represents a list of premium spans associated with an enrollment span.
     * Each premium span in the list is described using the PremiumSpanDto class.
     * This field is used to capture and manage detailed premium-related
     * information, such as premium amounts, subsidy details, and coverage periods,
     * for a given enrollment span. It enables the system to handle multiple
     * premium spans effectively when an enrollment spans across different
     * periods or contexts.
     */
    private List<PremiumSpanDto> premiumSpans;
}
