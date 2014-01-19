package test;


import java.io.IOException;

public class Test
{
    public static void main(String[] args) throws IOException
    {
        B b1 = new B("_test");
        System.out.println(b1);
    }
}

class A
{
    String name = "A";

    public A(String name)
    {
        this.name += name;
    }

    @Override
    public String toString()
    {
        return name;
    }
}

class B extends A
{
    String name = "B";

    public B(String name)
    {
        super(name);
        this.name += name;
    }

//    @Override
//    public String toString()
//    {
//        return name;
//    }
}
