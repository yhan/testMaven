import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;


public class TestLambda {
    @Test
    public void runSimple() {
        Function<Integer, Integer> increment = (Integer x) -> x + 1;
        var rst = increment.apply(42);
        Assertions.assertEquals(43, rst);
    }

    @Test
    public void compose() {
        Function<Integer, Integer> increment = (Integer x) -> x + 1;
        Function<Integer, Integer> square = (Integer x) -> x * x;
        Function<Integer, Integer> incrementThenSquare = square.compose(increment);
        var rst = incrementThenSquare.apply(42);
        Assertions.assertEquals(43 * 43, rst);
    }

    @Test
    public void compose_andThen_areEquivalent() {
        Function<Integer, Integer> multiplyBy2 = x -> x * 2;
        Function<Integer, Integer> add3 = x -> x + 3;

        Function<Integer, Integer> combinedFunction = add3.compose(multiplyBy2);

        int result = combinedFunction.apply(5); // result = 5 * 2 + 3 = 13

        var composed = multiplyBy2.andThen(add3);
        int rst2 = composed.apply(5);

        Assertions.assertEquals(result, rst2);
        Assertions.assertEquals(13, rst2);
    }

    @Test
    public void stream() {

        Function<Integer, Integer> multiplyBy2 = x -> x * 2;
        var rst = Stream.of(1, 2, 3, 4)
                .filter(i -> i > 2)
                .map(multiplyBy2)
                .toList();

        Assertions.assertIterableEquals(List.of(3 * 2, 4 * 2), rst);
    }

    @Test
    public void myVar() { // java 10 Type Inference
        var url = "google";
        Assertions.assertEquals(6, url.length());
    }

    // record java 16
    // immutable data class
    @Test
    public void hash() {
        var hash = Objects.hash("hello", 42, false);
        var hash2 = Objects.hash(false, 42, "hello");
        Assertions.assertNotEquals(hash, hash2);
    }

    @Test
    public void TestClass() {
        // non-final field can be changed
        var hello = new ProductClass("hello", 10);
        hello.name = "world";

        // record field can't be changed
    }

//    record Product(String name, double price) {
//    }

    class ProductClass {
        private String name;

        public ProductClass(String name, double price) {
            this.name = name;

        }
    }

}
;