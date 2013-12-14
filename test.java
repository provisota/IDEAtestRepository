package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test
{
    public static void main(String[] args) throws IOException
    {
        int n = 1;
        for(int i = 1; i < 11; i++)
        {
            n = n * i;
        }
        System.out.println(n);
    }
}