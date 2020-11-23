package me.constantindev.nebula;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import me.constantindev.nebula.GUI.BaseGUI;
import me.constantindev.nebula.GUI.TestGUI;
import me.constantindev.nebula.etc.ClientUtils;
import me.constantindev.nebula.etc.ModuleBase;
import me.constantindev.nebula.etc.ModuleManager;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.c2s.play.CustomPayloadC2SPacket;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil;
//import sun.security.pkcs11.Secmod;

import java.util.ArrayList;
import java.util.List;

public class NebulaMod implements ModInitializer {
	@Override
	public void onInitialize() {
		AttackEntityCallback.EVENT.register((playerEntity, world, hand, entity, entityHitResult) -> {
			ClientUtils.SendMessage("Dis a test",true);
			MinecraftClient.getInstance().openScreen(new BaseGUI(new TestGUI()));

			return ActionResult.SUCCESS;
		});

	}
	public static void tick() {
		new ModuleManager().getModules().forEach(moduleBase -> {
			if (moduleBase.isEnabled()) moduleBase.run();
		});

	}

}
