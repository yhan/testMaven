import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class Basics {

    public static boolean valueOf(boolean b) {
//        return b ? Boolean.TRUE : Boolean.FALSE;
        return b ? true: false;
    }

    @Test
    public void testEquals(){
        var eq = Objects.equals(Boolean.TRUE, false);
        Assertions.assertFalse(eq);
    }
}
