package fun.cometaware.module.list.render;

import fun.cometaware.module.Module;
import fun.cometaware.module.ModuleCategory;
import fun.cometaware.module.ModuleInformation;
import fun.cometaware.ui.ClickGuiFrame;
import org.lwjgl.glfw.GLFW;

@ModuleInformation(moduleName = "ClickGui", moduleCategory = ModuleCategory.RENDER, moduleKeybind = GLFW.GLFW_KEY_RIGHT_SHIFT)
public class ClickGui extends Module {
    @Override
    public void onEnable() {
        mc.setScreen(new ClickGuiFrame());
        toggle();
    }
}
