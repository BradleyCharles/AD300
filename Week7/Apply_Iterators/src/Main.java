
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;
import javax.swing.*;

public class Main extends JFrame {

    // Constructor for the main frame
    public Main() {
        setTitle("School Management System"); // Set the title of the frame
        setSize(1200, 400); // Set the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Text Area
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 4, 10, 10)); // # buttons, # columns, spacing


        ArrayList<Integer> arrayNumbers = new ArrayList<>();
        arrayNumbers.add(10);
        arrayNumbers.add((int) (11 * Math.random()));
        arrayNumbers.add((int) (11 * Math.random()));
        arrayNumbers.add((int) (11 * Math.random()));
        arrayNumbers.add((int) (11 * Math.random()));
        arrayNumbers.add((int) (11 * Math.random()));
        arrayNumbers.add((int) (11 * Math.random()));
        arrayNumbers.add((int) (11 * Math.random()));
        arrayNumbers.add((int) (11 * Math.random()));
        arrayNumbers.add(10);

        HashMap<String, Integer> categoryCounts = new HashMap<>();
        categoryCounts.put("Books", 12);
        categoryCounts.put("Movies", 8);
        categoryCounts.put("Games", 15);
        categoryCounts.put("Music", 20);
        categoryCounts.put("Clothes", 5);
        categoryCounts.put("Electronics", 7);
        categoryCounts.put("Toys", 10);
        categoryCounts.put("Furniture", 4);
        categoryCounts.put("Groceries", 25);
        categoryCounts.put("Sports Equipment", 9);

        TreeMap<String, Double> monthlyTemperatures = new TreeMap<>();
        monthlyTemperatures.put("January | 2020", 71.0);
        monthlyTemperatures.put("February | 2018", 77.0);
        monthlyTemperatures.put("March | 2017", 83.0);
        monthlyTemperatures.put("April | 2019", 89.0);
        monthlyTemperatures.put("May | 2020", 95.0);
        monthlyTemperatures.put("June | 2021", 98.0);
        monthlyTemperatures.put("July | 2021", 101.0);
        monthlyTemperatures.put("August | 2020", 101.5);
        monthlyTemperatures.put("September | 2020", 99.0);
        monthlyTemperatures.put("October | 2019", 89.0);
        monthlyTemperatures.put("November | 2018", 79.0);
        monthlyTemperatures.put("December | 2018", 72.0);

        //-------------------------------------------------------------------------------------------------------------- ArrayList ---

        // ArrayList Buttons
        createButton("ArrayList - Display Numbers", e -> {
            try {
                StringBuilder output = new StringBuilder("Random Numbers:\n"+" ");
                for (int number : arrayNumbers) {
                    output.append(number).append(" ");
                }
                textArea.setText(output.toString());
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("ArrayList - Add Numbers", e -> {
            try {
                StringBuilder output = new StringBuilder("Sum of arrayNumbers:\n"+" ");
                int arraylistSum = 0;
                Iterator<Integer> iterator = arrayNumbers.iterator();
                while (iterator.hasNext()) {
                    arraylistSum += iterator.next();
                }
                output.append(arraylistSum).append(" ");
                textArea.setText(output.toString());
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("ArrayList - Iterator Remove", e -> {
            try {
                Iterator<Integer> iterator = arrayNumbers.iterator();
                while (iterator.hasNext()) {
                    int number = iterator.next();
                    if (number == 10){
                        iterator.remove();
                    }
                }
                textArea.setText(" All values of 10 have been removed");
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("ArrayList - ArrayList Remove", e -> {
            try {
                    arrayNumbers.remove(Integer.valueOf(10));
                textArea.setText(" Removed the first value of 10");
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);


        //-------------------------------------------------------------------------------------------------------------- HashMap ---


        createButton("Hashmap - Display All", e -> {
            try {
                StringBuilder output = new StringBuilder("Categories and Counts:\n"+" ");
                for (HashMap.Entry<String, Integer> entry : categoryCounts.entrySet()) {
                    output.append(entry.getKey()).append(": ").append(entry.getValue()).append(" \n"+" ");
                }
                textArea.setText(" " + output);
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Hashmap - Update Movies", e -> {
            try {
                for (String key : categoryCounts.keySet()) {
                    if (categoryCounts.get(key) == 8) {
                        categoryCounts.put(key, 999);
                    }
                }
                textArea.setText(" Updated movies!");
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Hashmap - Remove Movies", e -> {
            try {
                categoryCounts.remove("Movies");
                textArea.setText(" Removed movies!");
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Hashmap - Add Movies", e -> {
            try {
                categoryCounts.put("Movies", 8);
                textArea.setText(" Added movies!");
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        //-------------------------------------------------------------------------------------------------------------- TreeMap ---

        createButton("TreeMap - Display Months", e -> {
            try {
                StringBuilder output = new StringBuilder("Our planet is dying:\n These are the hottest days recorded\n for each month since 2017\n\n"+" ");
                for (var entry : monthlyTemperatures.entrySet()) {
                    output.append(entry.getKey()).append(": ").append(entry.getValue()).append(" \n"+" ");
                }
                textArea.setText(" " + output);
            }catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("TreeMap - Hottest Temperature", e -> {
            try {
                Double maxValue = 0.0;
                String maxKey = null;
                for (var entry : monthlyTemperatures.entrySet()) {
                    if (entry.getValue() > maxValue) {
                        maxValue = entry.getValue();
                        maxKey = entry.getKey();
                    }
                }
                textArea.setText(" The hottest temperature was\n" + " " +maxKey + " at " + maxValue+" degrees");
            }catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("TreeMap - Coldest Temperature", e -> {
            try {
                Double maxValue = 200.0;
                String maxKey = null;
                for (var entry : monthlyTemperatures.entrySet()) {
                    if (entry.getValue() < maxValue) {
                        maxValue = entry.getValue();
                        maxKey = entry.getKey();
                    }
                }
                textArea.setText(" The Coldest temperature was\n" + " " +maxKey + " at " + maxValue+" degrees");
            }catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("TreeMap - Secret", e -> {
            try {

                monthlyTemperatures.put("Ophiuchus | 2024",13.13);
                textArea.setText(" 13th month added");
            }catch (Exception err) {
                System.out.println("An error occurred.");
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

    // Method to sort the map by value
    private static Map<String, Integer> sortByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));

        Map<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
