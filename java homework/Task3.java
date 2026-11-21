import java.util.Arrays;
import java.util.stream.Collectors;

public class Task3 {
    public static String extractAndSortNumbers(String[] array) {
        return Arrays.stream(array)
                .flatMap(str -> Arrays.stream(str.split(",\\s*")))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        String[] input = {"1, 2, 0", "4, 5"};
        System.out.println(extractAndSortNumbers(input)); 
        // Вивід: 0, 1, 2, 4, 5
    }
}