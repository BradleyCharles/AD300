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

        //normal cases
        Circle circle1 = new Circle("Circle1", 5);
        Circle circle2 = new Circle("Circle2", 10);
        Circle circle3 = new Circle("Circle3", 7);
        //edge cases
        Circle circle4 = new Circle("Circle4", 0);
        Circle circle5 = new Circle("Circle5", -1);
        Circle circle6 = new Circle("Circle6", 999);
        String circleResult =
                circle1.getName() + " has an area of " + circle1.calculateArea() + " and a perimeter of " + circle1.calculatePerimeter() + "\n" +
                circle2.getName() + " has an area of " + circle2.calculateArea() + " and a perimeter of " + circle2.calculatePerimeter() + "\n" +
                circle3.getName() + " has an area of " + circle3.calculateArea() + " and a perimeter of " + circle3.calculatePerimeter() + "\n" +
                circle4.getName() + " has an area of " + circle4.calculateArea() + " and a perimeter of " + circle4.calculatePerimeter() + "\n" +
                circle5.getName() + " has an area of " + circle5.calculateArea() + " and a perimeter of " + circle5.calculatePerimeter() + "\n" +
                circle6.getName() + " has an area of " + circle6.calculateArea() + " and a perimeter of " + circle6.calculatePerimeter() + "\n";

        //normal cases
        Rectangle rectangle1 = new Rectangle("rectangle1", 4, 6);
        Rectangle rectangle2 = new Rectangle("rectangle2", 5, 7);
        Rectangle rectangle3 = new Rectangle("rectangle3", 6, 8);
        //edge cases
        Rectangle rectangle4 = new Rectangle("rectangle4", 0, 0);
        Rectangle rectangle5 = new Rectangle("rectangle5", -1, -2);
        Rectangle rectangle6 = new Rectangle("rectangle6", 999, 1199);
        String rectangleResult =
                rectangle1.getName() + " has an area of " + rectangle1.calculateArea() + " and a perimeter of " + rectangle1.calculatePerimeter() + "\n" +
                rectangle2.getName() + " has an area of " + rectangle2.calculateArea() + " and a perimeter of " + rectangle2.calculatePerimeter() + "\n" +
                rectangle3.getName() + " has an area of " + rectangle3.calculateArea() + " and a perimeter of " + rectangle3.calculatePerimeter() + "\n" +
                rectangle4.getName() + " has an area of " + rectangle4.calculateArea() + " and a perimeter of " + rectangle4.calculatePerimeter() + "\n" +
                rectangle5.getName() + " has an area of " + rectangle5.calculateArea() + " and a perimeter of " + rectangle5.calculatePerimeter() + "\n" +
                rectangle6.getName() + " has an area of " + rectangle6.calculateArea() + " and a perimeter of " + rectangle6.calculatePerimeter() + "\n";

        //normal cases
        Triangle triangle1 = new Triangle("triangle1",3, 4, 5);
        Triangle triangle2 = new Triangle("triangle2",5, 12, 13);
        Triangle triangle3 = new Triangle("triangle3",7, 24, 25);
        //edge cases
        Triangle triangle4 = new Triangle("triangle4",6, 8, 10);
        Triangle triangle5 = new Triangle("triangle5",9, 12, 15);
        Triangle triangle6 = new Triangle("triangle6",10, 24, 26);

        String triangleResult =
                triangle1.getName() + " has an area of " + triangle1.calculateArea() + " and a perimeter of " + triangle1.calculatePerimeter() + "\n" +
                triangle2.getName() + " has an area of " + triangle2.calculateArea() + " and a perimeter of " + triangle2.calculatePerimeter() + "\n" +
                triangle3.getName() + " has an area of " + triangle3.calculateArea() + " and a perimeter of " + triangle3.calculatePerimeter() + "\n" +
                triangle4.getName() + " has an area of " + triangle4.calculateArea() + " and a perimeter of " + triangle4.calculatePerimeter() + "\n" +
                triangle5.getName() + " has an area of " + triangle5.calculateArea() + " and a perimeter of " + triangle5.calculatePerimeter() + "\n" +
                triangle6.getName() + " has an area of " + triangle6.calculateArea() + " and a perimeter of " + triangle6.calculatePerimeter() + "\n";

        // Create buttons and add them to the panel
        {
            JButton button = new JButton("Circle area and perimeter");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.setText(circleResult);

                }
            });
            buttonPanel.add(button);
        }
        {
            JButton button = new JButton("Rectangle area and perimeter");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.setText(rectangleResult);

                }
            });
            buttonPanel.add(button);
        }
        {
            JButton button = new JButton("Triangle area and perimeter");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.setText(triangleResult);

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