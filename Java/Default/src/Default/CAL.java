package Default;

import java.awt.*;
import javax.swing.*;

public class CAL extends JFrame {
    
    static JButton start, stop, enter;
    static JComboBox<String> level, type;
    static final String[] levelList = {"Easy", "Medium", "Hard"};
    static final String[] typeList = {"Multiply", "Add", "Subtract", "Divide", "Random"};
    static JTextField question, answer;
    static JPanel panel;

    // helper method to add component to the panel
    public static void addComponent(JPanel p, JComponent comp, int x, int y, int width, int height) {
        GridBagConstraints constr = new GridBagConstraints();
        constr.gridx = x;
        constr.gridy = y;
        constr.gridheight = height;
        constr.gridwidth = width;
        constr.weightx = 2.0;
        constr.weighty = 1.0;
        constr.insets = new Insets(1, 1, 1, 1);
        constr.anchor = GridBagConstraints.CENTER;
        constr.fill = GridBagConstraints.BOTH;
        p.add(comp, constr);
    }

    public CAL() {
        
        super("Computer Assisted Learning"); // title of GUI
        panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // set panel's layout

        // initialize components
        start = new JButton("Start");
        stop = new JButton("Stop");
        enter = new JButton("Enter");
        answer = new JTextField(3);
        question = new JTextField("Press start to begin", 33);
        level = new JComboBox<>(levelList);
        type = new JComboBox<>(typeList);

        // disabled textField
        question.setEnabled(false);

        // style components
        start.setFont(new Font("Monospaced", Font.BOLD, 16));
        stop.setFont(new Font("Monospaced", Font.BOLD, 16));
        enter.setFont(new Font("Monospaced", Font.BOLD, 18));
        level.setFont(new Font("Monospaced", Font.PLAIN, 16));
        type.setFont(new Font("Monospaced", Font.PLAIN, 16));
        question.setFont(new Font("Monospaced", Font.BOLD, 19));
        answer.setFont(new Font("Monospaced", Font.BOLD, 21));
        answer.setHorizontalAlignment(JTextField.CENTER);

        // adds components to panel using helper method
        addComponent(panel, level, 0, 0, 1, 1);
        addComponent(panel, type, 2, 0, 1, 1);
        addComponent(panel, question, 0, 1, 3, 1);
        addComponent(panel, start, 0, 3, 1, 1);
        addComponent(panel, answer, 1, 2, 1, 1);
        addComponent(panel, stop, 2, 3, 1, 1);
        addComponent(panel, enter, 1, 3, 1, 1);

        // adds panel to frame
        add(panel);
        
    }

    // main method to invoke the class
    public static void main(String[] args) {
        CAL cal = new CAL();
        cal.setVisible(true);
        cal.pack();
        cal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
