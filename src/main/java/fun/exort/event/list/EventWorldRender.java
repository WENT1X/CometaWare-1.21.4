package fun.exort.event.list;

import fun.exort.event.Event;
import net.minecraft.client.render.RenderTickCounter;

public class EventWorldRender extends Event {
    private final RenderTickCounter renderTickCounter;
    private final boolean tick;

    public EventWorldRender(RenderTickCounter renderTickCounter, boolean tick) {
        this.renderTickCounter = renderTickCounter;
        this.tick = tick;
    }

    public RenderTickCounter getRenderTickCounter() {
        return renderTickCounter;
    }

    public boolean isTick() {
        return tick;
    }
}
