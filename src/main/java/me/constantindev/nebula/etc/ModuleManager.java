package me.constantindev.nebula.etc;

import me.constantindev.nebula.Modules.CrasherTest;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    List<ModuleBase> v = new ArrayList<>();
    public List<ModuleBase> getModules() {
        return v;
    }
    public ModuleManager() {
        v.add(new CrasherTest());
    }
}