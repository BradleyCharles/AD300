public class CustomSort implements Comparable<CustomSort> {
    private final String name;
    private final int age;

    public CustomSort(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(CustomSort other) {
        return Integer.compare(this.age, other.age); // Sort by age
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}