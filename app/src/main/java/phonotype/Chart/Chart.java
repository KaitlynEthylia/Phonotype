package phonotype.Chart;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class Chart extends JPanel{
    public Chart() throws JsonParseException, JsonMappingException, IOException {
        setLayout(new GridLayout(9, 22, 1, 1));

        List<Letter> letters = getLetter(this.getClass().getResource("/data.yaml"));
        for(Letter l: letters) {
            JButton b = new JButton();
            if(l.getLabeled()){b.setText(l.getValue());}
            if(l.getValue() == ""){b.setEnabled(false);}
            b.setActionCommand(l.getValue());
            b.addActionListener(new ChartListener());
            b.setMargin(new Insets(0, 0, 0, 0));
            b.setFont(new Font("PataltinoLinotype", Font.PLAIN, 16));
            b.setToolTipText(l.getTitle());
            add(b);
        }
        
    }
    
    public List<Letter> getLetter(URL yaml) throws JsonParseException, JsonMappingException, IOException {
        final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        List<Letter> letters = objectMapper.readValue(yaml, new TypeReference<List<Letter>>(){});
        return letters;
    }
}
