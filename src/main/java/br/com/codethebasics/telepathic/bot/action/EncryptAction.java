package br.com.codethebasics.telepathic.bot.action;

import br.com.codethebasics.telepathic.beans.Encoders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EncryptAction implements BotAction {

    private final Encoders encoders;

    @Autowired
    public EncryptAction(Encoders encoders) {
        this.encoders = encoders;
    }

    public String encrypt(String plainText, String algorithm) {
        if (algorithm.equalsIgnoreCase("bcrypt")) {
            return this.encoders.bCryptPasswordEncoder().encode(plainText);
        }
        return null;
    }

    @Override
    public String execute(String ... params) {
        if (params[0] == null || params[1] == null) {
            return "You need to provide specified params.";
        }
        return encrypt(params[0], params[1]);
    }
}
