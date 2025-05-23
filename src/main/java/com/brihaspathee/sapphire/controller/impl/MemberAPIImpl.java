package com.brihaspathee.sapphire.controller.impl;

import com.brihaspathee.sapphire.controller.interfaces.MemberAPI;
import com.brihaspathee.sapphire.domain.elastic.documents.Member;
import com.brihaspathee.sapphire.model.MemberList;
import com.brihaspathee.sapphire.model.MemberSearchParamDto;
import com.brihaspathee.sapphire.service.interfaces.MemberElasticService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

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
    private final MemberElasticService memberElasticService;

    /**
     * Add the member to elastic search
     * @param member - member to be added to elastic
     * @return - the member added to elastic
     */
    @Override
    public ResponseEntity<Long> addMember(Member member) {
        return new ResponseEntity<>(memberElasticService.save(member).getMemberId(),
                HttpStatus.CREATED);
    }

    /**
     * Add the member to elastic search using client
     * @param member - member to be added to elastic
     * @return - the member added to elastic
     */
    @Override
    public ResponseEntity<Long> addMemberUsingClient(Member member) throws IOException {
        return new ResponseEntity<>(memberElasticService.saveUsingClient(member).getMemberId(),
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
        memberElasticService.updateUsingClient(member.getMemberId(), member.getFirstName());
        return ResponseEntity.noContent().build();
    }

    /**
     * Find member by member id
     * @param memberId - the memberID of the member to be searched
     * @return - return the member found
     */
    @Override
    public ResponseEntity<Member> findMemberById(Long memberId) {
        return ResponseEntity.ok(memberElasticService.findById(memberId));
    }

    /**
     * Find the member by memberId using elastic search client
     * @param memberId - Id of the member to be found
     * @return - return the member found
     */
    @Override
    public ResponseEntity<Member> findMemberByIdUsingElasticSearchClient(Long memberId) {
        return ResponseEntity.ok(memberElasticService.findMemberById(memberId));
    }

    /**
     * Delete the member from elastic
     * @param memberId - Id of the member to be deleted
     * @return - return void
     */
    @Override
    public ResponseEntity<Void> deleteMemberById(Long memberId) {
        memberElasticService.deleteById(memberId);
        return null;
    }

    /**
     * Search for members using the search parameters
     * @param searchParam - Search parameters for matching members
     * @return - Matched member list
     */
    @Override
    public ResponseEntity<MemberList> searchMembers(MemberSearchParamDto searchParam) throws IOException {
        List<Member> members = memberElasticService.memberSearch(searchParam);
        MemberList memberList = MemberList.builder().members(members).build();
        return new ResponseEntity<>(memberList, HttpStatus.OK);
    }

    /**
     * Delete all the members from elastic
     * @return - return void
     */
    @Override
    public ResponseEntity<Void> deleteAll() {
        memberElasticService.deleteAll();
        return null;
    }
}
