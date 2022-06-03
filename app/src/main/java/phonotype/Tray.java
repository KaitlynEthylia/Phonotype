package phonotype;

import java.awt.AWTException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.PopupMenu;
import java.awt.MenuItem;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Tray {
    JFrame main;
    SystemTray sysTray;
    TrayIcon trayIcon;
    public Tray(JFrame main) {
        this.main = main;
    
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

    public int Exit() {
        sysTray.remove(trayIcon);
        System.exit(0);
        return 0;
    }
}
