package com.brihaspathee.sapphire.domain.document;

import lombok.*;

import java.math.BigDecimal;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 02, February 2025
 * Time: 4:01 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.domain.document
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberPremium {

    /**
     * Represents the unique identifier of a member.
     * This field is used to uniquely identify and reference a specific member in the system.
     * It serves as a primary key in various operations and ensures accurate
     * tracking, integration, and management of member-related information.
     */
    private String memberCode;

    /**
     * Represents the premium amount associated with a specific member.
     * This value indicates the cost or payment required for the insurance premium
     * as part of the member's enrollment. The premium amount is typically expressed
     * as a monetary value, such as a fixed amount or rate, and is used in financial
     * calculations, billing, and tracking premium-related transactions for the member.
     */
    private BigDecimal premiumAmount;

    /**
     * Represents the unique identifier of a member within the exchange.
     * This field is used to link and track the member's information
     * in external exchange systems. It ensures seamless integration
     **/
    private String exchangeMemberId;
}
