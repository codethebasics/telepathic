package br.com.codethebasics.telepathic.bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public class TelepathicBot {

    @Value("${telegram.bot.token}")
    private String token;

    private TelegramBot bot;

    public TelepathicBot() {
        initBot();
    }

    private void initBot() {
        this.bot = new TelegramBot("1688657217:AAFRN6cxwaLKe2bjsRem-iUwSvPjySx3nw8");
    }

    /**
     * Listening for chat updates
     */
    public void listenForUpdates() {
        try {
            if (this.bot == null) {
                throw new Exception("There's no bot started.");
            }
            this.bot.setUpdatesListener(this::processUpdates);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Processing a list of updates
     * @param updates
     */
    private int processUpdates(List<Update> updates) {
        try {
            updates.forEach(this::processUpdate);
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        }
        catch (Exception e) {
            return UpdatesListener.CONFIRMED_UPDATES_NONE;
        }
    }

    /**
     * Processing an update
     * @param update
     */
    private void processUpdate(Update update) {
        try {
            String receivedMessage = update.message().text();
            sendMessage("You said '" + receivedMessage + "'", update.message().chat().id());
        }
        catch (Exception e) {
            e.printStackTrace();
            sendMessage("Cannot process update.", update.message().chat().id());
        }
    }

    /**
     * Send a message to a chat
     * @param text
     * @param chatId
     */
    private void sendMessage(String text, long chatId) {
        try {
            bot.execute(new SendMessage(chatId, text));
        }
        catch (Exception e) {
            bot.execute(new SendMessage(chatId, "Cannot send message."));
        }
    }
}
