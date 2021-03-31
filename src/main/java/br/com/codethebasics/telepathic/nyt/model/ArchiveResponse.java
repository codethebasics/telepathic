package br.com.codethebasics.telepathic.nyt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArchiveResponse {

    @JsonProperty("copyright")
    private String copyright;

    @JsonProperty("response")
    private Response response;
}
