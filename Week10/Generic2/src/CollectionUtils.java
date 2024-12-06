import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionUtils {

    // Method to print each item in a collection
    public static String printCollection(Collection<?> collection) {
        return collection.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    // Method to sum elements of a list of numbers
    public static double sumOfNumberList(List<? extends Number> list) {
        double sum = 0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }





}