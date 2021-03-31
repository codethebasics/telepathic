package br.com.codethebasics.telepathic;

import br.com.codethebasics.telepathic.nyt.model.ArchiveResponse;
import br.com.codethebasics.telepathic.nyt.service.NytArchiveService;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import com.pengrad.telegrambot.response.SendResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TelepathicApplication {

    public static void main(String[] args) {

        NytArchiveService nytArchiveService = new NytArchiveService();

        TelegramBot bot = new TelegramBot("1688657217:AAFRN6cxwaLKe2bjsRem-iUwSvPjySx3nw8");
        bot.setUpdatesListener(updates -> {
            updates.forEach(update -> {
                if (update.message() != null) {
                    long chatId = update.message().chat().id();
                    try {
                        String text = update.message().text();
                        if (text.startsWith("::nyt-archive-")) {
                            String textFilter = text.replace("::nyt-archive-", "");
                            String[] params = textFilter.split("/");
                            if (params.length != 2) {
                                bot.execute(new SendMessage(chatId, "Parâmetros insuficientes."));
                            }
                            bot.execute(new SendMessage(chatId, "Sua solicitação está sendo procesada. Aguarde..."));
                            ArchiveResponse response = nytArchiveService.get(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
                            bot.execute(new SendPhoto(chatId, "https://www.nytimes.com/" + response.getResponse().getDocs()[0].getMultimedia()[0].getUrl()));
                            bot.execute(new SendMessage(chatId, response.getResponse().getDocs()[0].getAbstractAttr()));
                        }
                        else {
                            bot.execute(new SendMessage(chatId, "Comando inválido."));
                        }
                    }
                    catch (Exception e) {
                        bot.execute(new SendMessage(chatId, "Desculpe, não foi possível processar a sua requisição."));
                    }
                }
            });
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
//        SpringApplication.run(TelepathicApplication.class, args);
    }
}
