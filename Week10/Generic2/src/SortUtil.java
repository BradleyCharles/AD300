import java.util.Arrays;
import java.util.Comparator;

public class SortUtil {
    public static <T extends Comparable<T>> void sort(T[] a) {
        Arrays.sort(a, new Comparator<T>()
        {
            @Override
            public int compare(T o1, T o2)
            {
                return (o1.compareTo(o2));
            }
        });
    }
}
