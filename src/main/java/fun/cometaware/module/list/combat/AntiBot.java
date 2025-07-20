package fun.cometaware.module.list.combat;

import com.google.common.eventbus.Subscribe;
import fun.cometaware.event.list.EventUpdate;
import fun.cometaware.module.Module;
import fun.cometaware.module.ModuleCategory;
import fun.cometaware.module.ModuleInformation;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;

@ModuleInformation(moduleCategory = ModuleCategory.COMBAT, moduleName = "AntiBot", moduleDesc = "Тестирования")
public class AntiBot extends Module {
//    @Subscribe
//    public void render(EventUpdate eventUpdate) {
//        MinecraftClient mc = MinecraftClient.getInstance();
//        for (Entity player : mc.world.getEntities()) {
//            if (player instanceof Player) {
//                if (player != mc.player && player.ticksExisted < 5) {
//                    if (((Player) player).hurtTime > 0 && mc.player.getDisgetDistance(player) <=25 && mc.player.connection.getPlayerInfo(player.getUUID()).getLatency() != 0) {
//                        bots.add(player.getEntityId());
//                    }
//                }
//            }
//        }
//    }
//    public boolean isValid(Player  player) {
//        return !bots.contains(player.getEntityId());
//
//    }
//
//    @Override
//    public void onDisable() {
//        bots.clear();
//        super.onDisable();
//    }
}
