package phonotype;

import java.awt.AWTException;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.PopupMenu;
import java.awt.MenuItem;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import phonotype.Typing.KeyListener;

public class Tray {
    JFrame main;
    KeyListener listener;
    SystemTray sysTray;
    TrayIcon trayIcon;
    public Tray(JFrame main, KeyListener listener) {
        this.main = main;
        this.listener = listener;
    
        if(SystemTray.isSupported()) {
            main.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        }

        this.sysTray = SystemTray.getSystemTray();
        this.trayIcon = new TrayIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png")));
        PopupMenu popMenu = new PopupMenu();

        MenuItem show = new MenuItem("Show");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setVisible(true);
            }
        });
        MenuItem hide = new MenuItem("Hide");
        hide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setVisible(false);
            }
        });
        MenuItem exit = new MenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                sysTray.remove(trayIcon);
            }
        });

        popMenu.add(show);
        popMenu.add(hide);
        popMenu.add(exit);
        trayIcon.setPopupMenu(popMenu);
        try {
            sysTray.add(trayIcon);
        } catch (AWTException e1) {
            e1.printStackTrace();
        }
    }

    public int Exit() throws JsonGenerationException, JsonMappingException, IOException {
        final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.writeValue(new File("src/main/resources/dictionaryCustom.yaml"), listener.getCustomDictionary());
        sysTray.remove(trayIcon);
        System.exit(0);
        return 0;
    }
}
