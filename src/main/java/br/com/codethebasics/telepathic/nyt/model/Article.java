package br.com.codethebasics.telepathic.nyt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Article {

    @JsonProperty("web_url")
    private String webUrl;

    @JsonProperty("snippet")
    private String snippet;

    @JsonProperty("print_page")
    private Integer printPage;

    @JsonProperty("source")
    private String source;

    @JsonProperty("multimedia")
    private Multimedia[] multimedia;

    @JsonProperty("headline")
    private Headline headline;

    @JsonProperty("keywords")
    private Keyword[] keywords;

    @JsonProperty("pub_date")
    private String pubDate;

    @JsonProperty("document_type")
    private String documentType;

    @JsonProperty("news_desk")
    private String newsDesk;

    @JsonProperty("byline")
    private Byline byline;

    @JsonProperty("type_of_material")
    private String typeOfMaterial;

    @JsonProperty("_id")
    private String id;

    @JsonProperty("word_count")
    private Integer wordCount;

    @JsonProperty("score")
    private Integer score;

    @JsonProperty("uri")
    private String uri;
}
