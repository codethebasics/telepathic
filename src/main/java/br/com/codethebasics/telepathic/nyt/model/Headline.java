package br.com.codethebasics.telepathic.nyt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Headline {

    @JsonProperty("main")
    private String main;

    @JsonProperty("kicker")
    private String kicker;

    @JsonProperty("content_kicker")
    private String contentKicker;

    @JsonProperty("print_headline")
    private String printHeadline;

    @JsonProperty("name")
    private String name;

    @JsonProperty("seo")
    private String seo;

    @JsonProperty("sub")
    private String sub;

}
