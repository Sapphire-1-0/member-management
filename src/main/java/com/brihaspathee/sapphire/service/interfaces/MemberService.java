package com.brihaspathee.sapphire.service.interfaces;

import com.brihaspathee.sapphire.domain.document.Member;
import com.brihaspathee.sapphire.model.MemberDto;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 01, February 2025
 * Time: 6:55 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.service.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface MemberService {

    /**
     * Saves a list of MemberDto objects into the system.
     *
     * @param memberDtos the list of MemberDto objects to be saved
     * @return the list of MemberDto objects after they have been saved
     */
    List<MemberDto> saveMemberDtos(List<MemberDto> memberDtos);

    /**
     * Saves a list of members into the system.
     *
     * @param memberDtos the list of MemberDto objects to be saved
     * @return the list of Member objects after they have been saved
     */
    List<Member> saveMembers(List<MemberDto> memberDtos);
}
