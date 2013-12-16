package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test
{
    public static void main(String[] args) throws IOException
    {
        newClass newClass1 = new newClass();
        newClass1.x++;

        newClass newClass2 = newClass1;
        newClass2.x++;

        System.out.println(newClass1.x);
        System.out.println(newClass2.x);
    }

    private static class newClass
    {
        int x;
    }
}