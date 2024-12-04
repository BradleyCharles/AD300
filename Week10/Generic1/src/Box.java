public class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public void setValue(T value) {this.value = value;}

    public T getValue() {return value;}

    public String printBox() {
       return value.toString();
    }

    public static String printBox(Box<? extends Number> box) {
        // Demonstrates flexibility with wildcards by accessing Number-specific methods
        return "Box contains: " + box.getValue() + " (double value: " + box.getValue().doubleValue() + ")";
    }





}
