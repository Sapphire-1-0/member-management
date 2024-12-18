package com.brihaspathee.sapphire.service.impl;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.UpdateRequest;
import co.elastic.clients.elasticsearch.core.UpdateResponse;
import com.brihaspathee.sapphire.domain.elastic.documents.Member;
import com.brihaspathee.sapphire.domain.elastic.index.Indexes;
import com.brihaspathee.sapphire.domain.elastic.repository.MemberRepository;
import com.brihaspathee.sapphire.service.interfaces.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 12, December 2024
 * Time: 6:23 AM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.service.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    /**
     * Instance of member repository
     */
    private final MemberRepository memberRepository;

    /**
     * Instance of elastic search client
     */
    private final ElasticsearchClient elasticsearchClient;

    /**
     * Save the member to elastic
     * @param member - member to be saved
     * @return - return the saved member
     */
    @Override
    public Member save(Member member) {
        log.info("Saving member: {}", member);
        Member savedMember = memberRepository.save(member);
        log.info("Saved member: {}", savedMember);
        return savedMember;
    }

    /**
     * Save the member to elastic using elastic search client
     * @param member - member to be saved
     * @return - member that was saved to the index
     */
    @Override
    public Member saveUsingClient(Member member) throws IOException {
        // Build the index request
        IndexRequest<Member> indexRequest = IndexRequest.of(i -> i
                .index(Indexes.MEMBER_INDEX)
                .id(String.valueOf(member.getMemberId()))
                .document(member));
        // Index the member using Elastic search client
        IndexResponse indexResponse = elasticsearchClient.index(indexRequest);
        log.info("Member indexed with ID: {}", indexResponse.id());
        return member;
    }

    /**
     * Update the member information in elastic search using the repository
     * @param member - the member who needs to be updated
     * @throws IOException - IOException is thrown
     */
    @Override
    public void update(Member member) throws IOException {

    }

    /**
     * Update the member information in elastic search using the elastic search client
     * @param memberId - Id of the member that needs to be updated
     * @param firstName - the first name of the member is to be updated
     * @throws IOException - IOException is thrown
     */
    @Override
    public void updateUsingClient(Long memberId, String firstName) throws IOException {
        Map<String, Object> updates = Map.of("firstName", firstName);

        UpdateRequest updateRequest = UpdateRequest.of(u -> u
                .index(Indexes.MEMBER_INDEX)
                .id(String.valueOf(memberId))
                .doc(updates));

        UpdateResponse updateResponse = elasticsearchClient.update(updateRequest, Map.class);
        log.info("Member info updated: {}", updateResponse.result());
    }


    /**
     * Find member by member id
     * @param memberId - the memberID of the member to be searched
     * @return - return the member found
     */
    @Override
    public Member findById(Long memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        if (member.isPresent()) {
            log.info("Member was found");
        }else {
            log.info("Member was not found");
        }
        return memberRepository.findById(memberId).orElse(null);
    }

    /**
     * Delete the member from elastic
     * @param memberId - id of the member to be deleted
     */
    @Override
    public void deleteById(Long memberId) {
        memberRepository.deleteById(memberId);
    }

    /**
     * Delete all the members from elastic
     */
    @Override
    public void deleteAll() {
        memberRepository.deleteAll();
    }
}
