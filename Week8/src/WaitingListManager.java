import javax.swing.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WaitingListManager {

    private final Set<String> checkDuplicate = new HashSet<>();
    private final Queue<String> waitingList = new LinkedList<>();

    JFrame frame = new JFrame("");
    public void popup(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    public void addPerson(String name) {
        if (!checkDuplicate.add(name)) {
            popup("Person is already in the queue.");
            return;
        }
        waitingList.add(name);
    }

    public String servePerson() {
        if (waitingList.isEmpty()) {
            popup("Queue is empty.");
            return null;
        }
        String servedPerson = waitingList.poll();
        checkDuplicate.remove(servedPerson);
        return servedPerson;
    }

    void isPersonInList(String name) {
        if (checkDuplicate.contains(name)) {
            popup("Person is already in the queue.");
        } else {
            popup("Person is not in the queue.");
        }
    }

    public int waitingListSize() {
        return waitingList.size();
    }

    public String displayWaitingList() {
        if (waitingList.isEmpty()) {
            popup("The waiting list is empty.");
            return "";
        }
        return String.join(", ", waitingList);
    }
}