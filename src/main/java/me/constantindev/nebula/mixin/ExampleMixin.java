package me.constantindev.nebula.mixin;

import me.constantindev.nebula.NebulaMod;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ExampleMixin {
	@Inject(at = @At("HEAD"), method = "tick")
	private void tick(CallbackInfo ci) {
		NebulaMod.tick();
	}
}
