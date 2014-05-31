package test.enumTest;

import java.text.ParseException;
import java.util.Arrays;

/**
 * @author Alterovych Ilya
 */
public class Test {

    public static void main(String[] args) throws ParseException {

        TaskAttemptType[] types = TaskAttemptType.values();

        System.out.println(Arrays.toString(types));
        System.out.println(TaskAttemptType.valueOf("ATT1").name());
        System.out.println();

        for (TaskAttemptType type : types){
            System.out.println(type.ordinal());
            System.out.println(type.name());
            System.out.println(type.toString());
            System.out.println(type.getAttName());
            System.out.println(type.getSecondName() + " " + type.toString());
            System.out.println();
        }
    }
}