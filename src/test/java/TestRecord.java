import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;

public class TestRecord {
    @Test
    public void newRecord(){
        Flight flight = new Flight.Builder().from("Paris")
                .to("Shanghai")
                .capacity(200)
                .build();
        Assertions.assertEquals("Paris", flight.from());

    }
    @Test
    public void newClass(){
        var p = new Person();
        Assertions.assertNotNull(p);
    }

    @Test
    public void all(){
        String thisTrue = String.valueOf(true);
        System.out.println(thisTrue);
    }
}
