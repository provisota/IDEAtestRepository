package test;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат (C:\Temp\html.txt)
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagScanner
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        StringBuilder stringBuilder = new StringBuilder();
        while (fileReader.ready())
        {
            stringBuilder.append(fileReader.readLine());
        }

        String htmlText = stringBuilder.toString();
        String openTag = "\\<" + args[0] + ".*?\\>";
        String closeTag = "\\</" + args[0] + "\\>";
        String allTags = "(\\<" + args[0] + ".*?\\>)|(\\</" + args[0] + "\\>)";

        ArrayList<String> output = new ArrayList<>();
        Stack<Integer> openTagStack = new Stack<>(); //стек с открывающими тегами <openTag>
        Stack<String> tagLine = new Stack<>(); //стек с внутренними тегами (<openTag>...</closeTag>)
        int innerTagCount = -1; //счётчик внутренних тегов

        Pattern tagsPattern = Pattern.compile(allTags);
        Matcher tagsMatcher = tagsPattern.matcher(htmlText);
        while (tagsMatcher.find())
        {
            //если попался открывающий тег
            if (tagsMatcher.group().matches(openTag))
            {
                openTagStack.push(tagsMatcher.start());
                innerTagCount++;
            }

            //если попался закрывающий тег
            if (tagsMatcher.group().matches(closeTag))
            {
                if (innerTagCount == 0)
                {
                    output.add(htmlText.substring(openTagStack.pop(), tagsMatcher.end()));
                    if (!tagLine.empty())
                    {
                        while (!tagLine.empty())
                            output.add(tagLine.pop());
                    }
                    innerTagCount--;
                }
                else
                {
                    tagLine.push(htmlText.substring(openTagStack.pop(), tagsMatcher.end()));
                    innerTagCount--;
                }
            }
        }

        for (String tag : output)
            System.out.println(tag);
    }
}

