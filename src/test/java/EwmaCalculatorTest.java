import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Random;

class EwmaCalculatorTest {

    @Test
    void calculate() {
        var calc = new EwmaCalculator(0.8d);
        long now = Instant.now().getEpochSecond();

        for (int i = 99; i >= 0; i--) {
            long time = now - i;
            double val = calc.calculate(this.boundedRandom(1d, 10d), time);
            String message = String.format("time: %s, ewma: %.2f", toDateTime(time), val);
            System.out.println(message);
        }
    }

    public record Tuple<T1, T2>(T1 first, T2 second) {
    }

    private static final Random rand = new Random();
    private double boundedRandom(double low, double up){
        return low + (up-low) * rand.nextDouble();
    }

    private String toDateTime(long unixTimestamp){
        Instant instant = Instant.ofEpochSecond(unixTimestamp);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter);
    }
}