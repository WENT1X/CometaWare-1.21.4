package fun.exort.module.list.movement;

import com.google.common.eventbus.Subscribe;
import fun.exort.event.list.EventUpdate;
import fun.exort.module.Module;
import fun.exort.module.ModuleCategory;
import fun.exort.module.ModuleInformation;

@ModuleInformation(moduleName = "Sprint", moduleCategory = ModuleCategory.MOVEMENT)
public class Sprint extends Module {
    @Subscribe
    public void onUpdate(EventUpdate event) {
        if (mc.player == null) return;

        if (mc.player.forwardSpeed > 0 && !mc.player.isSneaking()) {
            mc.player.setSprinting(true);
        }
    }
}
