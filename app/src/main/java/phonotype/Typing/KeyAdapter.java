package phonotype.Typing;

import java.awt.event.MouseAdapter;

import javax.swing.JRadioButton;

public class KeyAdapter extends MouseAdapter{
    public KeyAdapter() {}

    public void mouseEntered(java.awt.event.MouseEvent e) {
        JRadioButton j = (JRadioButton) e.getSource();
        j.setSelected(true);
    }
}
