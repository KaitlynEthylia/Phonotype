package phonotype.Buttons;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import phonotype.Tray;

public class Buttons extends JPanel{
    public Buttons(Tray tray) {
        ButtonListener bl = new ButtonListener(tray);
        setLayout(new GridLayout(1, 5, 5, 5));

        JButton npc = new JButton("Non-Pulmonic");
        npc.addActionListener(bl);
        add(npc);

        JButton vowels = new JButton("Vowels");
        vowels.addActionListener(bl);
        add(vowels);

        JButton diacritics = new JButton("Diacritics");
        diacritics.addActionListener(bl);
        add(diacritics);
        
        JButton dictionaries = new JButton("Edit Dictionary");
        dictionaries.addActionListener(bl);
        add(dictionaries);

        JButton quit = new JButton("Quit");
        quit.addActionListener(bl);
        add(quit);
    }
}
