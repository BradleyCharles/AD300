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
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10)); // # buttons, # columns, spacing
        
        // Create instances of the media players
        AudioPlayer audioPlayer = new AudioPlayer();
        VideoPlayer videoPlayer = new VideoPlayer();
        StreamingPlayer streamingPlayer = new StreamingPlayer();

        // Create buttons and add them to the panel
        createButton("Test the audio player", e -> {
            textArea.setText(
                audioPlayer.play() + "\n" +
                audioPlayer.pause() + "\n" +
                audioPlayer.stop()
            );
        }, buttonPanel);

        createButton("Test the video player", e -> {
            textArea.setText(
                videoPlayer.play() + "\n" +
                videoPlayer.pause() + "\n" +
                videoPlayer.stop()
            );
        }, buttonPanel);

        createButton("Test the streaming player", e -> {
            textArea.setText(
                streamingPlayer.play() + "\n" +
                streamingPlayer.pause() + "\n" +
                streamingPlayer.stop()
            );
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
