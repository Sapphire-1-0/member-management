package com.brihaspathee.sapphire.domain.elastic.repository;

import com.brihaspathee.sapphire.domain.elastic.documents.Member;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 12, December 2024
 * Time: 6:20 AM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.domain.elastic.repository
 * To change this template use File | Settings | File and Code Template
 */
@Repository
public interface MemberElasticRepository extends ElasticsearchRepository<Member, Long> {
}
