import java.util.Arrays;
import java.util.stream.Stream;

public class StreamFilterSample {
    public static void main(String[] args)
    {
        // create a stream of strings
        Stream<String> myStream
                = Stream.of("Like", "and", "Share",
                "https://www.geeksforgeeks.org/");

        // only string starting with "http://" will be
        // considered for next API(forEach)
        myStream.filter(x -> x.startsWith("https://"))
                .forEach(System.out::println);

        // create integer array
        Integer[] myArray
                = new Integer[] { 1, 4, 5, 7, 9, 10 };

        // create a stream and filter by
        // even numbers predicate
        Stream.of(myArray)
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);


        String[] myArray1
                = new String[] { "madam", "please", "refer",
                "link",  "on",     "racecar" };

        // filter using a custom method
        Stream.of(myArray1)
                .filter(x -> palindrome(x))
                .forEach(System.out::println);


        // Data source
        // Custom integer inputs
        Integer[] numbers
                = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };

        // Stream
        var streamOfNumbers = Arrays.stream(numbers);

        // Using filter method
        var evenNumbersStream
                = streamOfNumbers
                .filter(number -> number % 2 == 0)
                .count();

        // Print and display
        System.out.println(evenNumbersStream);

    }


    public static void filterByStartsWith()
    {
        // create String array
        String[] myArray
                = new String[] { "stream",   "is",  "a",
                "sequence", "of",  "elements",
                "like",     "list" };

        // create a stream and filter by
        // starting string predicate
        Stream<String> myStream = Stream.of(myArray);
        myStream.filter(x -> x.startsWith("s"))
                .forEach(System.out::println);

        filterByCustomProperties();

    }

    public static void filterByStartsWithVowelsRegex()
    {
        // create string array
        String[] myArray
                = "I am 24 years old and I want to be in Tier I company"
                .split(" ");

        // create a stream on myArray
        Stream<String> myStream = Stream.of(myArray);

        // filter by matching vowels regular expression
        myStream.filter(x -> x.matches("(a|e|i|o|u)\\w*"))
                .forEach(System.out::println);
    }

    // checks if palindrome or not
    public static boolean palindrome(String s)
    {
        if (s.length() <= 1)
            return true;
        else
            return (s.charAt(0) == s.charAt(s.length() - 1))
                    && palindrome(
                    s.substring(1, s.length() - 1));
    }
    public static void filterByCustomProperties()
    {
        // create a string array
        String[] myArray
                = new String[] { "madam", "please", "refer",
                "link",  "on",     "racecar" };

        // filter using a custom method
        Stream.of(myArray)
                .filter(x -> palindrome(x))
                .forEach(System.out::println);
    }
}
