import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortingUtils {


    public String sortList(List<String> list) {
        Collections.sort(list);
        return list.toString();
    }

    public List filterList(List<Integer> list) {
        return list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());

    }


}
