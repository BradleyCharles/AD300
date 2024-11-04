import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main extends JFrame {

    // Constructor for the main frame
    public Main() {
        setTitle("School Management System"); // Set the title of the frame
        setSize(750, 400); // Set the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Text Area
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10)); // # buttons, # columns, spacing

        
        

        // Display Students Button
        createButton("Display Word Count", e -> {
            



    try {
      File myObj = new File("test.txt");
      Scanner myReader = new Scanner(myObj);
      HashMap<String, Integer> wordCount = new HashMap<>();

      while (myReader.hasNext()) {
        String data = myReader.next();

        wordCount.put(data, wordCount.getOrDefault(data, 0) + 1 );
        
        
      }
      
      textArea.append(wordCount + "\n");
      myReader.close();
    } catch (FileNotFoundException err) {
      System.out.println("An error occurred.");
      err.printStackTrace();
    }

         
            
                
            
        }, buttonPanel);

        // Add button panel to the frame
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