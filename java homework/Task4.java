import java.util.stream.Stream;

public class Task4 {
    public static Stream<Long> linearCongruentialGenerator(long seed, long a, long c, long m) {
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }

    public static void main(String[] args) {
        long a = 25214903917L;
        long c = 11L;
        long m = 1L << 48; // 2^48
        long seed = 12345L;

        // Обмежуємо нескінченний стрім через limit(10) для демонстрації
        linearCongruentialGenerator(seed, a, c, m)
                .limit(10)
                .forEach(System.out::println);
    }
}