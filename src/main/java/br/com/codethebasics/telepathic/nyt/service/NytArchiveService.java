package br.com.codethebasics.telepathic.nyt.service;

import br.com.codethebasics.telepathic.nyt.model.ArchiveResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NytArchiveService {

    private static final String NYT_ARCHIVE_ENDPOINT = "https://api.nytimes.com/svc/archive/v1";

    public ArchiveResponse get(Integer year, Integer month) {
        String endpoint = NYT_ARCHIVE_ENDPOINT + "/" + year + "/" + month + ".json?api-key=svktDgBoIlbItbyL4fAPw4GQkHWnZYmy";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ArchiveResponse> response = restTemplate.getForEntity(endpoint, ArchiveResponse.class);
        return response.getBody();
    }
}
