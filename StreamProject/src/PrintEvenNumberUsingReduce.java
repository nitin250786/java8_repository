import java.util.ArrayList;
import java.util.List;

public class PrintEvenNumberUsingReduce {
    public static void main(String[] args)
    {
        List<Integer> arr = List.of(1, 2, 3, 4, 5, 6, 7);
        List<Integer> even
                = arr.stream().reduce(new ArrayList<>(),
                (a, b)
                        -> {
                    if (b % 2 == 0)
                        a.add(b);
                    return  a;
                },
                (a, b) -> {
                    a.addAll(b);
                    return a;
                });
        System.out.println(even);
    }
}
