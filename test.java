package test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.SortedMap;

import java.io.IOException;

class A {
    String name = "A";

    public A(String name) {
        this.name += name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class B extends A {
    String name = "B";

    public B(String name) {
        super(name);
        this.name += name;
    }

//        @Override
//        public String toString() {
//            return name;
//        }
}

public class Example {

    public static void main(String[] args) throws IOException {
        B b1 = new B("_test");
        System.out.println(b1);
    }
}