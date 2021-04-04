package br.com.codethebasics.telepathic.bot.component;

import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelegramButtonTest {

    @Test
    @DisplayName("When create inlineKeyboardButton, then return InlineKeyboardButton")
    public void whenCreateInlineKeyboardButton_thenReturnInlineKeyboardButton() {

        // when
        InlineKeyboardButton button = TelegramButton.create("test button", "test callback");

        // then
        assertAll("Validating created button",
            () -> assertNotNull(button, "Button shouldn't be null"),
            () -> assertEquals("test button", button.text(), "Text doesn't match"),
            () -> assertEquals("test callback", button.callbackData(), "callbackData doesn't match"));
    }
}