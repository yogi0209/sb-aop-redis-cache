package com.yogendra.sbaoprediscache.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleBookServiceResponse {
    public List<GoogleBook> items;
}
