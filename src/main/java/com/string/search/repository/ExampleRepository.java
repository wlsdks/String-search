package com.string.search.repository;

import com.string.search.document.Example;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import reactor.core.publisher.Flux;

/**
 * ReactiveElasticsearchRepository를 사용하는 경우 비동기 처리가 적용되며, 이는 WebFlux와 함께 리액티브 프로그래밍 패러다임을 활용합니다.
 * 리액티브 프로그래밍은 비동기 데이터 스트림 처리에 초점을 맞추고 있어서, Mono와 Flux 타입을 반환하는 메소드들은 비동기적으로 동작합니다.
 */
public interface ExampleRepository extends ReactiveElasticsearchRepository<Example, String> {
    Flux<Example> findByContentContaining(String content);
}
