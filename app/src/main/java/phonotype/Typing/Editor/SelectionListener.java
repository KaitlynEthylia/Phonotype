package phonotype.Typing.Editor;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import phonotype.Typing.KeyListener;

public class SelectionListener implements ListSelectionListener {
    KeyListener listener;
    String[] data;
    ListSelectionModel lsm;
    TextField tf;
    SelectionListener(KeyListener listener, String[] data, ListSelectionModel lsm, TextField tf) {
        this.listener = listener;
        this.data = data;
        this.lsm = lsm;
        this.tf = tf;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(e.getValueIsAdjusting()) {
            
            int minIndex = lsm.getMinSelectionIndex();
            int maxIndex = lsm.getMaxSelectionIndex();
            for (int i = minIndex; i <= maxIndex; i++) {
                if (lsm.isSelectedIndex(i)) {
                    tf.setListData(listener.getCustomDictionary().getLetter(data[i].charAt(0)));
                }
            }
        }
    }
}
