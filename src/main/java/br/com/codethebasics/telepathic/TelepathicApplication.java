package br.com.codethebasics.telepathic;

import br.com.codethebasics.telepathic.bot.TelepathicBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TelepathicApplication {

    private static TelepathicBot telepathicBot;

    @Autowired
    public TelepathicApplication(TelepathicBot telepathicBot) {
        this.telepathicBot = telepathicBot;
    }

    public static void main(String[] args) {
        SpringApplication.run(TelepathicApplication.class, args);
        telepathicBot.listenForUpdates();
    }
}
