package com.brihaspathee.sapphire.domain.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 14, January 2025
 * Time: 4:44 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.domain.document
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@Document(collection = "enrollmentSpans", collation = "enrollmentSpans")
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentSpan {

    /**
     * Represents the unique identifier for an enrollment span.
     * This field serves as the primary key to uniquely identify an
     * enrollment span entity within the system.
     */
    @Id
    @Field("_id")
    private String enrollmentSpanId;

    /**
     * Represents a unique code identifying the enrollment span.
     * The enrollment span code serves as a key attribute for referencing and associating
     * specific enrollment spans within the system. It enables efficient identification,
     * classification, and management of enrollment span entities.
     */
    private String enrollmentSpanCode;

    /**
     * Represents the business unit associated with the enrollment span.
     * This field indicates the specific division or functional area
     * within the organization that is responsible for or associated with
     * the enrollment span. It helps in categorizing or grouping enrollment
     * spans based on their respective business units.
     */
    private String businessUnit;

    /**
     * Represents the unique identifier of the exchange subscriber associated with an enrollment span.
     * This field is used to identify and manage the relationship between the enrollment span
     * and the subscriber in external systems, such as exchanges or marketplaces.
     */
    private String exchangeSubscriberId;

    /**
     * Represents the status of an enrollment span.
     * This field indicates the current state or condition of the enrollment span,
     * such as active, inactive, or terminated, during a specific coverage period.
     * It is essential for tracking and managing the lifecycle of enrollment spans
     * as part of account or membership details.
     */
    private String spanStatus;

    /**
     * Represents the start date of the enrollment span.
     * This field specifies the beginning date when the enrollment span becomes applicable or active.
     * It is used to determine the starting point of the coverage or validity period for the enrollment span.
     */
    private LocalDate startDate;

    /**
     * Represents the end date of the enrollment span.
     * This field specifies the last date on which the enrollment span is considered valid or active.
     * It is used to determine the period of coverage or applicability of the enrollment span.
     */
    private LocalDate endDate;

    /**
     * Represents the unique identifier of the plan associated with an enrollment span.
     * This field allows linking the enrollment span to a specific insurance or benefit plan.
     * It is utilized to determine the coverage details and features corresponding to the plan.
     */
    private String planId;

    /**
     * Represents the unique identifier for a group policy associated with an enrollment span.
     * This field is utilized to associate the enrollment span with a specific*/
    private String groupPolicyId;

    /**
     * Represents the date on which the effectuation of an enrollment span is recorded.
     * This date indicates when the enrollment becomes active or official
     * based on the completion of necessary processes or requirements.
     * It is utilized in tracking the timeline and status of enrollment spans.
     */
    private LocalDate effectuationDate;

    /**
     * Represents the date through which payment has been made for a specific enrollment span.
     * This field indicates the latest date up to which financial obligations have been fulfilled.
     * It is used for tracking payment status and determining the outstanding periods, if any.
     */
    private LocalDate paidThruDate;

    /**
     * Represents a list of premium spans associated with an enrollment span.
     * Each premium span within the list contains detailed information about
     * the premium periods, including start and end dates, financial amounts,
     * and other related attributes. This field facilitates the tracking and
     * management of premium span information within the context of an
     * enrollment span, enabling accurate premium calculations, adjustments,
     * and historical records.
     */
    private List<PremiumSpan> premiumSpans;
}
