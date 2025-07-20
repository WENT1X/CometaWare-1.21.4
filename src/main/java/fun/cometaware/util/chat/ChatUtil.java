package fun.cometaware.util.chat;

import fun.cometaware.util.MinecraftUtil;
import net.minecraft.text.Text;

public class ChatUtil {
    public static void send(String message) {
        if (MinecraftUtil.mc.player == null) return;

        MinecraftUtil.mc.player.sendMessage(Text.of("Cometa§bWare §f» " + message), false);
    }
}
