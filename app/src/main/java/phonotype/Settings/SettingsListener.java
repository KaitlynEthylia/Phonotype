package phonotype.Settings;

import java.awt.event.ItemListener;
import java.io.IOException;
import java.awt.event.ItemEvent;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.github.kwhat.jnativehook.GlobalScreen;

import phonotype.Typing.KeyListener;

public class SettingsListener extends JFrame implements ItemListener {
    JFrame main;
    KeyListener listener;
    public SettingsListener(JFrame main) throws JsonParseException, JsonMappingException, IOException {
        this.main = main;
        listener = new KeyListener(main);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        int state = e.getStateChange();
        JCheckBox source = (JCheckBox) e.getSource();
        System.out.println(source);
        System.out.println(state);
        System.out.println(source.getActionCommand());
        switch(state) {
            case 1:
                setSetting(main, source.getActionCommand(), listener);
                break;
            case 2:
                unsetSetting(main, source.getActionCommand(), listener);
                break;
            default:
                System.out.println("Invalid");
        }
    }

    public static void setSetting(JFrame main, String settings, KeyListener listen) {
        switch(settings) {
            case "01": main.setAlwaysOnTop(true); break;
            case "02": GlobalScreen.addNativeKeyListener(listen); break;
            default: break;
        }
    }

    public static void unsetSetting(JFrame main, String settings, KeyListener listen) {
        switch(settings) {
            case "01": main.setAlwaysOnTop(false); break;
            case "02": GlobalScreen.removeNativeKeyListener(listen); break;
            default: break;
        }
    }
}
