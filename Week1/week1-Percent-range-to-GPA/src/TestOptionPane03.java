import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class TestOptionPane03 {

    public static void main(String[] args) {
        String choice = ask("100 % to 95.0%", "<95.0% to 94.0%", "<94.0% to 93.0%", "<93.0% to 92.0%", "<92.0% to 91.0%", "<91.0% to 90.0%", "<90.0% to 89.0%", "<89.0% to 88.0%", "<88.0% to 87.0%", "<87.0% to 86.0%", "<86.0% to 85.0%", "<85.0% to 84.0%", "<84.0% to 83.0%", "<83.0% to 82.0%", "<82.0% to 81.0%", "<81.0% to 80.0%", "<80.0% to 79.0%", "<79.0% to 78.0%", "<78.0% to 77.0%", "<77.0% to 76.0%", "<76.0% to 75.0%", "<75.0% to 74.0%", "<74.0% to 73.0%", "<73.0% to 72.0%", "<72.0% to 71.0%", "<71.0% to 70.0%", "<70.0% to 69.0%", "<69.0% to 68.0%", "<68.0% to 67.0%", "<67.0% to 66.0%", "<66.0% to 65.0%", "<65.0% to 0.0%");
        String result = "Null";

        if (choice.equals("100 % to 95.0%")) {
            result = "4.0";
        } else if (choice.equals("<95.0% to 94.0%")) {
            result = "3.9";
        } else if (choice.equals("<94.0% to 93.0%")) {
            result = "3.8";
        } else if (choice.equals("<93.0% to 92.0%")) {
            result = "3.7";
        } else if (choice.equals("<92.0% to 91.0%")) {
            result = "3.6";
        } else if (choice.equals("<91.0% to 90.0%")) {
            result = "3.5";
        } else if (choice.equals("<90.0% to 89.0%")) {
            result = "3.4";
        } else if (choice.equals("<89.0% to 88.0%")) {
            result = "3.3";
        } else if (choice.equals("<88.0% to 87.0%")) {
            result = "3.2";
        } else if (choice.equals("<87.0% to 86.0%")) {
            result = "3.1";
        } else if (choice.equals("<86.0% to 85.0%")) {
            result = "3.0";
        } else if (choice.equals("<85.0% to 84.0%")) {
            result = "2.9";
        } else if (choice.equals("<84.0% to 83.0%")) {
            result = "2.8";
        } else if (choice.equals("<83.0% to 82.0%")) {
            result = "2.7";
        } else if (choice.equals("<82.0% to 81.0%")) {
            result = "2.6";
        } else if (choice.equals("<81.0% to 80.0%")) {
            result = "2.5";
        } else if (choice.equals("<80.0% to 79.0%")) {
            result = "2.4";
        } else if (choice.equals("<79.0% to 78.0%")) {
            result = "2.3";
        } else if (choice.equals("<78.0% to 77.0%")) {
            result = "2.2";
        } else if (choice.equals("<77.0% to 76.0%")) {
            result = "2.1";
        } else if (choice.equals("<76.0% to 75.0%")) {
            result = "2.0";
        } else if (choice.equals("<75.0% to 74.0%")) {
            result = "1.9";
        } else if (choice.equals("<74.0% to 73.0%")) {
            result = "1.8";
        } else if (choice.equals("<73.0% to 72.0%")) {
            result = "1.7";
        } else if (choice.equals("<72.0% to 71.0%")) {
            result = "1.6";
        } else if (choice.equals("<71.0% to 70.0%")) {
            result = "1.5";
        } else if (choice.equals("<70.0% to 69.0%")) {
            result = "1.4";
        } else if (choice.equals("<69.0% to 68.0%")) {
            result = "1.3";
        } else if (choice.equals("<68.0% to 67.0%")) {
            result = "1.2";
        } else if (choice.equals("<67.0% to 66.0%")) {
            result = "1.1";
        } else if (choice.equals("<66.0% to 65.0%")) {
            result = "1.0";
        } else if (choice.equals("<65.0% to 0.0%")) {
            result = "0.0";
        }



            JFrame frame = new JFrame("Main Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(frame, "You have a GPA of " + result);
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