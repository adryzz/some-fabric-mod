package me.constantindev.nebula.etc;

import me.constantindev.nebula.Modules.CrasherTest;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    List<ModuleBase> modules = new ArrayList<>();
    public List<ModuleBase> getModules() {
        return modules;
    }
    public ModuleManager() {
        modules.add(new CrasherTest());
    }//The new crashertest here is just for debugging. it will be removed after we have an usable codebase.

    public ModuleBase getModuleByName(String name) {
        for (ModuleBase b : modules) {
            if (b.getName().equals(name)) {
                return b;
            }
        }
        return null;
    }
}