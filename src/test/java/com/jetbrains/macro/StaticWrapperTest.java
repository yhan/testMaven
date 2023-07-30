package com.jetbrains.macro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaticWrapperTest {
    @Test
    public void callStaticClassMethod(){
        var rst = new StaticWrapper.StaticClass().foo();
        Assertions.assertEquals(42, rst);
    }

    @Test
    public void callNonStaticClassMethod(){
        StaticWrapper wrapper = new StaticWrapper();
        StaticWrapper.NonStatic nonStaticInstance = wrapper.new NonStatic();

        int result = nonStaticInstance.bar();
        System.out.println("Result: " + result);

    }

}