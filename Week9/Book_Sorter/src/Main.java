
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.*;

import static java.util.Collections.sort;

public class Main extends JFrame {

    // Constructor for the main frame
    public Main() {

        List<Book> bookSet = new ArrayList<>();

        // Add books to the HashSet
        bookSet.add(new Book("The Whispering Shadows", "Declan Frost", 2023));
        bookSet.add(new Book("Echoes of Tomorrow", "Declan Frost", 2021));
        bookSet.add(new Book("Beneath the Silver Moon", "Lucian Rivers", 2020));
        bookSet.add(new Book("The Forgotten Key", "Lucian Rivers", 2022));
        bookSet.add(new Book("The Last Ember", "Lucian Rivers", 2024));
        bookSet.add(new Book("Winds of the Forgotten Realm", "Katherine Wilder", 2019));
        bookSet.add(new Book("In the Heart of the Storm", "Declan Frost", 2021));
        bookSet.add(new Book("The Midnight Oracle", "Seraphina Vale", 2020));
        bookSet.add(new Book("A Song of Thorns", "Maximilian Drake", 2023));
        bookSet.add(new Book("The Clockmaker's Curse", "Violet Ravenscroft", 2022));
        bookSet.add(new Book("The Shattered Crown", "Seraphina Vale", 2018));
        bookSet.add(new Book("Through the Veil of Stars", "Amelia Nightshade", 2024));
        bookSet.add(new Book("Fate's Call", "Seraphina Vale", 2017));
        bookSet.add(new Book("The Cursed Library", "Iris Montgomery", 2021));
        bookSet.add(new Book("The Silent Scribe", "Seraphina Vale", 2023));
        bookSet.add(new Book("A Dance of Fire and Ice", "Lydia Everhart", 2020));
        bookSet.add(new Book("The Veil Between Worlds", "Declan Frost", 2022));
        bookSet.add(new Book("The Bloodstone Prophecy", "Fiona Ashford", 2024));
        bookSet.add(new Book("Whispers in the Void", "Declan Frost", 2021));
        bookSet.add(new Book("The Lost Kingdoms", "Edgar Marlowe", 2019));
        bookSet.add(new Book("Waking the Sleeping Gods", "Penelope Vane", 2020));
        bookSet.add(new Book("The Hollow Throne", "Roland Wycliffe", 2023));
        bookSet.add(new Book("Of Fire and Frost", "Lucian Rivers", 2021));
        bookSet.add(new Book("The Alchemist's Legacy", "Lucian Rivers", 2022));
        bookSet.add(new Book("Journey to the Edge of Night", "Lucian Rivers", 2024));

        setTitle("School Management System"); // Set the title of the frame
        setSize(750, 500); // Set the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Text Area
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 10, 10)); // # buttons, # columns, spacing

        // Display buttons
        createButton("Sort by Title", e -> {
            try {
                textArea.setText("");
                bookSet.sort(new Book.compareTitle());
                for (Book book : bookSet) {
                    textArea.append(book.getTitle() + " by " + book.getAuthor() + " (" + book.getYear() + ")\n");
                }
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        // Add button panel to the frame
        add(buttonPanel, BorderLayout.EAST);
        setLocationRelativeTo(null);
        setVisible(true);

        createButton("Sort by Author", e -> {
            try {
                textArea.setText("");
                bookSet.sort(new Book.compareAuthor());
                for (Book book : bookSet) {
                    textArea.append(book.getTitle() + " by " + book.getAuthor() + " (" + book.getYear() + ")\n");
                }
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        // Add button panel to the frame
        add(buttonPanel, BorderLayout.EAST);
        setLocationRelativeTo(null);
        setVisible(true);

        createButton("Sort by Year", e -> {
            try {
                textArea.setText("");
                bookSet.sort(new Book.compareYear());
                for (Book book : bookSet) {
                    textArea.append(book.getTitle() + " by " + book.getAuthor() + " (" + book.getYear() + ")\n");
                }
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Sort by Author then Year", e -> {
            try {
                textArea.setText("");
                bookSet.sort(new Book.compareAuthor().thenComparing(new Book.compareTitle()));

                String currentAuthor = ""; // To track the current author
                for (Book book : bookSet) {
                    if (!book.getAuthor().equals(currentAuthor)) {
                        if (!currentAuthor.isEmpty()) {
                            textArea.append("---------------------------------------------------------------\n"); // Add separator before a new author's books
                        }
                        currentAuthor = book.getAuthor();
                    }
                    textArea.append(book.getTitle() + " by " + book.getAuthor() + " (" + book.getYear() + ")\n");
                }
            } catch (Exception err) {
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}