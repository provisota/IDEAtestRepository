package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test
{

    public static void main(String[] args) throws IOException, CloneNotSupportedException
    {
        boolean equalsOrNot;
        Date startDate;
        Date endDate;

        A testA = new A();
        B testB = new B();

        List<A> aList = new ArrayList<>();
        List<B> bList = new ArrayList<>();

        for (int i = 0; i < 1000000; i++)
        {
            aList.add(new A());
        }
        for (int i = 0; i < 1000000; i++)
        {
            bList.add(new B());
        }

        startDate = new Date();
        for (A a : aList)
            equalsOrNot = a.equals(testA);
        endDate = new Date();
        System.out.println("time A (with instanceof) = " + (endDate.getTime() - startDate.getTime()));

        startDate = new Date();
        for (B b : bList)
            equalsOrNot = b.equals(testB);
        endDate = new Date();
        System.out.println("time B (without instanceof) = " + (endDate.getTime() - startDate.getTime()));
    }

    private static class A
    {
        int x = 17;

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (!(o instanceof A)) return false;

            A a = (A) o;

            if (x != a.x) return false;

            return true;
        }

        @Override
        public int hashCode()
        {
            return x;
        }
    }

    public static class B
    {
        int x = 31;

        @Override
        public boolean equals(Object o)
        {
            if (o == null) return false;
            if (this == o) return true;
            if (o.getClass() != this.getClass()) return false;

            B b = (B) o;

            if (x != b.x) return false;

            return true;
        }

        @Override
        public int hashCode()
        {
            return x;
        }
    }
}