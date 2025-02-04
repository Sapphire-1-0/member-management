package com.brihaspathee.sapphire.domain.repository;

import com.brihaspathee.sapphire.domain.document.PremiumSpan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 02, February 2025
 * Time: 4:22 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.domain.repository
 * To change this template use File | Settings | File and Code Template
 */
@Repository
public interface PremiumSpanRepository extends MongoRepository<PremiumSpan, String> {
}
