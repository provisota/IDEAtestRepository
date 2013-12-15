package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test
{
    public static void main(String[] args) throws IOException
    {
        int x = 5;
        x = ++x + ++x;
        System.out.println(x);
    }
}