package com.brihaspathee.sapphire.model;

import lombok.*;

import java.time.LocalDate;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 01, February 2025
 * Time: 7:35 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    /**
     * Represents a unique code corresponding to an address.
     * This field is used to identify or differentiate one address
     * from another within the system. The code may reflect an
     * address's uniqueness, categorization, or external reference.
     */
    private String addressCode;

    /**
     * Represents the type of the address.
     * This field is used to specify the category of the address,
     * such as 'Residential', 'Business', or 'Postal', to distinguish
     * among different address purposes.
     */
    private String addressType;

    /**
     * Represents the primary line of the address.
     * This field is used to capture the main street address or other primary
     * location details such as house number and street.
     */
    private String addressLine1;

    /**
     * Represents an optional second line of the address.
     * This field can be used to capture additional address details such as
     * apartment numbers, suites, or other specific location information.
     */
    private String addressLine2;

    /**
     * Represents the city associated with the address.
     * This value denotes the specific city where the address is located.
     */
    private String city;

    /**
     * Represents the state where the address is located.
     * This value is associated with the geographical region
     * for the address.
     */
    private String state;

    /**
     * Represents the zip code associated with the address.
     */
    private String zipCode;

    /**
     * Represents the start date associated with the address.
     * This field indicates the initial date from which the address is considered valid.
     */
    private LocalDate startDate;

    /**
     * Represents the end date associated with the address.
     * This field indicates the final date until which the address is valid.
     */
    private LocalDate endDate;
}
