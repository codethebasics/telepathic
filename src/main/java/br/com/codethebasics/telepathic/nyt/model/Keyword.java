package br.com.codethebasics.telepathic.nyt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Keyword {

    @JsonProperty("name")
    private String name;

    @JsonProperty("value")
    private String value;

    @JsonProperty("rank")
    private Integer rank;

    @JsonProperty("major")
    private String major;
}
