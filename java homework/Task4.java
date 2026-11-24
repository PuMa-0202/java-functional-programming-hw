import java.math.BigInteger;
import java.util.stream.Stream;

public class Task4 {
    public static Stream<Long> linearCongruentialGenerator(long a, long c, long m) {
        return linearCongruentialGenerator(12345L, a, c, m);
    }

    public static Stream<Long> linearCongruentialGenerator(long seed, long a, long c, long m) {
        BigInteger bigA = BigInteger.valueOf(a);
        BigInteger bigC = BigInteger.valueOf(c);
        BigInteger bigM = BigInteger.valueOf(m);

        return Stream.iterate(seed, x -> BigInteger.valueOf(x)
                .multiply(bigA)
                .add(bigC)
                .mod(bigM)
                .longValue());
    }

    public static void main(String[] args) {
        long a = 25214903917L;
        long c = 11L;
        long m = 1L << 48; // 2^48

        linearCongruentialGenerator(a, c, m)
                .limit(10)
                .forEach(System.out::println);
    }
}
