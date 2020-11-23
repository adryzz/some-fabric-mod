package me.constantindev.nebula.etc;

import me.constantindev.nebula.Modules.CrasherTest;
import java.util.ArrayList;
import java.util.List;

public class UserScriptManager {
    List<UserScriptBase> loadedScripts = new ArrayList<>();
    public List<UserScriptBase> getLoadedScripts() {
        return loadedScripts;
    }

    public UserScriptManager() {

    }

    public void loadScripts() {

    }

    public void onKeyPressed(char key) {
        //note here: we can have multiple scripts with the same keybind, and that's fine.
        //they'll both run, but in the order that they get loaded, so it's unknown which one will come first.
        //if you wanna remove this behaviour, uncomment out the break in line 28.
        for (UserScriptBase b : loadedScripts) {
            if (b.getKeyBind() == key) {
                b.run();
                //break;
            }
        }
    }
}
