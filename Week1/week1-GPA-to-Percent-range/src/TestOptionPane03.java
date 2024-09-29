import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class TestOptionPane03 {

    public static void main(String[] args) {
        String choice = ask("4.0", "3.9", "3.8", "3.7", "3.6", "3.5", "3.4", "3.3", "3.2", "3.1", "3.0", "2.9", "2.8", "2.7", "2.6", "2.5", "2.4", "2.3", "2.2", "2.1", "2.0", "1.9", "1.8", "1.7", "1.6", "1.5", "1.4", "1.3", "1.2", "1.1", "1.0", "0.0");
        String result = switch (choice) {
            case "4.0" -> "100 % to 95.0%";
            case "3.9" -> "<95.0% to 94.0%";
            case "3.8" -> "<94.0% to 93.0%";
            case "3.7" -> "<93.0% to 92.0%";
            case "3.6" -> "<92.0% to 91.0%";
            case "3.5" -> "<91.0% to 90.0%";
            case "3.4" -> "<90.0% to 89.0%";
            case "3.3" -> "<89.0% to 88.0%";
            case "3.2" -> "<88.0% to 87.0%";
            case "3.1" -> "<87.0% to 86.0%";
            case "3.0" -> "<86.0% to 85.0%";
            case "2.9" -> "<85.0% to 84.0%";
            case "2.8" -> "<84.0% to 83.0%";
            case "2.7" -> "<83.0% to 82.0%";
            case "2.6" -> "<82.0% to 81.0%";
            case "2.5" -> "<81.0% to 80.0%";
            case "2.4" -> "<80.0% to 79.0%";
            case "2.3" -> "<79.0% to 78.0%";
            case "2.2" -> "<78.0% to 77.0%";
            case "2.1" -> "<77.0% to 76.0%";
            case "2.0" -> "<76.0% to 75.0%";
            case "1.9" -> "<75.0% to 74.0%";
            case "1.8" -> "<74.0% to 73.0%";
            case "1.7" -> "<73.0% to 72.0%";
            case "1.6" -> "<72.0% to 71.0%";
            case "1.5" -> "<71.0% to 70.0%";
            case "1.4" -> "<70.0% to 69.0%";
            case "1.3" -> "<69.0% to 68.0%";
            case "1.2" -> "<68.0% to 67.0%";
            case "1.1" -> "<67.0% to 66.0%";
            case "1.0" -> "<66.0% to 0.0%";
            default -> "0.0%";
        };



        JFrame frame = new JFrame("Main Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(frame, "Your percent range is: " + result);
        System.exit(0);




    }

    public static String ask(final String... values) {

        String result = null;

        if (EventQueue.isDispatchThread()) {

            JPanel panel = new JPanel();
            panel.add(new JLabel("Please select your range:"));
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            for (String value : values) {
                model.addElement(value);
            }
            JComboBox comboBox = new JComboBox(model);
            panel.add(comboBox);

            int iResult = JOptionPane.showConfirmDialog(null, panel, "GPA to percent range", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            switch (iResult) {
                case JOptionPane.OK_OPTION:
                    result = (String) comboBox.getSelectedItem();
                    break;
            }

        } else {

            Response response = new Response(values);
            try {
                SwingUtilities.invokeAndWait(response);
                result = response.getResponse();
            } catch (InterruptedException | InvocationTargetException ex) {
                ex.printStackTrace();
            }

        }

        return result;

    }

    public static class Response implements Runnable {

        private String[] values;
        private String response;

        public Response(String... values) {
            this.values = values;
        }

        @Override
        public void run() {
            response = ask(values);
        }

        public String getResponse() {
            return response;
        }
    }
}