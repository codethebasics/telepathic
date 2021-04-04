package br.com.codethebasics.telepathic.bot;

import br.com.codethebasics.telepathic.bot.component.TelegramMessage;
import br.com.codethebasics.telepathic.bot.menu.Menu;
import br.com.codethebasics.telepathic.bot.menu.MenuService;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Component
public class TelepathicBot {

    private static final Integer MAIN_MENU_ID = 0;

    @Value("${telegram.bot.token}")
    private String token;

    @Autowired
    private MenuService menuService;

    private TelegramBot bot;

    private Menu menu;

    public void initBot() {
        this.bot = new TelegramBot(this.token);
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
            sendMessage(displayMainMenu(), update.message().chat().id());
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
        bot.execute(TelegramMessage.sendMessage(chatId, text));
    }

    /**
     * Display current menu
     */
    private String displayMainMenu() {

        if (Objects.nonNull(this.menu))
            this.menu = this.menuService.findById(MAIN_MENU_ID);

        StringBuilder builder = new StringBuilder();
        builder.append(TelepathicBot.displayMenu(this.getMenu()));
        this.menu.getChildMenus().forEach(menu -> builder.append(displayMenu(menu)));

        return builder.toString();
    }

    private static String displayMenu(Menu menu) {
        return menu.getId()
            + " - "
            + menu.getTitle()
            + "\n";
    }
}
