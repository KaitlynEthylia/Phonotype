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
    public SettingsListener(JFrame main, KeyListener listener) throws JsonParseException, JsonMappingException, IOException {
        this.main = main;
        this.listener = listener;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        int state = e.getStateChange();
        JCheckBox source = (JCheckBox) e.getSource();
        switch(state) {
            case 1:
                try {setSetting(main, source.getActionCommand(), listener);} catch (IOException e1) {e1.printStackTrace();}
                break;
            case 2:
                try {unsetSetting(main, source.getActionCommand(), listener);} catch (IOException e1) {e1.printStackTrace();}
                break;
            default:
                System.out.println("Invalid");
        }
    }

    public static void setSetting(JFrame main, String settings, KeyListener listen) throws JsonParseException, JsonMappingException, IOException {
        switch(settings) {
            case "01": main.setAlwaysOnTop(true); break;
            case "02": GlobalScreen.addNativeKeyListener(listen); break;
            case "03": {
                listen.addCustoms();
            }
            default: break;
        }
    }

    public static void unsetSetting(JFrame main, String settings, KeyListener listen) throws JsonParseException, JsonMappingException, IOException {
        switch(settings) {
            case "01": main.setAlwaysOnTop(false); break;
            case "02": GlobalScreen.removeNativeKeyListener(listen); break;
            case "03": {
                listen.setDictionary((KeyListener.getDictionary(listen.getClass().getResource("/dictionary.yaml"))));
            }
            default: break;
        }
    }
}
