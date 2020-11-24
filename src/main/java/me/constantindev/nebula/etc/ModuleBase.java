package me.constantindev.nebula.etc;

public class ModuleBase {
    String name;
    String desc;
    boolean enabled;
    public ModuleBase(String name, String description) {
        this.name = name;
        this.desc = description;
    }
    public void run() {

    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void toggleEnabled() {
        this.enabled = !this.enabled;
    }

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }
}

