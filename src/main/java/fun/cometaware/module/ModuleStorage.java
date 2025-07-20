package fun.cometaware.module;

import fun.cometaware.module.list.combat.*;
import fun.cometaware.module.list.misc.NameProtect;
import fun.cometaware.module.list.movement.*;
import fun.cometaware.module.list.player.*;
import fun.cometaware.module.list.render.*;
import fun.cometaware.module.list.render.hud.*;

import java.util.ArrayList;
import java.util.List;

public class ModuleStorage {
    private final List<Module> modules = new ArrayList<>();

    public void injectRegisterModules() {
        modules.addAll(List.of(
                new AntiBot(),
                new KillAura(),
                new TargetPearl(),
                new FullBright(),
                new ClickGui(),
                new Sprint(),
                new FakePlayer(),
                new Hud(),
                new TriggerBot(),
                new HighJump(),
                new NoRender(),
                new Flight(),
                new FightAura(),
                new Particles(),
                new NameProtect(),
                new FreeCam()
        ));
    }

    public List<Module> getModules() {
        return modules;
    }

    public List<Module> getCategory(ModuleCategory category) {
        return modules.stream()
                .filter(module -> module.getCategory().equals(category))
                .toList();
    }

    public <T extends Module> T get(final Class<T> clazz) {
        return modules.stream()
                .filter(module -> clazz.isAssignableFrom(module.getClass()))
                .map(clazz::cast)
                .findFirst()
                .orElse(null);
    }
}
