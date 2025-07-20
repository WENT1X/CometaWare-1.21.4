package fun.exort.module.list.misc;

import fun.exort.module.Module;
import fun.exort.module.ModuleCategory;
import fun.exort.module.ModuleInformation;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

@ModuleInformation(moduleName = "NameProtect", moduleCategory = ModuleCategory.MISC)
public class NameProtect extends Module {
    private static final String FAKE_NAME = "Protected"; // Фейковое имя по умолчанию
    private boolean enabled = false;
    private String customName = FAKE_NAME;

    // Включение/выключение модуля
    public void toggle() {
        this.enabled = !this.enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    // Установка пользовательского фейкового имени
    public void setCustomName(String name) {
        this.customName = name != null ? name : FAKE_NAME;
    }

    // Получение имени игрока
    public String getProtectedName(String originalName) {
        if (enabled && originalName != null && originalName.equals(MinecraftClient.getInstance().getSession().getUsername())) {
            return customName;
        }
        return originalName;
    }

    // Обработка текста (например, в чате)
    public Text protectText(Text text) {
        if (!enabled || text == null) return text;

        String string = text.getString();
        String playerName = MinecraftClient.getInstance().getSession().getUsername();
        if (string.contains(playerName)) {
            string = string.replace(playerName, customName);
        }
        return Text.of(string);
    }
}
