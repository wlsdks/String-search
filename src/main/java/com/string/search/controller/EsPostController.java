package com.string.search.controller;

import com.string.search.document.Post;
import com.string.search.service.EsPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RequestMapping("/elastic/post")
@RequiredArgsConstructor
@RestController
public class EsPostController {

    private final EsPostService esPostService;


    /**
     * 클라이언트로부터 JSON 형태의 Post 데이터를 받아 엘라스틱서치의 지정된 인덱스에 저장합니다.
     */
    @PostMapping("/create")
    public Mono<Post> createPostDocument(@RequestBody Post post) {
        return esPostService.createPostDocument(post);
    }

    /**
     * 클라이언트로부터 memberId를 받아 해당 memberId를 가지는 모든 Post를 엘라스틱서치에서 검색합니다.
     */
    @GetMapping("/search")
    public Flux<Post> searchPosts(@RequestParam String memberId) {
        return esPostService.searchPosts(memberId);
    }

}
