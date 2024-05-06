package com.string.search.service;

import com.string.search.document.Post;
import com.string.search.repository.EsPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class EsPostService {

    private final EsPostRepository esPostRepository;

    public Mono<Post> createPostDocument(Post post) {
        return esPostRepository.save(post)
                .onErrorResume(e -> {
                    System.out.println("saveDocumentError: " + e.getMessage());
                    return Mono.empty();
                });
    }

    public Flux<Post> searchPosts(String memberId) {
        return esPostRepository.findPostsByMember_MemberId(memberId)
                .onErrorResume(e -> {
                    System.out.println("searchPostsError: " + e.getMessage());
                    return Flux.empty();
                });
    }

}
