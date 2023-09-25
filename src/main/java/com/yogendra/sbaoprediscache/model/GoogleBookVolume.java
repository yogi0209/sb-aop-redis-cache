package com.yogendra.sbaoprediscache.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleBookVolume {
    @Getter
    String title;
    @Getter
    String subtitle;
}
