package phonotype.Settings;

import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import phonotype.Typing.KeyListener;

public class Settings extends JPanel {
    private JCheckBox alwaysOnTop, listen, dictionaries;

    public JCheckBox getAlwaysOnTop() {
        return this.alwaysOnTop;
    }
    public JCheckBox getListen() {
        return this.listen;
    }
    public JCheckBox getDictionaries() {
        return this.dictionaries;
    }
    public Settings(JFrame main, KeyListener listener) throws JsonParseException, JsonMappingException, IOException {
        setLayout(new GridLayout(1, 3, 5, 5));

        SettingsListener sl = new SettingsListener(main, listener);

        alwaysOnTop = new JCheckBox("Always on Top");
        alwaysOnTop.addItemListener(sl);
        alwaysOnTop.setActionCommand("01");
        add(alwaysOnTop);

        listen = new JCheckBox("Key Listener");
        listen.addItemListener(sl);
        listen.setActionCommand("02");
        listen.setSelected(true);
        add(listen);

        dictionaries = new JCheckBox("Use Custom Dictionaries");
        dictionaries.addItemListener(sl);
        dictionaries.setActionCommand("03");
        add(dictionaries);
    }

}
