import java.util.Objects;
import java.util.function.Predicate;

/*
The Functional Interface PREDICATE is defined in the java.util.function package. It improves manageability of code, helps in unit-testing them separately, and contain some methods like:

1. isEqual(Object targetRef) : Returns a predicate that tests if two arguments are equal according to Objects.equals(Object, Object).
2. and(Predicate other) : Returns a composed predicate that represents a short-circuiting logical AND of this predicate and another.
3. or(Predicate other) : Returns a composed predicate that represents a short-circuiting logical OR of this predicate and another.
4. negate() : Returns a predicate that represents the logical negation of this predicate.
5. test(T t) : Evaluates this predicate on the given argument.boolean test(T t)
*/
public class PREDICATEFunctionSample {
    public static void main(String[] args)
    {
        // Creating predicate
        Predicate<Integer> lesserthan = i -> (i < 18);

        // Calling Predicate method
        System.out.println(lesserthan.test(10));

      //  illustrate Predicate Chaining

        Predicate<Integer> greaterThanTen = (i) -> i > 10;

        // Creating predicate
        Predicate<Integer> lowerThanTwenty = (i) -> i < 20;
        boolean result = greaterThanTen.and(lowerThanTwenty).test(15);
        System.out.println(result);

        // Calling Predicate method
        boolean result2 = greaterThanTen.and(lowerThanTwenty).negate().test(15);
        System.out.println(result2);

        predicate_and();
        predicate_or();
        predicate_negate();
        pred(10, (i) -> i > 7);

    }
    public static void predicate_negate()
    {

        String lengthGTThan10 = "Thunderstruck is a 2012 children's "
                + "film starring Kevin Durant";

        boolean outcome = hasLengthOf10.negate().test(lengthGTThan10);
        System.out.println(outcome);
    }

    static void pred(int number, Predicate<Integer> predicate)
    {
        if (predicate.test(number)) {
            System.out.println("Number " + number);
        }
    }


    public static Predicate<String> hasLengthOf10 = new Predicate<String>() {
        @Override
        public boolean test(String t)
        {
            return t.length() > 10;
        }
    };

    public static void predicate_and()
    {
        Predicate<String> nonNullPredicate = Objects::nonNull;

        String nullString = null;

        boolean outcome = nonNullPredicate.and(hasLengthOf10).test(nullString);
        System.out.println(outcome);

        String lengthGTThan10 = "Welcome to the machine";
        boolean outcome2 = nonNullPredicate.and(hasLengthOf10).
                test(lengthGTThan10);
        System.out.println(outcome2);
    }


    public static void predicate_or()
    {

        Predicate<String> containsLetterA = p -> p.contains("A");
        String containsA = "And";
        boolean outcome = hasLengthOf10.or(containsLetterA).test(containsA);
        System.out.println(outcome);
    }


}
