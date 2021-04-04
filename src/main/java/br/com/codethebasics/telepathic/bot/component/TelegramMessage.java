package br.com.codethebasics.telepathic.bot.component;

import com.pengrad.telegrambot.request.SendMessage;

public class TelegramMessage {

    public static SendMessage sendMessage(Long chatId, String message) {
        return new SendMessage(chatId, message);
    }
}
