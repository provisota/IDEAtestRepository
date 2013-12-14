/*
 * Copyright (c) 2013. Alterovych Illiya
 */

package test;

import java.io.*;
import java.util.ArrayList;

public class EncryptingAndDecryptingData
{
    public static void main(String[] args)
    {
        String fileName = args[1];
        String fileOutputName = args[2];
        ArrayList<Integer> dataArrayList = new ArrayList<Integer>();
        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;

        try
        {
            inputStream = new BufferedInputStream(new FileInputStream(fileName));
            while (inputStream.available() > 0)
                dataArrayList.add(inputStream.read());
            if (args[0].equals("-e"))
                dataArrayList = encrypt(dataArrayList);
            if (args[0].equals("-d"))
                dataArrayList = decrypt(dataArrayList);

            outputStream = new BufferedOutputStream(new FileOutputStream(fileOutputName));
            for (Integer data : dataArrayList)
                outputStream.write(data);

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (inputStream != null)
                    inputStream.close();
                if (outputStream != null)
                    outputStream.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    private static ArrayList<Integer> encrypt(ArrayList<Integer> dataArrayList)
    {
        ArrayList<Integer> encryptingDataArrayList = new ArrayList<Integer>(dataArrayList.size());
        for (int i = dataArrayList.size()-1; i >= 0; i--)
            encryptingDataArrayList.add(dataArrayList.get(i));

        return encryptingDataArrayList;
    }

    private static ArrayList<Integer> decrypt(ArrayList<Integer> dataArrayList)
    {
        ArrayList<Integer> decryptingDataArrayList = new ArrayList<Integer>(dataArrayList.size());
        for (int i = dataArrayList.size()-1; i >= 0; i--)
            decryptingDataArrayList.add(dataArrayList.get(i));

        return decryptingDataArrayList;
    }
}
