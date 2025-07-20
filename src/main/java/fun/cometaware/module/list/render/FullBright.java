package fun.cometaware.module.list.render;

import fun.cometaware.module.Module;
import fun.cometaware.module.ModuleCategory;
import fun.cometaware.module.ModuleInformation;
import net.minecraft.entity.effect.StatusEffectInstance;

import static net.minecraft.entity.effect.StatusEffects.NIGHT_VISION;

@ModuleInformation(moduleName = "FullBright", moduleCategory = ModuleCategory.RENDER)
public class FullBright extends Module {
    @Override
    public void onEnable() {
        if (mc.player == null) return;

        mc.player.addStatusEffect(new StatusEffectInstance(NIGHT_VISION, -1, 3));
    }

    @Override
    public void onDisable() {
        if (mc.player == null) return;

        mc.player.removeStatusEffect(NIGHT_VISION);
    }
}
