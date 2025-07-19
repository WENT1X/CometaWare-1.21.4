package fun.exort.module.list.combat;

import com.google.common.eventbus.Subscribe;
import fun.exort.event.list.EventUpdate;
import fun.exort.module.Module;
import fun.exort.module.ModuleCategory;
import fun.exort.module.ModuleInformation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;

@ModuleInformation(moduleName = "FightAura", moduleCategory = ModuleCategory.COMBAT)
public class FightAura extends Module {
    @Subscribe
    public void onUpdate(EventUpdate event) {
        if (mc.player == null || mc.world == null || mc.interactionManager == null) return;

        for (PlayerEntity player : mc.world.getPlayers()) {

            if (player == mc.player) continue;

            if (mc.player.distanceTo(player) <= 3.0F) {
                if (mc.player.getAttackCooldownProgress(0.0F) >= 0.93F) {
                    mc.interactionManager.attackEntity(mc.player, player);
                    mc.player.swingHand(Hand.MAIN_HAND);
                }
            }
        }
    }
}
