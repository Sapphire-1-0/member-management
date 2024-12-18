package com.brihaspathee.sapphire.controller.impl;

import com.brihaspathee.sapphire.controller.interfaces.MemberAPI;
import com.brihaspathee.sapphire.domain.elastic.documents.Member;
import com.brihaspathee.sapphire.service.interfaces.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 12, December 2024
 * Time: 6:27 AM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.controller.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberAPIImpl implements MemberAPI {

    /**
     * Instance of the member service
     */
    private final MemberService memberService;

    /**
     * Add the member to elastic search
     * @param member - member to be added to elastic
     * @return - the member added to elastic
     */
    @Override
    public ResponseEntity<Long> addMember(Member member) {
        return new ResponseEntity<>(memberService.save(member).getMemberId(),
                HttpStatus.CREATED);
    }

    /**
     * Add the member to elastic search using client
     * @param member - member to be added to elastic
     * @return - the member added to elastic
     */
    @Override
    public ResponseEntity<Long> addMemberUsingClient(Member member) throws IOException {
        return new ResponseEntity<>(memberService.saveUsingClient(member).getMemberId(),
                HttpStatus.CREATED);
    }

    /**
     * Update member's first name using the client
     * @param member - the member who needs to be updated
     * @return - return a status code
     * @throws IOException - Exception is generated
     */
    @Override
    public ResponseEntity<Void> updateMemberUsingClient(Member member) throws IOException {
        memberService.updateUsingClient(member.getMemberId(), member.getFirstName());
        return ResponseEntity.noContent().build();
    }

    /**
     * Find member by member id
     * @param memberId - the memberID of the member to be searched
     * @return - return the member found
     */
    @Override
    public ResponseEntity<Member> findMemberById(Long memberId) {
        return ResponseEntity.ok(memberService.findById(memberId));
    }

    /**
     * Delete the member from elastic
     * @param memberId - Id of the member to be deleted
     * @return - return void
     */
    @Override
    public ResponseEntity<Void> deleteMemberById(Long memberId) {
        memberService.deleteById(memberId);
        return null;
    }

    /**
     * Delete all the members from elastic
     * @return - return void
     */
    @Override
    public ResponseEntity<Void> deleteAll() {
        memberService.deleteAll();
        return null;
    }
}
