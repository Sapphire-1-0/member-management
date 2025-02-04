package com.brihaspathee.sapphire.helper.interfaces;

import com.brihaspathee.sapphire.domain.document.Address;
import com.brihaspathee.sapphire.model.AddressDto;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 01, February 2025
 * Time: 7:40 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.helper.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface MemberAddressHelper {

    /**
     * Converts a list of AddressDto objects into a list of Address objects.
     *
     * @param addressDtos the list of AddressDto objects to be converted. Each AddressDto contains
     *                    address details such as address code, type, lines, city, state, zip code,
     *                    start and end date.
     * @return a list of Address objects containing the converted address details.
     */
    List<Address> getAddress(List<AddressDto> addressDtos);
}
