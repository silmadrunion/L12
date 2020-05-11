import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

public class MakeComponent implements ActionListener {

    private JPanel destination;
    private JTextField className;
    private JTextField value;

    MakeComponent(JPanel destination, JTextField className, JTextField value)
    {
        this.destination = destination;
        this.className = className;
        this.value = value;
    }

    public void actionPerformed(ActionEvent e) {

        Class classname = null;
        ClassLoader classLoader;

        try {
            classname = Class.forName(className.getText());
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }

        Object o = null;

        String params = value.getText();

        try {
            if(params!=null) {
                o = classname.getDeclaredConstructor(String.class).newInstance(params);
            }
            else o = classname.getDeclaredConstructor().newInstance();
        } catch (InstantiationException instantiationException) {
            instantiationException.printStackTrace();
        } catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        } catch (InvocationTargetException invocationTargetException) {
            invocationTargetException.printStackTrace();
        } catch (NoSuchMethodException noSuchMethodException) {
            noSuchMethodException.printStackTrace();
        }


        destination.add((Component) o);
        destination.doLayout();
    }
}
