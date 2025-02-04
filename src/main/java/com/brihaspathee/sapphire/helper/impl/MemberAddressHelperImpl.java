package com.brihaspathee.sapphire.helper.impl;

import com.brihaspathee.sapphire.domain.document.Address;
import com.brihaspathee.sapphire.helper.interfaces.MemberAddressHelper;
import com.brihaspathee.sapphire.model.AddressDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 01, February 2025
 * Time: 7:41 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.helper.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class MemberAddressHelperImpl implements MemberAddressHelper {

    /**
     * Converts a list of AddressDto objects into a list of Address objects.
     *
     * @param addressDtos the list of AddressDto objects to be converted. Each AddressDto contains
     *                    details such as address code, type, lines, city, state, zip code,
     *                    start and end date.
     * @return a list of Address objects containing the converted address details.
     */
    @Override
    public List<Address> getAddress(List<AddressDto> addressDtos) {
        if(addressDtos == null || addressDtos.isEmpty()) return null;
        return addressDtos.stream().map(addressDto -> Address.builder()
                .addressCode(addressDto.getAddressCode())
                .addressType(addressDto.getAddressType())
                .addressLine1(addressDto.getAddressLine1())
                .addressLine2(addressDto.getAddressLine2())
                .city(addressDto.getCity())
                .state(addressDto.getState())
                .zipCode(addressDto.getZipCode())
                .startDate(addressDto.getStartDate())
                .endDate(addressDto.getEndDate())
                .build()).toList();
    }
}
