
/*
2. andThen()

        It returns a composed BiConsumer wherein the parameterized BiConsumer will be executed after the first one. If the evaluation of either operation throws an error, it is relayed to the caller of the composed operation.

        Note: The operation being passed as the argument should be of type BiConsumer.

        Syntax:

default BiConsumer <T, U>
        andThen(BiConsumer<? super T, ? super U> after)
        Parameters: This method accepts a parameter after which is the BiConsumer to be applied after the current one.
        Return Value: This method returns a composed BiConsumer that first applies the current operation first and then the after operation.

        Exception: This method throws NullPointerException if the after operation is null.

*/

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerSampleAndThan {
    public static void main(String args[])
    {

        // Create first list
        List<Integer> lista = new ArrayList<Integer>();
        lista.add(2);
        lista.add(1);
        lista.add(3);

        // Create second list
        List<Integer> listb = new ArrayList<>();
        listb.add(2);
        listb.add(1);
        listb.add(2);

        // BiConsumer to compare 2 lists of integers
        BiConsumer<List<Integer>, List<Integer> > equals = (list1, list2) ->
        {
            if (list1.size() != list2.size()) {
                System.out.println("False");
            }
            else {
                for (int i = 0; i < list1.size(); i++)
                    if (list1.get(i) != list2.get(i)) {
                        System.out.println("False");
                        return;
                    }
                System.out.println("True");
            }
        };

        // BiConsumer to print 2 lists
        BiConsumer<List<Integer>, List<Integer> > disp = (list1, list2) ->
        {
            list1.stream().forEach(a -> System.out.print(a + " "));
            System.out.println();
            list2.stream().forEach(a -> System.out.print(a + " "));
            System.out.println();
        };

        // Using addThen() method
        equals.andThen(disp).accept(lista, listb);

        System.out.println("######################################################");


        // Create first list
        List<Integer> listp = new ArrayList<Integer>();
        listp.add(2);
        listp.add(1);
        listp.add(3);

        // Create second list
        List<Integer> listq = new ArrayList<Integer>();
        listq.add(2);
        listq.add(1);

        // BiConsumer to compare 2 lists of integers
        BiConsumer<List<Integer>, List<Integer> > equals1 = (listM, listN) ->
        {
            for (int i = 0; i < listM.size(); i++)
                if (listM.get(i) != listN.get(i)) {
                    System.out.println("False");
                    return;
                }
            System.out.println("True");
        };

        // BiConsumer to print 2 lists
        BiConsumer<List<Integer>, List<Integer> > disp1 = (listM, listN) ->
        {
            listM.stream().forEach(a -> System.out.print(a + " "));
            System.out.println();
            listN.stream().forEach(a -> System.out.print(a + " "));
            System.out.println();
        };

        try {
            disp1.andThen(equals1).accept(listp, listq);
        }
        catch (Exception e) {
            System.out.println("Exception : " + e);
        }

    }

}
