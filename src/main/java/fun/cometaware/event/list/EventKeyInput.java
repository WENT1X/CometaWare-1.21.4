package fun.cometaware.event.list;

import fun.cometaware.event.Event;

public class EventKeyInput extends Event {
    private final int key, action;

    public EventKeyInput(int key, int action) {
        this.key = key;
        this.action = action;
    }

    public int getKey() {
        return key;
    }

    public int getAction() {
        return action;
    }
}
