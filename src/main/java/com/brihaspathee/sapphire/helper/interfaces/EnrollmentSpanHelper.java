package com.brihaspathee.sapphire.helper.interfaces;

import com.brihaspathee.sapphire.model.EnrollmentSpanDto;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 02, February 2025
 * Time: 6:29 AM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.helper.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface EnrollmentSpanHelper {

    /**
     * Saves a list of enrollment span data transfer objects (EnrollmentSpanDto) to the system.
     * The method is responsible for persisting the information for each enrollment span
     * included in the provided list and returns the saved enrollment span objects.
     *
     * @param enrollmentSpanDtos a list of EnrollmentSpanDto objects representing the details
     *                            of enrollment spans to be saved into the system. Each object
     *                            contains information such as enrollment span ID, code, business
     *                            unit, start and end dates, plan details, group policy details,
     *                            and payment dates.
     * @return a list of EnrollmentSpanDto objects that were successfully saved. The returned
     *         objects may include updated fields such as generated identifiers or modified data
     *         based on system rules during the save operation.
     */
    List<EnrollmentSpanDto> saveEnrollmentSpans(List<EnrollmentSpanDto> enrollmentSpanDtos);
}
