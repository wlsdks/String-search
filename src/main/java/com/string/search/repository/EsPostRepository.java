package com.string.search.repository;

import com.string.search.document.Post;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import reactor.core.publisher.Flux;

public interface EsPostRepository extends ReactiveElasticsearchRepository<Post, String> {

    Flux<Post> findPostsByMember_MemberId(String memberId);

}
