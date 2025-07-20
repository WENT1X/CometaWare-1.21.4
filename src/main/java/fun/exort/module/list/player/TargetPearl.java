package fun.exort.module.list.player;

import com.google.common.eventbus.Subscribe;
import fun.exort.event.list.EventUpdate;
import fun.exort.module.Module;
import fun.exort.module.ModuleCategory;
import fun.exort.module.ModuleInformation;
import fun.exort.module.settings.NumberSetting;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.EnderPearlItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@ModuleInformation(moduleName = "TargetPearl", moduleCategory = ModuleCategory.PLAYER)
public class TargetPearl extends Module {
    private final Set<UUID> seenPearls = new HashSet<>();
    public NumberSetting radius = new NumberSetting("Радиус", this, 30.0, 5.0, 100.0, 1.0);
    public NumberSetting delay = new NumberSetting("Тики", this, 10.0, 1.0, 40.0, 1.0);

    private int lastThrowTick = 0;

    public TargetPearl() {
        addSetting(radius);
        addSetting(delay);
    }

    @Subscribe
    public void onUpdate(EventUpdate event) {
        if (mc.player == null || mc.world == null) return;

        lastThrowTick++;

        for (Entity entity : mc.world.getEntities()) {
            if (entity instanceof EnderPearlEntity pearl) {
                UUID pearlId = pearl.getUuid();
                if (seenPearls.contains(pearlId)) continue;

                if (pearl.age > 2) continue;

                Entity owner = pearl.getOwner();
                if (owner instanceof PlayerEntity player && player != mc.player) {

                    if (mc.player.distanceTo(player) > radius.getValue()) continue;


                    if (lastThrowTick < delay.getValue()) continue;


                    int pearlSlot = findPearlSlot();
                    if (pearlSlot == -1) continue;

                    // ало работай
                    float[] angles = getAnglesFromVelocity(pearl.getVelocity().x, pearl.getVelocity().y, pearl.getVelocity().z);
                    smoothLookAt(angles[0], angles[1]);
                    // бросаем перл
                    throwPearl(pearlSlot);

                    lastThrowTick = 0;
                    seenPearls.add(pearlId);
                }
            }
        }
    }

    private void throwPearl(int pearlSlot) {
        int oldSlot = mc.player.getInventory().selectedSlot;
        mc.player.getInventory().selectedSlot = pearlSlot;
        usePearl();
        mc.player.getInventory().selectedSlot = oldSlot;
    }

    private void usePearl() {
        ItemStack stack = mc.player.getMainHandStack();
        if (stack.getItem() instanceof EnderPearlItem) {
            mc.interactionManager.interactItem(mc.player, Hand.MAIN_HAND);
        }
    }

    private int findPearlSlot() {
        for (int i = 0; i < 9; i++) {
            ItemStack stack = mc.player.getInventory().getStack(i);
            if (stack.getItem() instanceof EnderPearlItem) {
                return i;
            }
        }
        return -1;
    }

    private float[] getAnglesFromVelocity(double vx, double vy, double vz) {
        float yaw = (float) (Math.toDegrees(Math.atan2(vz, vx)) - 90.0F);
        float pitch = (float) -Math.toDegrees(Math.atan2(vy, Math.sqrt(vx * vx + vz * vz)));
        return new float[]{yaw, pitch};
    }

    private void smoothLookAt(float targetYaw, float targetPitch) {
        mc.player.setYaw(targetYaw);
        mc.player.setPitch(targetPitch);
    }
}