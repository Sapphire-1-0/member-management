package com.brihaspathee.sapphire.service.interfaces;

import com.brihaspathee.sapphire.domain.elastic.documents.Member;

import java.io.IOException;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 12, December 2024
 * Time: 6:23 AM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.service.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface MemberService {

    /**
     * Save the member to elastic
     * @param member - member to be saved
     * @return - return the saved member
     */
    Member save(Member member);

    /**
     * Save the member to elastic using elastic search client
     * @param member - member to be saved
     * @return - member that was saved to the index
     * @throws IOException - Exception is generated
     */
    Member saveUsingClient(Member member) throws IOException;

    /**
     * Update the member information in elastic search using the repository
     * @param member - the member who needs to be updated
     * @throws IOException - IOException is thrown
     */
    void update(Member member) throws IOException;

    /**
     * Update the member information in elastic search using the elastic search client
     * @param memberId - Id of the member that needs to be updated
     * @param firstName - the first name of the member is to be updated
     * @throws IOException - IOException is thrown
     */
    void updateUsingClient(Long memberId, String firstName) throws IOException;

    /**
     * Find member by member id
     * @param memberId - the memberID of the member to be searched
     * @return - return the member found
     */
    Member findById(Long memberId);

    /**
     * Delete the member from elastic
     * @param memberId - id of the member to be deleted
     */
    void deleteById(Long memberId);

    /**
     * Delete all the members from elastic
     */
    void deleteAll();
}
