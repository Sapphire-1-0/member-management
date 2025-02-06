package com.brihaspathee.sapphire.mapper.interfaces;

import com.brihaspathee.sapphire.domain.document.Member;
import com.brihaspathee.sapphire.model.MemberDto;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 2/5/25
 * Time: 6:48 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.mapper.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface MemberMapper {

    MemberDto toDto(Member member);

    Member toDocument(MemberDto memberDto);

    List<MemberDto> toDtos(List<Member> members);

    /**
     *
     */
    List<Member> toDocuments(List<MemberDto> memberDtos);
}
