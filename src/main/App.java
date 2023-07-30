package $org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       var mi = new MyInteger(42);
       MyInteger mi2 = m1;
       m2 = 1;
       System.out.printf("m1.val=%d", mi.val);
    }

    private static void extracted() {
        Integer v1 = 20;
        Integer v2 = v1;
        v2 = 4;
        v1;
        System.out.println(v1);
    }
}

public class MyInteger {
    public int val;
    public MyInteger(int v) {
        this.val= v;
    }
}
