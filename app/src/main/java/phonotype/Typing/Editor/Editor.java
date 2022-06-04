package phonotype.Typing.Editor;

import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import phonotype.Settings.Settings;
import phonotype.Typing.KeyListener;


public class Editor extends JFrame{
    ListSelectionModel lms;
    JTextField[] fields;
    JButton add, remove, ok;
    static final String[] data = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "-", "!", "?", ".", "[", "]"};
    public Editor(KeyListener listener, Settings settings) throws IOException {
        InputStream imageInputStream = this.getClass().getResourceAsStream("/iconBlack.png");
        BufferedImage bufferedImage = ImageIO.read(imageInputStream);
        setIconImage(bufferedImage);
        setTitle("Dictionary Editor");
        setSize(180, 240);
        setResizable(false);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setSize(100, 200);

        JTextField field = new JTextField();
        TextField tf = new TextField(panel, data, BorderLayout.NORTH, listener);

        panel.add(field, BorderLayout.SOUTH);

        ListPane lp = new ListPane(this, data, BorderLayout.WEST, listener, tf);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 3, 5, 5));

        EventActionListener events = new EventActionListener(data, field, listener, lp, tf, settings, this);

        add = new JButton("Add");
        add.addActionListener(events);
        add.setMargin(new Insets(0, 0, 0, 0));
        buttons.add(add);

        remove = new JButton("Delete");
        remove.setEnabled(false);
        tf.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if(!tf.isSelectionEmpty()) {
                    remove.setEnabled(true);
                }
            }
        });
        remove.addActionListener(events);
        remove.setMargin(new Insets(0, 0, 0, 0));
        buttons.add(remove);

        ok = new JButton("OK");
        ok.addActionListener(events);
        ok.setMargin(new Insets(0, 0, 0, 0));
        buttons.add(ok);


        add(panel, BorderLayout.EAST);
        add(buttons, BorderLayout.SOUTH);
    }
    public JButton getRemove() {
        return remove;
    }
}
