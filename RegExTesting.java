/*
 * Copyright © 2013. Alterovych Illiya
 *
 * http://easy-code.ru/lesson/java-quantifiers-regular-expressions
 * http://ru.wikipedia.org/wiki/Регулярные_выражения
 */

package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTesting
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {
            System.out.print("Enter your regex: ");
            String regEx = reader.readLine();
            if (regEx.isEmpty())
                exit();

            System.out.print("Enter input string to search: ");
            String stringToSearch = reader.readLine();
            if (stringToSearch.isEmpty())
                exit();

            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(stringToSearch);

            boolean found = false;
            while (matcher.find())
            {
                System.out.printf("I found the text" +
                        " \"%s\" starting at " +
                        "index %d and ending at index %d.%n",
                        matcher.group(),
                        matcher.start(),
                        matcher.end());
                found = true;
            }
            if (!found)
            {
                System.out.printf("No match found.%n");
            }
            System.out.println();
        }
    }

    private static void exit()
    {
        System.out.println("exit");
        System.exit(1);
    }
/*    <span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>

    (\<span.*?\>)|(\</span\>)           регекс или тег <span> или тег </span>
    (\<(/?[^\>]+)\>)                    регекс всех тегов
    */
}
