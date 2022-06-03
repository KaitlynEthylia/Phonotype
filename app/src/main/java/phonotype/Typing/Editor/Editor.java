package phonotype.Typing.Editor;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import phonotype.SelectionListener;


public class Editor extends JFrame{
    JList<String> list;
    ListSelectionModel lms;
    SelectionListener sl;
    static final String[] data = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "-", "!", "?", ".", "[", "]"};
    public Editor() throws IOException {
        InputStream imageInputStream = this.getClass().getResourceAsStream("/iconBlack.png");
        BufferedImage bufferedImage = ImageIO.read(imageInputStream);
        setIconImage(bufferedImage);
        setTitle("Dictionary Editor");
        setSize(320, 240);
        setResizable(false);

        list = new JList<String>(data);
        lms = list.getSelectionModel();
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) list.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        lms.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lms.addListSelectionListener(new SelectionListener());

        JScrollPane scroll = new JScrollPane(list);
        scroll.setPreferredSize(new Dimension(80, 240));

        add(scroll, BorderLayout.WEST);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 3, 5, 5));
        JButton add = new JButton("Remove");
        add.setEnabled(false);
        buttons.add(add);
        JButton remove = new JButton("Remove");
        remove.setEnabled(false);
        buttons.add(remove);
        JButton ok = new JButton("OK");
        ok.setEnabled(false);
        buttons.add(ok);

        JTextArea text = new JTextArea("Not yet implemented \n Try Editing \'dictionaryCustom.yaml\' \n to add to the dictionary.");
        
        add(buttons, BorderLayout.SOUTH);
        add(text, BorderLayout.EAST);
    }
}
