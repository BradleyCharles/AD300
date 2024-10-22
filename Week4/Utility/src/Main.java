import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    // Constructor for the main frame
    public Main() {
        setTitle("Media Player Tester"); // Set the title of the frame
        setSize(750, 400); // Set the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 10, 10)); // # buttons, # columns, spacing
        
        // Create buttons to test MathUtils methods
        createButton("Test Addition", e -> {
            StringBuilder result = new StringBuilder();
            result.append("5 + 3 = " + MathUtils.add(5, 3) + "\n");
            result.append("0 + 0 = " + MathUtils.add(0, 0) + "\n");
            result.append("-1 + 1 = " + MathUtils.add(-1, 1) + "\n");
            result.append("Integer.MAX_VALUE + 1 = " + MathUtils.add(Integer.MAX_VALUE, 1));
            textArea.setText(result.toString());
        }, buttonPanel);

        createButton("Test Subtraction", e -> {
            StringBuilder result = new StringBuilder();
            result.append("10 - 4 = " + MathUtils.subtract(10, 4) + "\n");
            result.append("0 - 0 = " + MathUtils.subtract(0, 0) + "\n");
            result.append("-1 - (-1) = " + MathUtils.subtract(-1, -1) + "\n");
            result.append("Integer.MIN_VALUE - 1 = " + MathUtils.subtract(Integer.MIN_VALUE, 1));
            textArea.setText(result.toString());
        }, buttonPanel);

        createButton("Test Multiplication", e -> {
            StringBuilder result = new StringBuilder();
            result.append("6 * 7 = " + MathUtils.multiply(6, 7) + "\n");
            result.append("0 * 5 = " + MathUtils.multiply(0, 5) + "\n");
            result.append("-3 * 4 = " + MathUtils.multiply(-3, 4) + "\n");
            result.append("Integer.MAX_VALUE * 2 = " + MathUtils.multiply(Integer.MAX_VALUE, 2));
            textArea.setText(result.toString());
        }, buttonPanel);

        createButton("Test Division", e -> {
            StringBuilder result = new StringBuilder();
            result.append("20 / 4 = " + MathUtils.divide(20, 4) + "\n");
            result.append("1 / 3 = " + MathUtils.divide(1, 3) + "\n");
            result.append("-10 / 2 = " + MathUtils.divide(-10, 2) + "\n");
            result.append("5 / 0 = " + MathUtils.divide(5, 0));
            textArea.setText(result.toString());
        }, buttonPanel);

        add(buttonPanel, BorderLayout.EAST);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createButton(String text, ActionListener listener, JPanel panel) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        panel.add(button);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }


}
