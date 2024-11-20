
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;



public class Main extends JFrame {









    // Constructor for the main frame
    public Main() {






        HashSet<Book> bookSet = new HashSet<>();
        // Add books to the HashSet
        bookSet.add(new Book("The Whispering Shadows", "Alden Whitmore", 2023));
        bookSet.add(new Book("Echoes of Tomorrow", "Selene Blackwood", 2021));
        bookSet.add(new Book("Beneath the Silver Moon", "Elias Gray", 2020));
        bookSet.add(new Book("The Forgotten Key", "Isabella Thornfield", 2022));
        bookSet.add(new Book("The Last Ember", "Lucian Rivers", 2024));
        bookSet.add(new Book("Winds of the Forgotten Realm", "Katherine Wilder", 2019));
        bookSet.add(new Book("In the Heart of the Storm", "Dorian Storm", 2021));
        bookSet.add(new Book("The Midnight Oracle", "Seraphina Vale", 2020));
        bookSet.add(new Book("A Song of Thorns", "Maximilian Drake", 2023));
        bookSet.add(new Book("The Clockmaker's Curse", "Violet Ravenscroft", 2022));
        bookSet.add(new Book("The Shattered Crown", "Harrison Crowe", 2018));
        bookSet.add(new Book("Through the Veil of Stars", "Amelia Nightshade", 2024));
        bookSet.add(new Book("Fate's Call", "Augustus Wren", 2017));
        bookSet.add(new Book("The Cursed Library", "Iris Montgomery", 2021));
        bookSet.add(new Book("The Silent Scribe", "Jasper Hawke", 2023));
        bookSet.add(new Book("A Dance of Fire and Ice", "Lydia Everhart", 2020));
        bookSet.add(new Book("The Veil Between Worlds", "Oliver Blackstone", 2022));
        bookSet.add(new Book("The Bloodstone Prophecy", "Fiona Ashford", 2024));
        bookSet.add(new Book("Whispers in the Void", "Declan Frost", 2021));
        bookSet.add(new Book("The Lost Kingdoms", "Edgar Marlowe", 2019));
        bookSet.add(new Book("Waking the Sleeping Gods", "Penelope Vane", 2020));
        bookSet.add(new Book("The Hollow Throne", "Roland Wycliffe", 2023));
        bookSet.add(new Book("Of Fire and Frost", "Fiona Sterling", 2021));
        bookSet.add(new Book("The Alchemist's Legacy", "Gideon Redfern", 2022));
        bookSet.add(new Book("Journey to the Edge of Night", "Ophelia Crane", 2024));

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

        // Display buttons
        createButton("Sort by Title", e -> {
            try {
                textArea.setText("");
                for (Book book : bookSet) {
                    book.compareTitle(book.getTitle());
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
                for (Book book : bookSet) {
                    book.compareAuthor(book);
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
                for (Book book : bookSet) {
                    book.compareYear(book);
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
