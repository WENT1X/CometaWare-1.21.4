package fun.exort.module.list.render;

import fun.exort.module.Module;
import fun.exort.module.ModuleCategory;
import fun.exort.module.ModuleInformation;
import fun.exort.ui.ClickGuiFrame;
import org.lwjgl.glfw.GLFW;

@ModuleInformation(moduleName = "ClickGui", moduleCategory = ModuleCategory.RENDER, moduleKeybind = GLFW.GLFW_KEY_RIGHT_SHIFT)
public class ClickGui extends Module {
    @Override
    public void onEnable() {
        mc.setScreen(new ClickGuiFrame());
        toggle();
    }
}
