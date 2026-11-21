import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    public static List<String> sortUpperCaseDesc(List<String> items) {
        return items.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> names = List.of("John", "Ivan", "Mary", "Peter", "Anna");
        System.out.println(sortUpperCaseDesc(names)); 
        // Вивід: [PETER, MARY, JOHN, IVAN, ANNA]
    }
}