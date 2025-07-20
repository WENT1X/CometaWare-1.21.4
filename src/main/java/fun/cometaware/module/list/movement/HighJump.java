package fun.cometaware.module.list.movement;

import com.google.common.eventbus.Subscribe;
import fun.cometaware.event.list.EventUpdate;
import fun.cometaware.module.Module;
import fun.cometaware.module.ModuleCategory;
import fun.cometaware.module.ModuleInformation;

@ModuleInformation(moduleName = "HighJump", moduleCategory = ModuleCategory.MOVEMENT)
public class HighJump extends Module {
    @Subscribe
    public void onUpdate(EventUpdate event) {
        if (mc.player == null) return;

        if (mc.player.age % 4 == 0) {
            mc.player.jump();
            mc.player.setVelocity(0, 3, 0);
            toggle();
        }
    }
}
