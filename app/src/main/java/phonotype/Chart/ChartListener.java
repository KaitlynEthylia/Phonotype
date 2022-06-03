package phonotype.Chart;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;

public class ChartListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        StringSelection selection = new StringSelection(e.getActionCommand());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }
}
