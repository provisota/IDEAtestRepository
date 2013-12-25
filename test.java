package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test
{
    int x;
    static int y;
    public static void main(String[] args) throws IOException, CloneNotSupportedException
    {

        x = 10;
        y = 15;
        B b = new B();
        System.out.println(b.zero);
    }

    private static class Zero
    {
        static int zero;
        static
        {
            System.out.println(zero);
        }
        private Zero()
        {
            System.out.println("Class Zero Constructor");
            zero = 5;
            System.out.println(zero);
        }
    }

    private static class A extends Zero
    {
        private A()
        {
            System.out.println("Class A Constructor");
            System.out.println(zero);
            zero = 10;
        }
    }

    public static class B extends A
    {
        private B()
        {
            System.out.println("Class B Constructor");
        }
    }
}