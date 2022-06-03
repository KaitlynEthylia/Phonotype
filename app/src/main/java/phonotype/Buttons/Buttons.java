package phonotype.Buttons;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import phonotype.Tray;
import phonotype.Typing.Editor.Editor;

public class Buttons extends JPanel{
    public Buttons(Tray tray, Editor editor) {
        ButtonListener bl = new ButtonListener(tray, editor);
        setLayout(new GridLayout(1, 5, 5, 5));

        JButton npc = new JButton("Non-Pulmonic");
        npc.setEnabled(false);
        add(npc);

        JButton vowels = new JButton("Vowels");
        vowels.setEnabled(false);
        add(vowels);

        JButton diacritics = new JButton("Diacritics");
        diacritics.setEnabled(false);
        add(diacritics);
        
        JButton dictionaries = new JButton("Edit Dictionary");
        dictionaries.addActionListener(bl);
        add(dictionaries);

        JButton quit = new JButton("Quit");
        quit.addActionListener(bl);
        add(quit);
    }
}
