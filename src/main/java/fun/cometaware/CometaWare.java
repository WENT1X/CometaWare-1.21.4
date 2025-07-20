package fun.cometaware;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import de.florianmichael.viamcp.ViaMCP;
import fun.cometaware.event.list.EventKeyInput;
import fun.cometaware.module.Module;
import fun.cometaware.module.ModuleStorage;
import fun.cometaware.util.hwid.HWID;
import fun.cometaware.util.hwid.HWIDChecker;
import net.fabricmc.api.ModInitializer;

import net.minecraft.client.MinecraftClient;

import static com.mojang.text2speech.Narrator.LOGGER;

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
		try {
			// Выводим HWID в лог
			String hwid = HWID.getHWID();
			LOGGER.info("Your HWID: " + hwid);
		} catch (Exception e) {
			LOGGER.error("Failed to generate HWID: " + e.getMessage());
		}
		if (!HWIDChecker.isValidHWID()) {
			LOGGER.error("Unauthorized HWID! Shutting down...");
			throw new RuntimeException("Invalid HWID");
		}
		try {
			ViaMCP.create();
			ViaMCP.INSTANCE.initAsyncSlider();
		} catch (Exception e) {
			e.printStackTrace();
		}
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