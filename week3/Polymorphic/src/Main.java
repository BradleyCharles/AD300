import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    // Constructor for the main frame
    public Main() {
        // Set the frame's title
        setTitle("Main Frame with Buttons and Text Box");
        // Set the size of the frame
        setSize(500, 200);
        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the layout to BorderLayout
        setLayout(new BorderLayout());

        // Create a JTextArea for displaying text
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false); // Make it read-only
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Create a panel for the buttons and set its layout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10)); // 5 buttons, 1 column, spacing of 10






//        Animal[] arr;
//        arr = new Animal[5];
//        arr[0] = new Snake("Snake", 3);
//        arr[1] = new Rabbit("Rabbit", 2);
//        arr[2] = new Bat("Bat", 5);
//        arr[3] = new Racoon("Racoon", 6);
//        arr[4] = new Ferret("Ferret", 4);
//
//        // Create buttons and add them to the panel
//        {
//            JButton button = new JButton("Snake");
//            button.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    textArea.setText(
//                            arr[0].displayInfo() + "\n"
//                                    + arr[0].eat() + "\n"
//                                    + arr[0].sleep() + "\n"
//                                    + arr[0].makeSound() + "\n");
//
//                }
//            });
//            buttonPanel.add(button);
//        }
//        {
//            JButton button = new JButton("Rabbit");
//
//            button.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    textArea.setText(
//                            arr[1].displayInfo() + "\n"
//                                    + arr[1].eat() + "\n"
//                                    + arr[1].sleep() + "\n"
//                                    + arr[1].makeSound() + "\n");
//                }
//            });
//            buttonPanel.add(button);
//        }


        // Add the button panel to the right side of the frame
        add(buttonPanel, BorderLayout.EAST);
        setLocationRelativeTo(null);
        // Make the frame visible
        setVisible(true);
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Create an instance of MainFrame
        SwingUtilities.invokeLater(Main::new);
    }

    public static class Animal {
        public String name;
        public int age;

        public Animal(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String displayInfo() {
            return "You are looking at a " + this.name + ". it is " + this.age + " years old.";
        }

        public String eat() {
            return "This " + this.name + " is eating.";
        }

        public String sleep() {
            return "The other " + this.name + "'s are sleeping.";
        }

        public String makeSound() {
            return "The animal is making a sound.";
        }

    }

    public static class Snake extends Animal {


        public Snake(String snake, int i) {
            super(snake, i);
        }

        @Override
        public String makeSound() {
            return "The snake makes a hissing sound!";

        }
    }

    public static class Rabbit extends Animal {


        public Rabbit(String rabbit, int i) {
            super(rabbit, i);
        }

        @Override
        public String makeSound() {
            return "The Rabbit makes a purring sound!";

        }
    }

    public static class Bat extends Animal {


        public Bat(String bat, int i) {
            super(bat, i);

        }

        @Override
        public String makeSound() {
            return "The Bat makes a squeaking sound!";

        }
    }

    public static class Racoon extends Animal {


        public Racoon(String racoon, int i) {
            super(racoon, i);
        }

        @Override
        public String makeSound() {
            return "The racoon makes a chirping sound!";

        }
    }

    public static class Ferret extends Animal {


        public Ferret(String ferret, int i) {
            super(ferret, i);
        }

        @Override
        public String makeSound() {
            return "The ferret makes a dooking sound!";

        }
    }
}