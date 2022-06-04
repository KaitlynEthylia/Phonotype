package phonotype.Typing.Editor;

import java.awt.Dimension;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import phonotype.Typing.KeyListener;

public class ListPane extends JList<String>{
    JScrollPane scroll;
    int index;
    ListPane(JFrame frame, String[] data, String layout, KeyListener listener, TextField tf) {
        setListData(data);
        ListSelectionModel lsm = getSelectionModel();
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        lsm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsm.addListSelectionListener(new SelectionListener(listener, data, lsm, tf));
        scroll = new JScrollPane(this);
        scroll.setPreferredSize(new Dimension(60, 240));
        frame.add(scroll, layout);
        setSelectedIndex(0);
    }
}
