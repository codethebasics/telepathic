package br.com.codethebasics.telepathic.bot.component;

import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelegramMessageTest {

    @Test
    @DisplayName("Given text, when send message, then return SendMessage")
    public void givenText_whenSendMessage_thenReturnSendMessage() {

        // given
        Long chatId = 1L;
        String message = "test message";

        // when
        SendMessage response = TelegramMessage.sendMessage(chatId, message);

        // then
        assertAll("Validate message",
            () -> assertNotNull(response, "Response shouldn't be null"));
    }
}