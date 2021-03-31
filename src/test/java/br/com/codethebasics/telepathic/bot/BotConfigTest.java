package br.com.codethebasics.telepathic.bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BotConfigTest {

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void helloBotTest() {
        TelegramBot bot = new TelegramBot("1688657217:AAFRN6cxwaLKe2bjsRem-iUwSvPjySx3nw8");
        bot.setUpdatesListener(updates -> {
            updates.forEach(update -> {
                long chatId = update.message().chat().id();
                SendResponse response = bot.execute(new SendMessage(chatId, "Hello!"));
            });
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }
}