package phonotype.Typing;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;
import java.awt.MouseInfo;
import java.awt.FlowLayout;
import java.awt.Color;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JWindow;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.NativeInputEvent;
import com.github.kwhat.jnativehook.dispatcher.VoidDispatchService;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class KeyListener implements NativeKeyListener {
    public boolean altHeld;
    JWindow window;
    Dictionary dictionary;
    char prev;
    ButtonGroup bg;
    final List<Character> chars = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '.', '!', '?', '-', '[', ']');

    public KeyListener(JFrame main) throws JsonParseException, JsonMappingException, IOException {
        this.altHeld = false;
        window = new JWindow();
        window.setLayout(new FlowLayout(FlowLayout.LEFT));
        window.setAlwaysOnTop(true);
        dictionary = getDictionary(this.getClass().getResource("/dictionary.yaml"));

		try {GlobalScreen.registerNativeHook();} catch (NativeHookException e1) {e1.printStackTrace();}
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.WARNING);

		GlobalScreen.setEventDispatcher(new VoidDispatchService());
    }

	public void nativeKeyPressed(NativeKeyEvent e) {
        if(e.getKeyCode() == NativeKeyEvent.VC_ALT) {
            try {
                Field f = NativeInputEvent.class.getDeclaredField("reserved");
				f.setAccessible(true);
				f.setShort(e, (short) 0x01);
            } catch (Exception e1) {
                System.out.println("Failed to consume event!");
            }
            altHeld = true;
            window.setBackground(Color.WHITE);
        }
        
	}

	public void nativeKeyReleased(NativeKeyEvent e) {
        if(e.getKeyCode() == NativeKeyEvent.VC_ALT) {
            try {
                Field f = NativeInputEvent.class.getDeclaredField("reserved");
				f.setAccessible(true);
				f.setShort(e, (short) 0x01);
            } catch (Exception e1) {
                System.out.println("Failed to consume event!");
            }
            altHeld = false;
            window.setVisible(false);
            window.getContentPane().removeAll();
            prev = ' ';
            StringSelection selection = new StringSelection(bg.getSelection().getActionCommand());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(selection, selection);
            
            GlobalScreen.postNativeEvent(new NativeKeyEvent(2401, 2, 162, 29, NativeKeyEvent.CHAR_UNDEFINED));
            GlobalScreen.postNativeEvent(new NativeKeyEvent(2401, 2, 86, 47, NativeKeyEvent.CHAR_UNDEFINED));
            GlobalScreen.postNativeEvent(new NativeKeyEvent(2400, 2, 86, 0, 'v'));
            GlobalScreen.postNativeEvent(new NativeKeyEvent(2402, 2, 86, 47, NativeKeyEvent.CHAR_UNDEFINED));
            GlobalScreen.postNativeEvent(new NativeKeyEvent(2402, 0, 162, 29, NativeKeyEvent.CHAR_UNDEFINED));
        }
	}

	public void nativeKeyTyped(NativeKeyEvent e) {
        if (altHeld && chars.contains(e.getKeyChar())) {
            
            window.setLocation(MouseInfo.getPointerInfo().getLocation());
            
            try {
                Field f = NativeInputEvent.class.getDeclaredField("reserved");
				f.setAccessible(true);
				f.setShort(e, (short) 0x01);
            } catch (Exception e1) {
                System.out.println("Failed to consume event!");
            }
            if(e.getKeyChar() != prev) {
                prev = e.getKeyChar();
                window.getContentPane().removeAll();
                bg = new ButtonGroup();
                for(String l : dictionary.getLetter(e.getKeyChar())) {
                    JRadioButton button = new JRadioButton(l);
                    bg.add(button);
                    window.add(button);
                    button.addMouseListener(new KeyAdapter());
                    button.setActionCommand(l);
                }
                selectFirst(bg);
                window.setVisible(true);
                window.pack();
            }
            else if (e.getKeyChar() == prev) {
                nextButton(bg);
            }
        }
	}

    public Dictionary getDictionary(URL yaml) throws JsonParseException, JsonMappingException, IOException {
        final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        Dictionary dictionary = objectMapper.readValue(yaml, Dictionary.class);
        return dictionary;
    }
    
    public static void selectFirst(ButtonGroup self) {
        Enumeration<AbstractButton> buttons = self.getElements();
        buttons.nextElement().setSelected(true);
    }

    public static void nextButton(ButtonGroup self) {
        int x = 0;
        for (AbstractButton button : Collections.list(self.getElements())) {
            if(x == 1 && !button.isSelected()) {
                button.setSelected(true);
                x = 2;
            }
            if(button.isSelected() && x != 2) {
                x = 1;
            }
        }
        if(x != 2){selectFirst(self);}
    }
}