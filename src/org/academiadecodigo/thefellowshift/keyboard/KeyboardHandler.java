package org.academiadecodigo.thefellowshift.keyboard;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class KeyboardHandler implements org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler {


    private KeyHandler keyHandler;

    private Keyboard kb;
    private int[] KEYS = {
            KeyboardEvent.KEY_UP,
            KeyboardEvent.KEY_DOWN,
            KeyboardEvent.KEY_RIGHT,
            KeyboardEvent.KEY_LEFT
    };

    public KeyboardHandler() {
        kb = new Keyboard(this);
        keySetup();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        keyHandler.pressed(keyboardEvent);
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    private void subscribe(int code, KeyboardEventType keyboardEventType) {
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(code);
        event.setKeyboardEventType(keyboardEventType);
        kb.addEventListener(event);
    }


    public void keySetup() {
        for(int keyCode : KEYS) {
            for(KeyboardEventType t : KeyboardEventType.values()) {
                subscribe(keyCode, t);
            }
        }
    }

    public void setKeyHandler(KeyHandler keyHandler) {
        this.keyHandler = keyHandler;
    }
}
