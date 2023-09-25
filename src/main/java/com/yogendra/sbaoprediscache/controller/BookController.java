package com.yogendra.sbaoprediscache.controller;

import com.yogendra.sbaoprediscache.aspect.PerformanceLogger;
import com.yogendra.sbaoprediscache.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.yogendra.sbaoprediscache.model.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;


    @GetMapping("books")
    @PerformanceLogger
    public ResponseEntity<List<GoogleBook>> getBookVolumes(@RequestParam("search") String search) {
        GoogleBookServiceResponse response = bookService.getBookVolumes(search);
        return ResponseEntity.ok(response.items);
    }
}
