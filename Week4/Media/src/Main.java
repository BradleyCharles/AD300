import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    // Constructor for the main frame
    public Main() {
        setTitle("Animals.. am I right??");
        setSize(750, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10)); // # buttons, # columns, spacing

        Elephant elephant = new Elephant("Dumbo");

        // Create buttons and add them to the panel
        {
            JButton button = new JButton("What does the elephant sound like?");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    elephant.makeSound();
                }
            });
            buttonPanel.add(button);
        }
        {
            JButton button = new JButton("What is the sound a elephant makes called? (3 times)");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    textArea.setText(
                            elephant.getName() + " the elephant trumpets " +
                     elephant.makeSound(2) + "!");
                }

            });
            buttonPanel.add(button);
        }
        

        add(buttonPanel, BorderLayout.EAST);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }


}