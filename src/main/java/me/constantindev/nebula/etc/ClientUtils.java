package me.constantindev.nebula.etc;

import me.constantindev.nebula.Modules.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class ClientUtils {
    public static void SendMessage(String text,boolean actionbar) {
        String prefix = "§b[§3NEBULA§b] §r";
        MinecraftClient.getInstance().player.sendMessage(Text.of(prefix+text),actionbar);
    }

}
