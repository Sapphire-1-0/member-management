package com.brihaspathee.sapphire.domain.repository;

import com.brihaspathee.sapphire.domain.document.Member;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 01, February 2025
 * Time: 6:57 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.domain.repository
 * To change this template use File | Settings | File and Code Template
 */
@Repository
public interface MemberRepository extends MongoRepository<Member, String> {
}
