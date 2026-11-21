import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Task5 {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();

        List<T> result = new ArrayList<>();
        while (firstIterator.hasNext() && secondIterator.hasNext()) {
            result.add(firstIterator.next());
            result.add(secondIterator.next());
        }

        return result.stream();
    }

    public static void main(String[] args) {
        Stream<String> first = Stream.of("A", "B", "C", "D");
        Stream<String> second = Stream.of("1", "2");

        zip(first, second).forEach(System.out::println);
        // Вивід: A, 1, B, 2 (зупиняється, бо в second закінчилися елементи)
    }
}