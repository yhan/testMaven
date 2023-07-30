import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.zip.Checksum;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashSetOrderingTests {
    @Test
    public void Ordering() {
        HashSet<Integer> set = new HashSet<>();
        set.add(10);
        set.add(1);
        set.add(22);
        set.add(5);
        for (var val : set) {
            System.out.println(val);
        }

        ArrayList<Integer> list = new ArrayList<>(set);
        int cnt = 0;
        for (var val : list) {
            if (cnt == 0)
                System.out.println("print list");
            System.out.println(val);
            cnt++;
        }
    }

    @Test
    public void Retain() {
        ArrayList<Integer> l1 = new ArrayList<>(IntStream.rangeClosed(1, 100)
                .boxed()
                .toList());
        List<Integer> l2 = new ArrayList<>(IntStream.rangeClosed(2, 4)
                .boxed()
                .toList());

        boolean changed = l1.retainAll(l2);
        Assertions.assertTrue(changed);
        for (var i : l1) System.out.println(i);
        assertEquals(new ArrayList<>(Arrays.asList(2, 3, 4)), l1);
    }

    @Test
    public void CompareInt() {
        Integer a = -129;
        Integer b = -129;
        Assertions.assertSame(a, b, "a and b do not point to the same memory"); // java cache -128 to 127 Integer as const
        assertEquals(a, b);
    }

    @Test
    public void PrintCollection(){
        Collection<Integer> collection = new ArrayList<>();

        List<Integer> list = IntStream.rangeClosed(1, 10)
                .boxed()
                .toList();
        Collections.addAll(collection, list.toArray(new Integer[0]));

        Integer[] arr = new Integer[collection.size()];
        var arr2 = collection.toArray(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
        Assertions.assertSame(arr, arr2);
    }
    @Test
    public void ToUpper(){
        var l = new ArrayList<String>();
        Collections.addAll(l, "a", "b", "c");
        var upper = l.stream().map(String::toUpperCase)
                .toList();
        System.out.println(upper);
    }

    @Test
    public void EachPrint(){
        String[] arr = buildStringArray(3);

        System.out.println(arr);
    }

    private static String[] buildStringArray(int len) {
        String[] arr = new String[len];
        for (int i =0; i<arr.length; i++)
        {
            arr[i] = String.valueOf(i);
        }
        return arr;
    }

    //    It's important to note that converting an array to a collection does not create a
//    separate copy of the elements. Changes to the array or the collection will be
//    reflected in the other. However, converting a collection to an array creates a new array object.
    @Test
    public void ArrayToCollection(){
        String[] arr = {"a", "b", "c"};
        var list = Arrays.asList(arr);

        //modify array
        arr[0] = "hello";

        // collection is impacted
        assertEquals(arr[0], list.get(0));
        System.out.println(list);
    }

    @Test
    public void CollectionToArray(){
        var arrList = new ArrayList<String>();
        String[] elements = {"a", "b", "c"};
        Collections.addAll(arrList, elements);

        //convert to array
        String[] arr = arrList.toArray(new String[3]);  // String[] array = col.toArray(String[]::new); // OK

        // modify collection
        arrList.set(0, "hello");

        // array is not changed
        System.out.println(arrList);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(elements));
        assertEquals("a", arr[0]);
    }

    @Test
    public void ToArray(){
        // build array list
        var arrList = new ArrayList<String>();
        String[] elements = {"a", "b", "c"};
        Collections.addAll(arrList, "a", "b", "c");

        //to array
        String[] arr = new String[3];
        String[] builtArr = arrList.toArray(arr);
        assertEquals(Arrays.asList(arr), Arrays.stream(elements).toList());
        assertEquals(Arrays.asList(arr), Arrays.stream(builtArr).toList());
    }

    @Test
    public void Complexity(){
        var arrList=new ArrayList<String>();
        Collections.addAll(arrList, "a", "b", "c");
        int aIndex = arrList.lastIndexOf("a");
        assertEquals(0, aIndex);

        double result =0;
        assertEquals(123.9, result, 0.0001);
    }

    @Test
    public void switchWithoutBreak(){
        var color=  "red";
        switch (color){
            case "red":
                System.out.println("is red");
                break;
            case "green":
                System.out.println("is green");
                break;
            default:
                System.out.println("is default");
                break;
        }
    }
}
