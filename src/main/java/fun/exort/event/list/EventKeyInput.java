package fun.exort.event.list;

import fun.exort.event.Event;

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
