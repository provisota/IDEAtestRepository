package test;

import java.lang.reflect.Field;

/**
 * @author Alterovych Ilya
 *         Date: 01.03.14
 */
public class ReflectionDemo {

    public static class Test {
        int publicInt = 0;
        String publicString = "public string";
        private int privateInt = 0;
        private final String privateString = "private final";
    }

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        Test test = new Test();
        getFields(test);
        setIntField(test, "privateInt", 1);
        setStringField(test, "privateString", "public final :)");
        getFields(test);
    }

    static void getFields(Object obj) throws IllegalAccessException {
        Class c = obj.getClass();
        Field[] publicFields = c.getDeclaredFields();
        for (Field field : publicFields) {
            Class fieldType = field.getType();
            field.setAccessible(true);
            System.out.println("Имя: " + field.getName());
            System.out.println("Тип: " + fieldType.getName());
            System.out.println("Значение: " + field.get(obj));
            System.out.println();
        }
        System.out.println("---------------------------------------------");
        System.out.println();
    }

    static void setIntField(Object obj, String fieldName, Integer newValue) throws IllegalAccessException, NoSuchFieldException {
        Class c = obj.getClass();
        Field field = c.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, newValue);
    }

    static void setStringField(Object obj, String fieldName, String newValue) throws IllegalAccessException, NoSuchFieldException {
        Class c = obj.getClass();
        Field field = c.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, newValue);
    }
}
