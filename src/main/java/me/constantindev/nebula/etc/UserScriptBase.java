package me.constantindev.nebula.etc;

public class UserScriptBase {

    char keyBind;

    public UserScriptBase(char bind) {
        keyBind = bind;
    }

    public void run() {
        //custom code goes here after @override

    }

    public char getKeyBind() {return keyBind;}
}