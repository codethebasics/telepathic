package br.com.codethebasics.telepathic.nyt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("middlename")
    private String middlename;

    @JsonProperty("lastname")
    private String lastname;

    @JsonProperty("qualifier")
    private String qualifier;

    @JsonProperty("title")
    private String title;

    @JsonProperty("role")
    private String role;

    @JsonProperty("organization")
    private String organization;

    @JsonProperty("rank")
    private Integer rank;
}
