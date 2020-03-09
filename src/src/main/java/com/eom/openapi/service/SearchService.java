package com.eom.openapi.service;

import com.eom.openapi.repository.response.*;
import com.eom.openapi.util.httpConfig.UriBuilder;
import com.eom.openapi.util.searchConfig.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private static final Logger logger = LoggerFactory.getLogger(SearchService.class);

    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;
    private final String uri;

    private String searchUri;

    // 생성자 주입: @Resource 미사용?
    private SearchService(RestTemplate restTemplate, HttpHeaders httpHeaders, String uri) {
        this.restTemplate = restTemplate;
        this.httpHeaders = httpHeaders;
        this.uri = uri;
    }

    public Map<String, Object> searchMovieAndBook(String query) {
        Map<String, Object> searchResponse = new HashMap<>();
        searchResponse.put("bookItems", searchBook(query));
        searchResponse.put("movieItems", searchMovie(query));
        return searchResponse;
    }

    public List<BookItems.BookItem> searchBook(String query) {
        UriBuilder uriBuilder = new UriBuilder(uri);
        searchUri = uriBuilder.createUrl(Category.BOOK.getCategory(), query);
        logger.debug("BookUrl : {}", searchUri);
        // exchange 메소드: header 정보 추가 가능(cf. getForObject 메소드)
        // stream 사용 위해 리턴 타입 변경(LIMIT 제한)
        logger.debug("Book 반환: {}", restTemplate.exchange(searchUri, HttpMethod.GET, new HttpEntity<>(httpHeaders), BookItems.class).getBody());
        return (List<BookItems.BookItem>) restTemplate.exchange(searchUri, HttpMethod.GET, new HttpEntity<>(httpHeaders), BookItems.class).getBody().getItems()
                .stream()
                .limit(3)
                .collect(Collectors.toList());
        // return restTemplate.exchange(searchUri, HttpMethod.GET, new HttpEntity<>(httpHeaders), BookItems.class).getBody();
    }

    private MovieItems searchMovie(String query) {
        UriBuilder uriBuilder = new UriBuilder(uri);
        searchUri = uriBuilder.createUrl(Category.MOVIE.getCategory(), query);
        logger.debug("MovieUrl : {}", searchUri);
        logger.debug("Movie 반환: {}", restTemplate.exchange(searchUri, HttpMethod.GET, new HttpEntity<>(httpHeaders), MovieItems.class).getBody());
        return restTemplate.exchange(searchUri, HttpMethod.GET, new HttpEntity<>(httpHeaders), MovieItems.class).getBody();
    }

    public BookItems test(String query) {
        UriBuilder uriBuilder = new UriBuilder(uri);
        searchUri = uriBuilder.createUrl(Category.BOOK.getCategory(), query);

        logger.debug("url : {}", searchUri);

        logger.info("확인1: {}", restTemplate.exchange(searchUri, HttpMethod.GET, new HttpEntity<>(httpHeaders), BookItems.class));
        logger.info("확인2: {}", restTemplate.exchange(searchUri, HttpMethod.GET, new HttpEntity<>(httpHeaders), BookItems.class).getBody());
        return restTemplate.exchange(searchUri, HttpMethod.GET, new HttpEntity<>(httpHeaders), BookItems.class).getBody();
    }
}
