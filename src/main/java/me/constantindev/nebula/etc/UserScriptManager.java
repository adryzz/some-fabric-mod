package me.constantindev.nebula.etc;

import me.constantindev.nebula.Modules.CrasherTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class UserScriptManager {
    List<UserScriptBase> loadedScripts = new ArrayList<>();

    public List<UserScriptBase> getLoadedScripts() {
        return loadedScripts;
    }

    public UserScriptManager() {

    }

    public void loadScripts(Path path) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for (Path file : stream) {
                loadedScripts.add(loadScript(file));
            }
        } catch (IOException | DirectoryIteratorException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can only be thrown by newDirectoryStream.
            x.printStackTrace();
        }
    }

    UserScriptBase loadScript(Path p) {
        try (BufferedReader br = new BufferedReader(new FileReader(String.valueOf(p)))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String contents = sb.toString();
            return new UserScriptBase((char)0x00);//this is just template code. we need to convert java code (contents) into an instance of a script.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
