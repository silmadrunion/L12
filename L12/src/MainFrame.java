import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    JPanel ControlPanel;
    JPanel DesignPanel;

    MainFrame()
    {

        JButton button = new JButton("BUTTON!");
        JTextField textField = new JTextField(15);
        JTextField valueField = new JTextField(15);
        textField.setEditable(true);

        ControlPanel = new JPanel();
        ControlPanel.setBackground(Color.magenta);


        DesignPanel = new JPanel();
        DesignPanel.setBackground(Color.green);

        ControlPanel.add(textField);
        ControlPanel.add(valueField);
        ControlPanel.add(button);

        add(ControlPanel, BorderLayout.NORTH);
        add(DesignPanel, BorderLayout.CENTER);

        MakeComponent componentMaker = new MakeComponent(DesignPanel, textField, valueField);

        button.addActionListener(componentMaker);

        setSize(600, 400);
        //setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new MainFrame();
    }

}
