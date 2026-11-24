import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Task5 {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();

        Iterator<T> zipIterator = new Iterator<>() {
            private boolean takeFromFirst = true;

            @Override
            public boolean hasNext() {
                return takeFromFirst
                        ? firstIterator.hasNext() && secondIterator.hasNext()
                        : secondIterator.hasNext();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T nextElement = takeFromFirst ? firstIterator.next() : secondIterator.next();
                takeFromFirst = !takeFromFirst;
                return nextElement;
            }
        };

        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(
                zipIterator,
                Spliterator.ORDERED
        );

        return StreamSupport.stream(spliterator, false)
                .onClose(() -> {
                    first.close();
                    second.close();
                });
    }

    public static void main(String[] args) {
        // Перевірка на нескінченних стрімах
        Stream<Integer> infiniteFirst = Stream.iterate(1, i -> i + 1);
        Stream<Integer> infiniteSecond = Stream.iterate(100, i -> i + 1);

        zip(infiniteFirst, infiniteSecond)
                .limit(10)
                .forEach(System.out::println);
        // Вивід: 1, 100, 2, 101, 3, 102, 4, 103, 5, 104
    }
}
