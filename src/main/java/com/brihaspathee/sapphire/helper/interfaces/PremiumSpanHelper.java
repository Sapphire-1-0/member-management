package com.brihaspathee.sapphire.helper.interfaces;

import com.brihaspathee.sapphire.domain.document.PremiumSpan;
import com.brihaspathee.sapphire.model.PremiumSpanDto;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 02, February 2025
 * Time: 4:19 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.helper.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface PremiumSpanHelper {

    /**
     * Saves a list of premium span data transfer objects (PremiumSpanDto) to the system.
     * This method processes the provided premium span data, persists it, and returns
     * a list of the updated or saved PremiumSpanDto objects.
     *
     * @param premiumSpanDtos a list of PremiumSpanDto objects representing the premium spans to be saved.
     *                        Each object contains details such as premium span ID, code, start and end dates,
     *                        total premium amount, responsible amount, subsidies (e.g., APTC and CSR),
     *                        and associated member premiums.
     * @return a list of PremiumSpanDto objects that were successfully saved. The returned objects
     *         may include updated fields such as identifiers or system-generated data.
     */
    List<PremiumSpanDto> savePremiumSpans(List<PremiumSpanDto> premiumSpanDtos);

}
