package br.com.codethebasics.telepathic.nyt.service;

import br.com.codethebasics.telepathic.nyt.model.ArchiveResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NytArchiveService {

    @Value("${nyt.root.uri}")
    private String nytRootUri;

    @Value("${nyt.archive.uri}")
    private String archiveUri;

    public ArchiveResponse get(Integer year, Integer month) {

        String endpoint = nytRootUri
            + archiveUri + "/"
            + year + "/"
            + month + ".json?api-key=";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ArchiveResponse> response = restTemplate.getForEntity(endpoint, ArchiveResponse.class);

        return response.getBody();
    }
}
