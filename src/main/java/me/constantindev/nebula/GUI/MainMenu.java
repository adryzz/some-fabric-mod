package me.constantindev.nebula.GUI;

import me.constantindev.nebula.etc.ClickableText;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.client.util.Window;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.lwjgl.system.CallbackI;

import java.util.ArrayList;
import java.util.List;

public class MainMenu extends Screen {
    public MainMenu() {
        super(Text.of("Bruh"));
    }
    List<ClickableText> cl = new ArrayList<>();
    int x = 0;
    int y = 0;
    double lcx = 0;
    double lcy = 0;
    MinecraftClient c;
    @Override
    public void init(MinecraftClient client, int width, int height) {
        this.c = client;
        this.x = width;
        this.y = height;
//        cl.add(new ClickableText(width/2-220-(MinecraftClient.getInstance().textRenderer.getWidth("Singleplayer")/2),height/2+420-(MinecraftClient.getInstance().textRenderer.fontHeight/2),MinecraftClient.getInstance().textRenderer.getWidth("Singleplayer"),MinecraftClient.getInstance().textRenderer.fontHeight,()->{
  //          this.client.openScreen(new SelectWorldScreen(this));
    //    }));
//        cl.add(new ClickableText(width/2-420-(MinecraftClient.getInstance().textRenderer.getWidth("Multiplayer")/2),height/2-420-(MinecraftClient.getInstance().textRenderer.fontHeight/2),MinecraftClient.getInstance().textRenderer.getWidth("Singleplayer"),MinecraftClient.getInstance().textRenderer.fontHeight,()->{
  //          this.client.openScreen(new MultiplayerScreen(this));
    //    }));
        super.init(client, width, height);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        //this.renderBackground(matrices);
        matrices.push();
        int rgb = (255 << 24) + (0 << 16) + (0 << 8) + (0/2);
        DrawableHelper.fill(matrices,0,0,x,y,rgb);
        Identifier i = new Identifier("nebula","logo.png");
        MinecraftClient.getInstance().getTextureManager().bindTexture(i);
        Window sr = MinecraftClient.getInstance().getWindow();
        int w = 638/3;
        int h = w;
        int x = sr.getScaledWidth() / 2 - (w/2);
        int y = sr.getScaledHeight() / 2 - (h/2);
        DrawableHelper.drawTexture(matrices, x, y, 0, 0, w, h, w, h);
        //DrawableHelper.drawCenteredString(matrices,MinecraftClient.getInstance().textRenderer,lcx+":"+lcy,this.x/2,this.y/2,0xFFFFFFFF); // deboog
        this.addButton(new TexturedButtonWidget(width/2-75,height/2+27,this.client.textRenderer.getWidth("Singleplayer"),16,0,0,20,new Identifier("nebula","empty.png"),(buttonWidget)->{
            this.client.openScreen(new SelectWorldScreen(this));
        }));
        DrawableHelper.drawCenteredString(matrices,MinecraftClient.getInstance().textRenderer,"Singleplayer",width/2-75+(this.client.textRenderer.getWidth("Singleplayer")/2),height/2+27+(this.client.textRenderer.fontHeight/2),0xFFFFFFFF);
        this.addButton(new TexturedButtonWidget(width/2+(75-this.client.textRenderer.getWidth("Multiplayer_")),height/2+27,this.client.textRenderer.getWidth("Multiplayer"),16,0,0,20,new Identifier("nebula","empty.png"),(buttonWidget)->{
            this.client.openScreen(new MultiplayerScreen(this));
        }));
        DrawableHelper.drawCenteredString(matrices,MinecraftClient.getInstance().textRenderer,"Multiplayer",width/2+(75-this.client.textRenderer.getWidth("Multiplayer_"))+(this.client.textRenderer.getWidth("Multiplayer")/2),height/2+27+(this.client.textRenderer.fontHeight/2),0xFFFFFFFF);
        matrices.pop();
        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public void resize(MinecraftClient client, int width, int height) {
        this.c = client;
        this.x = width;
        this.y = height;
        super.resize(client, width, height);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.lcx = mouseX;
        this.lcy = mouseY;
        super.mouseClicked(mouseX,mouseY,button);
        return false;
    }
}
