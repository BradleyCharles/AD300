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
        buttonPanel.setLayout(new GridLayout(6, 1, 10, 10)); // # buttons, # columns, spacing


        Circle circle = new Circle("Circle", 5);
        Rectangle rectangle = new Rectangle("Rectangle",4, 6);
        Triangle triangle = new Triangle("Triangle",3, 4, 5);

        // Create buttons and add them to the panel
        {
            JButton button = new JButton("Circle area and perimeter");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.setText(
                            "The circle has an area of "+circle.calculateArea() + " and a perimeter of " +
                            circle.calculatePerimeter()
                    );

                }
            });
            buttonPanel.add(button);
        }
        {
            JButton button = new JButton("What is this ○ shape called?");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    textArea.setText(
                            circle.getName()
                    );
                }

            });
            buttonPanel.add(button);
        }
        {
            JButton button = new JButton("Rectangle area and perimeter");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.setText(
                            "The rectangle has an area of "+rectangle.calculateArea() + " and a perimeter of " +
                                    rectangle.calculatePerimeter()
                    );

                }
            });
            buttonPanel.add(button);
        }
        {
            JButton button = new JButton("What is this ▭ shape called?");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    textArea.setText(
                            rectangle.getName()
                    );
                }

            });
            buttonPanel.add(button);
        }
        {
            JButton button = new JButton("Triangle area and perimeter");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.setText(
                            "The triangle has an area of "+triangle.calculateArea() + " and a perimeter of " +
                                    triangle.calculatePerimeter()
                    );

                }
            });
            buttonPanel.add(button);
        }
        {
            JButton button = new JButton("What is this △ shape called?");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    textArea.setText(
                            triangle.getName()
                    );
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