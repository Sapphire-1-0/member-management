package com.brihaspathee.sapphire.domain.document;

import lombok.*;

import java.time.LocalDate;

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
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    /**
     * Represents a unique identifier for an address.
     * This field is used to distinguish each address instance
     * uniquely within the system. It aids in managing and referencing
     * address records efficiently.
     */
    private String addressCode;

    /**
     * Represents the type of the address.
     * This field indicates the classification or category of the address,
     * such as residential, business, mailing, or billing address.
     * It helps in distinguishing between different uses or contexts of the address.
     */
    private String addressType;

    /**
     * Represents the primary address line for an address.
     * This field typically contains the main address details, such as street address,
     * building number, or any primary information required for identification of the
     * location. It helps in providing a complete and structured address.
     */
    private String addressLine1;

    /**
     * Represents the second line of the address.
     * This field is typically used to provide additional address details
     * such as apartment, suite, unit number, or any other secondary address information.
     */
    private String addressLine2;

    /**
     * Represents the city associated with an address.
     * This field stores the name of the city or locality where the address is located.
     * It is used for geographic identification and is a key component
     * in defining the complete address.
     */
    private String city;

    /**
     * Represents the state associated with an address.
     * This field stores the name or abbreviation of the administrative
     * division (e.g., state, province, or region) in which the address is located.
     * It is used for regional identification and validation purposes.
     */
    private String state;

    /**
     * Represents the ZIP code associated with an address.
     * This field stores the postal code used for regional identification
     * and is essential for mail delivery and address verification purposes.
     */
    private String zipCode;

    /**
     * Represents the start date associated with an address.
     * This field indicates the initial validity date for the address and is used
     * to determine when the address begins to be applicable or valid.
     * It is essential for maintaining historical and current address information.
     */
    private LocalDate startDate;

    /**
     * Represents the end date associated with an address.
     * This field specifies the final validity date for the address
     * and determines when the address is no longer applicable or valid.
     * It is useful for maintaining accurate and up-to-date address records.
     */
    private LocalDate endDate;
}
