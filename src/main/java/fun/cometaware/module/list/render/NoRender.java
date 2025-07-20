package fun.cometaware.module.list.render;

import fun.cometaware.module.Module;
import fun.cometaware.module.ModuleCategory;
import fun.cometaware.module.ModuleInformation;
import fun.cometaware.module.settings.BooleanSetting;

@ModuleInformation(moduleName = "NoRender", moduleCategory = ModuleCategory.RENDER)
public class NoRender extends Module {

    public BooleanSetting fire = new BooleanSetting("Fire", this, false);
    public BooleanSetting water = new BooleanSetting("Water", this, false);
    public BooleanSetting wall = new BooleanSetting("Wall", this, false);

    public NoRender() {
        addSetting(fire);
        addSetting(water);
        addSetting(wall);
    }

    @Override
    public void onEnable() {
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
