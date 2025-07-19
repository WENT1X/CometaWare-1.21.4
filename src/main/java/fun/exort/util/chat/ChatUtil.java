package fun.exort.util.chat;

import fun.exort.util.MinecraftUtil;
import net.minecraft.text.Text;

public class ChatUtil {
    public static void send(String message) {
        if (MinecraftUtil.mc.player == null) return;

        MinecraftUtil.mc.player.sendMessage(Text.of("Exort§bWare §f» " + message), false);
    }
}
