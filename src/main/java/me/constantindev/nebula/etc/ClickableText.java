package me.constantindev.nebula.etc;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class ClickableText {
    int x;
    int y;
    int w;
    int h;
    String text;
    Runnable c;
    public ClickableText(int x, int y, int w, int h, Runnable onClick) {
        this.x = x;
        this.y = y;
        this.h = w;
        this.w = h;
        //this.text = text;
        this.c = onClick;
    }
    private boolean check(double x, double y) {
        return ((x>this.x&&x<this.x+this.h)&&(y>this.y&&y<this.w));
    }
    public void checkPos(double x, double y) {
        if (check(x,y)) this.c.run();
    }
}
