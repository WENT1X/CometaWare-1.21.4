package fun.exort.module.list.combat;

import fun.exort.event.list.EventUpdate;
import fun.exort.module.Module;
import fun.exort.module.ModuleCategory;
import fun.exort.module.ModuleInformation;
import fun.exort.module.settings.BooleanSetting;
import fun.exort.module.settings.ModeSetting;
import net.minecraft.client.util.math.Vector2f;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import org.apache.commons.lang3.time.StopWatch;
import org.lwjgl.glfw.GLFW;

import java.util.Comparator;

@ModuleInformation(moduleName = "KillAura",moduleCategory = ModuleCategory.COMBAT , moduleKeybind = GLFW.GLFW_KEY_R, moduleDesc = "Килл Аура")
public class KillAura extends Module {
}
