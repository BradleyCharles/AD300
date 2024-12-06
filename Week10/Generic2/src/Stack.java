import java.util.ArrayList;

// Generic Stack class
public class Stack<T> {
    private final ArrayList<T> elements;

    // Constructor to initialize the stack
    public Stack() {
        elements = new ArrayList<>();
    }

    public Stack(ArrayList<T> elements) {
        this.elements = elements;
    }

    // Push an element onto the stack
    public void push(T item) {
        elements.add(item);
    }

    // Pop an element from the stack
    public T pop() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Stack underflow: Cannot pop from an empty stack.");
        }
        return elements.removeLast();
    }

    public ArrayList<T> printStack () {
        return elements;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
