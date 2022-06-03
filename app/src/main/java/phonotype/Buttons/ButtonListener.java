package phonotype.Buttons;

import java.awt.event.ActionListener;

import phonotype.Tray;

import java.awt.event.ActionEvent;
public class ButtonListener implements ActionListener{
    Tray tray;
    ButtonListener(Tray tray) {
        this.tray = tray;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "Non-Pulmonic": System.out.println("Not Yet Implemented"); break;
            case "Vowels": System.out.println("Not Yet Implemented"); break;
            case "Diacritics": System.out.println("Not Yet Implemented"); break;
            case "Edit Dictionary": System.out.println("Not Yet Implemented"); break;
            case "Quit": tray.Exit(); break;
        }
    }
}