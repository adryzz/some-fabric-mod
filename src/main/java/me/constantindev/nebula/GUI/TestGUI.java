package me.constantindev.nebula.GUI;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.Axis;
import io.github.cottonmc.cotton.gui.widget.icon.ItemIcon;
import me.constantindev.nebula.etc.ClientUtils;
import me.constantindev.nebula.etc.ModuleBase;
import me.constantindev.nebula.etc.ModuleManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil;

import java.util.ArrayList;
import java.util.function.BiConsumer;

public class TestGUI extends LightweightGuiDescription {
    class BTNC extends WPlainPanel {
        WButton b;
        public BTNC() {


            b = new WButton();

            this.add(b,0,0,4*18,1*18);
            this.setSize(7*18,2*18);
        }
    }
    public TestGUI() {
        WGridPanel p = new WGridPanel();
        setRootPanel(p);
        p.setSize(256,256);
        ArrayList<ModuleBase> oof = new ArrayList<>();
        new ModuleManager().getModules().forEach(v -> {
            oof.add(v);
        });

        BiConsumer<ModuleBase, BTNC> conf = (ModuleBase s, BTNC v) -> {
            v.b.setLabel(Text.of(s.getName()));
            v.b.setOnClick(()->{
                s.setEnabled(!s.isEnabled());
                ClientUtils.SendMessage((s.isEnabled()?"En":"Dis")+"abled "+s.getName(),false);
            });
            //v.add(v.b,0,0,4,1);
            //v.b.setSize(4,1);
        };
        WListPanel<ModuleBase, BTNC> l = new WListPanel<ModuleBase, BTNC>(oof,BTNC::new,conf);
        l.setListItemHeight(20);
        //l.setSize(256/18,256/18);

        p.add(l,0,0,256/18,256/18);
        p.validate(this);
    }


}

