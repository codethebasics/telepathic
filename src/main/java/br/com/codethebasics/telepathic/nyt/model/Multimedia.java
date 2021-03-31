package br.com.codethebasics.telepathic.nyt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Multimedia {

    @JsonProperty("rank")
    private Integer rank;

    @JsonProperty("subtype")
    private String subtype;

    @JsonProperty("caption")
    private String caption;

    @JsonProperty("credit")
    private String credit;

    @JsonProperty("type")
    private String type;

    @JsonProperty("url")
    private String url;

    @JsonProperty("height")
    private Integer height;

    @JsonProperty("width")
    private Integer width;

    @JsonProperty("crop_name")
    private String cropName;

}
