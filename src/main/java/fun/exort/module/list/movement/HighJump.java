package fun.exort.module.list.movement;

import com.google.common.eventbus.Subscribe;
import fun.exort.event.list.EventUpdate;
import fun.exort.module.Module;
import fun.exort.module.ModuleCategory;
import fun.exort.module.ModuleInformation;

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
