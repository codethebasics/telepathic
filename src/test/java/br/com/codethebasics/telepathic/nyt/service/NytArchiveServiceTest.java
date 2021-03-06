package br.com.codethebasics.telepathic.nyt.service;

import br.com.codethebasics.telepathic.nyt.model.ArchiveResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NytArchiveServiceTest {

    @Autowired
    private NytArchiveService nytArchiveService;

    @BeforeEach
    void setUp() {

    }

    @DisplayName("Given a year/month, when get archive, then return archive response")
    @Test
    public void givenYearMonth_whenGetArchive_thenReturnArchiveResponse() {

        // given
        int year = 1987;
        int month = 7;

        // when
        ArchiveResponse archiveResponse = nytArchiveService.get(year, month);

        // then
        assertAll("Testing NYT Archive response",
            () -> assertNotNull(archiveResponse, "ArchiveResponse shouldn't be null"),
            () -> assertNotNull(archiveResponse.getResponse(), "Response shouldn't be null"),
            () -> assertNotNull(archiveResponse.getResponse().getDocs(), "Docs shouldn't be null"),
            () -> assertNotNull(archiveResponse.getResponse().getDocs()[0].getMultimedia(), "Multimedia shouldn't be null"));
    }
}