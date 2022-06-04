package phonotype.Typing.Editor;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextField;

import phonotype.Settings.Settings;
import phonotype.Typing.Dictionary;
import phonotype.Typing.KeyListener;

import java.awt.event.ActionEvent;

public class EventActionListener implements ActionListener {
    String[] chars;
    JTextField field;
    KeyListener listener;
    ListPane list;
    TextField text;
    Settings settings;
    Editor editor;
    EventActionListener(String[] chars, JTextField field, KeyListener listener, ListPane list, TextField text, Settings settings, Editor editor) {
        this.chars = chars;
        this.field = field;
        this.listener = listener;
        this.list = list;
        this.text = text;
        this.settings = settings;
        this.editor = editor;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case("Add"):
                char selected = chars[list.getSelectedIndex()].charAt(0);
                String[] appendage = {field.getText()};
                String[] data = Dictionary.concatenate(listener.getCustomDictionary().getLetter(selected), appendage);;
                listener.getCustomDictionary().setLetter(selected, data);
                text.setListData(data);
                field.setText("");
                break;
            case("Delete"):
                char remove = chars[list.getSelectedIndex()].charAt(0);
                ArrayList<String> newData = new ArrayList<String>();
                for(int i = 0; i < text.getModel().getSize(); i++) {
                    if(text.getSelectedIndex() != i) {
                        newData.add(text.getModel().getElementAt(i));
                    }
                }
                text.setListData(newData.toArray(String[]::new));
                editor.getRemove().setEnabled(false);
                listener.getCustomDictionary().setLetter(remove, newData.toArray(String[]::new));
                break;
            case("OK"):
                if(settings.getDictionaries().isSelected()){
                    try {listener.addCustoms();} catch (IOException e1) {e1.printStackTrace();}
                }
                editor.setVisible(false);
                break;
        }
    }
}
