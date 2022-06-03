package phonotype;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import phonotype.Buttons.Buttons;
import phonotype.Chart.Chart;
import phonotype.Settings.Settings;
import phonotype.Typing.Editor.Editor;

public class App extends JFrame {
    App() throws JsonParseException, JsonMappingException, IOException {
        initialize();
    }

    public void initialize() throws JsonParseException, JsonMappingException, IOException {
        InputStream imageInputStream = this.getClass().getResourceAsStream("/iconBlack.png");
        BufferedImage bufferedImage = ImageIO.read(imageInputStream);
        setIconImage(bufferedImage);

        setTitle("Phonotype");
        setSize(640, 400);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Tray tray = new Tray(this);
        Editor editor = new Editor();

        Settings settings = new Settings(this);
        Chart chart = new Chart();
        Buttons buttons = new Buttons(tray, editor);

        add(settings, BorderLayout.NORTH);
        add(chart, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
    }
    public static void main(String[] args) {
        try {new App();} catch (IOException e) {e.printStackTrace();}
    }
}