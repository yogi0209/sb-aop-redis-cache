package com.yogendra.sbaoprediscache.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleBook {
    @Getter
    public GoogleBookVolume volumeInfo;
}
