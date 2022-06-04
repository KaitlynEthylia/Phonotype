package phonotype.Typing.Editor;

import java.awt.Dimension;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import phonotype.Typing.KeyListener;

public class TextField extends JList<String>{
    JScrollPane scroll;
    int index;
    TextField(JPanel panel, String[] data, String layout, KeyListener listener) {
        setListData(listener.getCustomDictionary().getLetter('a'));
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        ListSelectionModel lsm = getSelectionModel();
        lsm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scroll = new JScrollPane(this);
        scroll.setPreferredSize(new Dimension(100, 150));
        panel.add(scroll, layout);
    }
}