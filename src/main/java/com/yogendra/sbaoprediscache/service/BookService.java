package com.yogendra.sbaoprediscache.service;

import com.yogendra.sbaoprediscache.aspect.Cacheable;
import com.yogendra.sbaoprediscache.model.GoogleBookServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookService {

    @Autowired
    RestTemplate restTemplate;

    @Cacheable
    public GoogleBookServiceResponse getBookVolumes(String name) {
        return restTemplate
                .getForObject("https://www.googleapis.com/books/v1/volumes?q={search}&max_results=2",
                        GoogleBookServiceResponse.class,
                        name);
    }
}
