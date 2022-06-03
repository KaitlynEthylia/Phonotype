package phonotype.Buttons;

import java.awt.event.ActionListener;

import phonotype.Tray;
import phonotype.Typing.Editor.Editor;

import java.awt.event.ActionEvent;
public class ButtonListener implements ActionListener{
    Tray tray;
    Editor editor;
    ButtonListener(Tray tray, Editor editor) {
        this.tray = tray;
        this.editor = editor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "Non-Pulmonic": System.out.println("Not Yet Implemented"); break;
            case "Vowels": System.out.println("Not Yet Implemented"); break;
            case "Diacritics": System.out.println("Not Yet Implemented"); break;
            case "Edit Dictionary": editor.setVisible(true); break;
            case "Quit": tray.Exit(); break;
        }
    }
}