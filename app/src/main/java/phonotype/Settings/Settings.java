package phonotype.Settings;

import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class Settings extends JPanel {
    public Settings(JFrame main) throws JsonParseException, JsonMappingException, IOException {
        setLayout(new GridLayout(1, 3, 5, 5));

        SettingsListener sl = new SettingsListener(main);

        JCheckBox alwaysOnTop = new JCheckBox("Always on Top");
        alwaysOnTop.addItemListener(sl);
        alwaysOnTop.setActionCommand("01");
        add(alwaysOnTop);

        JCheckBox listen = new JCheckBox("Key Listener");
        listen.addItemListener(sl);
        listen.setActionCommand("02");
        add(listen);

        JCheckBox dictionaries = new JCheckBox("Use Custom Dictionaries");
        dictionaries.setActionCommand("03");
        add(dictionaries);
    }
}
