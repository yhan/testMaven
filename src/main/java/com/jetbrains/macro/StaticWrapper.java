package com.jetbrains.macro;

public class StaticWrapper {
    public static class StaticClass {
        int foo(){return 42;}
    }

    public class NonStatic{
        int bar() {return 42;}
    }
}

//public static class PureStatic{ } // not inner class, static is not allowed

