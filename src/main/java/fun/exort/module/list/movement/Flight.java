package fun.exort.module.list.movement;

import com.google.common.eventbus.Subscribe;
import fun.exort.event.list.EventUpdate;
import fun.exort.module.Module;
import fun.exort.module.ModuleCategory;
import fun.exort.module.ModuleInformation;
import fun.exort.module.settings.BooleanSetting;
import fun.exort.module.settings.ModeSetting;
import fun.exort.module.settings.NumberSetting;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;

@ModuleInformation(moduleName = "Flight", moduleCategory = ModuleCategory.MOVEMENT)
public class Flight extends Module {

    public ModeSetting mode = new ModeSetting("Server", this, "DexLand", "DexLand", "Vanilla");

    public Flight() {
        addSetting(mode);
    }

    @Subscribe
    public void onUpdate(EventUpdate event) {
        if (mc.player == null || mc.getNetworkHandler() == null) return;

        if (mode.getValue().equalsIgnoreCase("DexLand")) {
            if (mc.player.age % 2 == 0 && mc.player.forwardSpeed > 0 && !mc.player.isOnGround()) {
                mc.player.setVelocity(mc.player.getVelocity().x * 1.12, 0.02f, mc.player.getVelocity().z * 1.12);
                mc.getNetworkHandler().sendPacket(new ClientCommandC2SPacket(mc.player, ClientCommandC2SPacket.Mode.START_FALL_FLYING));
            }
        }
    }
}
