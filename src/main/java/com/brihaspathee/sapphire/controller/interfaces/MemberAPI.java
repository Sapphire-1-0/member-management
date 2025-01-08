package com.brihaspathee.sapphire.controller.interfaces;

import com.brihaspathee.sapphire.domain.elastic.documents.Member;
import com.brihaspathee.sapphire.model.MemberList;
import com.brihaspathee.sapphire.model.MemberSearchParamDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 12, December 2024
 * Time: 6:25 AM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.controller.interfaces
 * To change this template use File | Settings | File and Code Template
 */
@RequestMapping("/api/v1/sapphire/member")
@Validated
public interface MemberAPI {

    /**
     * Add the member to elastic search
     * @param member - member to be added to elastic
     * @return - the member added to elastic
     */
    @PostMapping
    ResponseEntity<Long> addMember(@Valid @RequestBody Member member);

    /**
     * Add the member to elastic search using client
     * @param member - member to be added to elastic
     * @return - the member added to elastic
     */
    @PostMapping("/elastic-search-client")
    ResponseEntity<Long> addMemberUsingClient(@Valid @RequestBody Member member) throws IOException;

    /**
     * Update member's first name using the client
     * @param member - the member who needs to be updated
     * @return - return a status code
     * @throws IOException - Exception is generated
     */
    @PutMapping("/elastic-search-client/update")
    ResponseEntity<Void> updateMemberUsingClient(@Valid @RequestBody Member member) throws IOException;

    /**
     * Find the member by memberId
     * @param memberId - Id of the member to be found
     * @return - return the member found
     */
    @GetMapping("/{memberId}")
    ResponseEntity<Member> findMemberById(@PathVariable("memberId") @Valid Long memberId);

    /**
     * Find the member by memberId using elastic search client
     * @param memberId - Id of the member to be found
     * @return - return the member found
     */
    @GetMapping("/elastic-search-client/{memberId}")
    ResponseEntity<Member> findMemberByIdUsingElasticSearchClient(@PathVariable("memberId") @Valid Long memberId);

    /**
     * Delete the member from elastic
     * @param memberId - Id of the member to be deleted
     * @return - return void
     */
    @DeleteMapping("/{memberId}")
    ResponseEntity<Void> deleteMemberById(@PathVariable("memberId") @Valid Long memberId);

    /**
     * Search for members using the search parameters
     * @param searchParam - Search parameters for matching members
     * @return - Matched member list
     */
    @PostMapping("/search")
    ResponseEntity<MemberList> searchMembers(@Valid @RequestBody MemberSearchParamDto searchParam) throws IOException;

    /**
     * Delete all the members from elastic
     * @return - return void
     */
    @DeleteMapping
    ResponseEntity<Void> deleteAll();
}
