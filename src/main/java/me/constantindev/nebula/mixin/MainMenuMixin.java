package me.constantindev.nebula.mixin;

import me.constantindev.nebula.GUI.MainMenu;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class MainMenuMixin {
    @Inject(at = @At("TAIL"), method="init")
    public void init(CallbackInfo ci) {
        MinecraftClient.getInstance().openScreen(new MainMenu());
    }
}
