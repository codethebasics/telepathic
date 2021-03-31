package br.com.codethebasics.telepathic.message;

import org.springframework.stereotype.Service;

@Service
public class SimpleMessageReceiver implements MessageReceiver {

    @Override
    public String receive() {
        return null;
    }

}
