package br.com.codethebasics.telepathic.bot.component;

import com.pengrad.telegrambot.model.request.InlineKeyboardButton;

public class TelegramButton {

    public static InlineKeyboardButton create(String label, String callbackData) {
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton(label);
        inlineKeyboardButton.callbackData(callbackData);
        return inlineKeyboardButton;
    }

}
