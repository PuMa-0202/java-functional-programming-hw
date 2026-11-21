import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task1 {
    public static String getOddIndexedNames(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(index -> index % 2 != 0)
                .mapToObj(index -> index + ". " + names.get(index))
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        List<String> names = List.of("John", "Ivan", "Mary", "Peter", "Anna", "Oleh");
        System.out.println(getOddIndexedNames(names)); 
        // Вивід: 1. Ivan, 3. Peter, 5. Oleh
    }
}