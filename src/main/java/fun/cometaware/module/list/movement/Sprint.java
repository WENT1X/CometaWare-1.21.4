package fun.cometaware.module.list.movement;

import com.google.common.eventbus.Subscribe;
import fun.cometaware.event.list.EventUpdate;
import fun.cometaware.module.Module;
import fun.cometaware.module.ModuleCategory;
import fun.cometaware.module.ModuleInformation;

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
