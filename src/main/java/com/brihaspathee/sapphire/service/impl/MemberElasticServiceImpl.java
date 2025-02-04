package com.brihaspathee.sapphire.service.impl;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch._types.query_dsl.*;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.JsonData;
import com.brihaspathee.sapphire.domain.elastic.documents.Member;
import com.brihaspathee.sapphire.domain.elastic.index.Indexes;
import com.brihaspathee.sapphire.domain.elastic.repository.MemberElasticRepository;
import com.brihaspathee.sapphire.model.MemberSearchParamDto;
import com.brihaspathee.sapphire.service.interfaces.MemberElasticService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
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
public class MemberElasticServiceImpl implements MemberElasticService {

    /**
     * Instance of member repository
     */
    private final MemberElasticRepository memberElasticRepository;

    /**
     * Instance of elastic search client
     */
    private final ElasticsearchClient elasticsearchClient;

    /**
     * Instance of elastic search operations
     */
    private final ElasticsearchOperations elasticsearchOperations;


    /**
     * Save the member to elastic
     * @param member - member to be saved
     * @return - return the saved member
     */
    @Override
    public Member save(Member member) {
        log.info("Saving member: {}", member);
        Member savedMember = memberElasticRepository.save(member);
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
     * Find member by member id using elastic repository
     * @param memberId - the memberID of the member to be searched
     * @return - return the member found
     */
    @Override
    public Member findById(Long memberId) {
        Optional<Member> member = memberElasticRepository.findById(memberId);
        if (member.isPresent()) {
            log.info("Member was found");
        }else {
            log.info("Member was not found");
        }
        return memberElasticRepository.findById(memberId).orElse(null);
    }

    /**
     * Find the member by id using elastic search client
     * @param memberId - member id of them member that needs to be searched
     * @return - return the member
     */
    @Override
    public Member findMemberById(Long memberId) {
        try{
            GetRequest getRequest = GetRequest.of(g -> g.index(Indexes.MEMBER_INDEX)
                    .id(String.valueOf(memberId)));
            GetResponse<Member> response = elasticsearchClient.get(getRequest, Member.class);

            // Check if document exists
            if(response.found()){
                return response.source();
            }else{
                log.info("Member was not found");
                return null;
            }
        }catch (Exception e){
            log.error("Exception occurred while getting member", e);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Delete the member from elastic
     * @param memberId - id of the member to be deleted
     */
    @Override
    public void deleteById(Long memberId) {
        memberElasticRepository.deleteById(memberId);
    }

    /**
     * Delete all the members from elastic
     */
    @Override
    public void deleteAll() {
        memberElasticRepository.deleteAll();
    }

    /**
     * Search for members based on search parameters
     * @param searchParamDto - The search parameters passed
     * @return - return the matched members
     */
    @Override
    public List<Member> memberSearch(MemberSearchParamDto searchParamDto) throws IOException {
        return getMembersUsingCriteriaQuery(searchParamDto);
        // return getMembersUsingElasticSearchClient(searchParamDto);

    }

    private List<Member> getMembersUsingCriteriaQuery(MemberSearchParamDto searchParamDto) throws IOException {
        Criteria criteria = new Criteria();
        if(searchParamDto.getSearchMap() != null){
            for (Map.Entry<String, String> entry : searchParamDto.getSearchMap().entrySet()) {
                String field = entry.getKey();
                String value = entry.getValue();
                if(searchParamDto.isExactMatch()){
                    criteria = criteria.and(Criteria.where(field).is(value));
                }else{
                    // Contains (wildcard) and StartsWith (prefix) logic
                    criteria = criteria.and(
                            Criteria.where(field).matches(String.format(".*%s.*", value)) // Wildcard for "contains"
                                    .or(Criteria.where(field + ".keyword").startsWith(value))); // StartsWith for "prefix"
                }
            }
        }

        // Add the date of birth date range
        if (searchParamDto.getFormattedDateOfBirthFrom() != null ||
        searchParamDto.getFormattedDateOfBirthTo() != null) {
            Criteria dateOfBirthCriteria = Criteria.where("birthDate");

            if (searchParamDto.getFormattedDateOfBirthFrom() != null &&
                    searchParamDto.getFormattedDateOfBirthTo() != null) {
                // If both date ranges are provided add both to the criteria
                dateOfBirthCriteria = dateOfBirthCriteria.between(
                        searchParamDto.getFormattedDateOfBirthFrom(),
                        searchParamDto.getFormattedDateOfBirthTo());
            }else if (searchParamDto.getFormattedDateOfBirthFrom() != null) {
                // only from date is provided
                dateOfBirthCriteria = dateOfBirthCriteria.greaterThanEqual(searchParamDto.getFormattedDateOfBirthFrom());
            } else if (searchParamDto.getFormattedDateOfBirthTo() != null) {
                // only to date os provided
                dateOfBirthCriteria = dateOfBirthCriteria.lessThanEqual(searchParamDto.getFormattedDateOfBirthTo());
            }
            criteria = criteria.and(dateOfBirthCriteria);
        }

        // Build the query
        CriteriaQuery criteriaQuery = new CriteriaQuery(criteria);
        // Add sorting id provided
        if (searchParamDto.getSortField() != null) {
            criteriaQuery.addSort(searchParamDto
                    .getSortOrder()
                    .equalsIgnoreCase("desc")
                    ? Sort.by(Sort.Order.desc(searchParamDto.getSortField() + ".keyword"))
                    : Sort.by(Sort.Order.asc(searchParamDto.getSortField() + ".keyword")));
        }else {
            // default sorting
            criteriaQuery.addSort(Sort.by(Sort.Order.asc("firstName.keyword")));
        }

        // Execute the search
        SearchHits<Member> searchHits = elasticsearchOperations.search(criteriaQuery, Member.class);

        // Convert search hits to a list of members

        return searchHits.getSearchHits()
                .stream()
                .map(SearchHit::getContent)
                .toList();
    }

    /**
     * This method uses the elastic search client to perform the query and search for the members
     * @param searchParamDto - Search parameters provided
     * @return - return the list of matching members
     * @throws IOException - IOException generated by the method
     */
    private List<Member> getMembersUsingElasticSearchClient(MemberSearchParamDto searchParamDto) throws IOException {
        // Build the bool query
        BoolQuery.Builder boolQueryBuilder = new BoolQuery.Builder();

        // Add match queries for each field from the searchMap
        if(searchParamDto.getSearchMap() != null){
            if(searchParamDto.isExactMatch()){
                for (Map.Entry<String, String> entry: searchParamDto.getSearchMap().entrySet()) {
                    String field = entry.getKey();
                    String value = entry.getValue();
                    log.info("Field: {}", field);
                    log.info("Value: {}", value);
                    boolQueryBuilder.must(m -> m.match(MatchQuery.of(mt -> mt.field(field).query(value))));
                }
            }else{
                for (Map.Entry<String, String> entry: searchParamDto.getSearchMap().entrySet()) {
                    String field = entry.getKey();
                    String value = entry.getValue();
                    log.info("Field: {}", field);
                    log.info("Value: {}", value);
                    boolQueryBuilder.should(m -> m.wildcard(WildcardQuery.of(mt -> mt.field(field).value("*" + value + "*"))));
                    boolQueryBuilder.should(m -> m.prefix(PrefixQuery.of(p -> p.field(field + ".keyword").value(value))));
                }
            }

        }

        // Add the date of birth range filter if either from or to is provided
//        if (searchParamDto.getFormattedDateOfBirthFrom() != null || searchParamDto.getFormattedDateOfBirthTo() != null) {
//            RangeQuery.Builder rangeQueryBuilder = new RangeQuery.Builder();
//            rangeQueryBuilder.field("birthDate");
//            if (searchParamDto.getFormattedDateOfBirthFrom() != null) {
//                rangeQueryBuilder.gte(JsonData.of(searchParamDto.getFormattedDateOfBirthFrom()));
//            }
//            if (searchParamDto.getFormattedDateOfBirthTo() != null) {
//                rangeQueryBuilder.lte(JsonData.of(searchParamDto.getFormattedDateOfBirthTo()));
//            }
//            boolQueryBuilder.filter(f -> f.range(rangeQueryBuilder.build()));
//        }

        if (searchParamDto.getFormattedDateOfBirthFrom() != null || searchParamDto.getFormattedDateOfBirthTo() != null) {
            Query rangeQuery = Query.of(query -> query.range(r -> r.untyped(u -> {
                u.field("birthDate");
                if (searchParamDto.getFormattedDateOfBirthFrom() != null) {
                    u.gte(JsonData.of(searchParamDto.getFormattedDateOfBirthFrom()));
                }
                if (searchParamDto.getFormattedDateOfBirthTo() != null) {
                    u.lte(JsonData.of(searchParamDto.getFormattedDateOfBirthTo()));
                }
                return u;
            })));
            boolQueryBuilder.filter(rangeQuery);
        }


        SearchRequest searchRequest = SearchRequest.of(s -> {
            s.index(Indexes.MEMBER_INDEX)
                    .query(q -> q.bool(boolQueryBuilder.build()));

            // add sorting
            s.sort(sort -> {
                // Determine the field for sorting
                String fieldToSort = searchParamDto.getSortField() != null
                        ? searchParamDto.getSortField() + ".keyword"
                        : "firstName.keyword"; // Default to "firstName"

                // Determine the sort order
                SortOrder sortOrder = "desc".equalsIgnoreCase(searchParamDto.getSortOrder())
                        ? SortOrder.Desc
                        : SortOrder.Asc; // Default to Ascending

                return sort.field(sf -> sf.field(fieldToSort).order(sortOrder));
            });
            return s;
                });

        log.info("Executing search request: {}", searchRequest);
        // perform the search query
        SearchResponse<Member> searchResponse = elasticsearchClient.search(searchRequest, Member.class);

        // Return the list of matching members
        return searchResponse.hits().hits().stream()
                .map(Hit::source).toList();
    }
}
