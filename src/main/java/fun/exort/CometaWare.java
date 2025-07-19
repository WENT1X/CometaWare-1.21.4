package fun.exort;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import fun.exort.event.list.EventKeyInput;
import fun.exort.module.Module;
import fun.exort.module.ModuleStorage;
import net.fabricmc.api.ModInitializer;

import net.minecraft.client.MinecraftClient;

public class CometaWare implements ModInitializer {

	private static CometaWare instance;

	private final EventBus eventBus;

	private final ModuleStorage moduleStorage;

	public CometaWare() {
		instance = this;

		eventBus = new EventBus();
		eventBus.register(this);

		moduleStorage = new ModuleStorage();
	}

	public static CometaWare getInstance() {
		return instance == null ? new CometaWare() : instance;
	}

	public EventBus getEventBus() {
		return eventBus;
	}

	public ModuleStorage getModuleStorage() {
		return moduleStorage;
	}

	@Override
	public void onInitialize() {
		getModuleStorage().injectRegisterModules();
	}

	@Subscribe
	private void onModuleKeyPressed(EventKeyInput event) {
		for (Module module : getModuleStorage().getModules()) {
			if (event.getAction() == 1 && MinecraftClient.getInstance().currentScreen == null) {
				if (module.getKeybind() == event.getKey()) {
					module.toggle();
				}
			}
		}
	}
}