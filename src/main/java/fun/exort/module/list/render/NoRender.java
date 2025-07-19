package fun.exort.module.list.render;

import fun.exort.module.Module;
import fun.exort.module.ModuleCategory;
import fun.exort.module.ModuleInformation;
import fun.exort.module.settings.BooleanSetting;

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
