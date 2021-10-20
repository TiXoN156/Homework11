package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {

// Задача 1
        File file00 = new File("C:\\Users\\tihon\\Git");
        ArrayList<File> listDirectory = new ArrayList<>();
        ArrayList<File> listFiles = new ArrayList<>();
        for (File element : file00.listFiles()) {
            if (element.isDirectory()) {
                listDirectory.add(element);
            } else {
                listFiles.add(element);
            }
        }
        for (int i = 0; i < listDirectory.size(); i++) {
            System.out.println(listDirectory.get(i));
        }
        for (int i = 0; i < listFiles.size(); i++) {
            System.out.println(listFiles.get(i));
        }

// Задача 2
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\4.txt"));
        String string = bufferedReader.readLine();
        int countPunctuation = 0;
        int countSpace = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '.' || string.charAt(i) == ',' || string.charAt(i) == '!' || string.charAt(i) == '?'
                    || string.charAt(i) == ';' || string.charAt(i) == ':' || string.charAt(i) == '-') {
                countPunctuation++;
            }
            if (string.charAt(i) == ' ') {
                countSpace++;
            }
        }
        System.out.println(string);
        System.out.println(String.format("Количество знаков препинания: %s", countPunctuation));
        System.out.println(String.format("Количество слов: %s", countSpace + 1));

// Задача 3
        ArrayList<Integer> allNumbers = new ArrayList<>();
        HashSet<Integer> uniqueNumbers = new HashSet<>();
        Integer sumAllNumbers = 0;
        Integer sumUniqueNumbers = 0;

        BufferedReader bufferedReader2 = new BufferedReader(new FileReader("C:\\5.txt"));
        String string2 = bufferedReader2.readLine();

        Pattern pattern = Pattern.compile("[-]?[0-9]+");
        Matcher matcher = pattern.matcher(string2);
        while (matcher.find()) {
            allNumbers.add(Integer.valueOf(matcher.group()));
            uniqueNumbers.add(Integer.valueOf(matcher.group()));
        }

        for (Integer element : allNumbers) {
            sumAllNumbers += element;
        }
        System.out.println(sumAllNumbers);

        for (Integer element : uniqueNumbers) {
            sumUniqueNumbers += element;
        }
        System.out.println(sumUniqueNumbers);

// Задача 4
        String path0 = "C:\\folder1\\folder2\\folder3\\";
        String path1 = "C:\\folder1\\folder2\\folder3\\11.txt";
        String path2 = "C:\\folder1\\folder2\\folder3\\12.txt";
        String path3 = "C:\\folder1\\folder2\\folder3\\13.txt";
        String path4 = "C:\\folder1\\folder2\\folder3\\14.txt";
        String path5 = "C:\\folder1\\folder2\\folder3\\15.txt";
        String path6 = "C:\\folder1\\folder2\\folder3\\result.txt";
        String path7 = "C:\\folder1\\folder2\\folder3\\files.txt";
        File file0 = new File(path0);
        file0.mkdirs();
        createNewFile(path1);
        createNewFile(path2);
        createNewFile(path3);
        createNewFile(path4);
        createNewFile(path5);
        writeRandomIntToFile(path1);
        writeRandomIntToFile(path2);
        writeRandomIntToFile(path3);
        writeRandomIntToFile(path4);
        writeRandomIntToFile(path5);
        String s1 = readFromFile(path1);
        String s2 = readFromFile(path2);
        String s3 = readFromFile(path3);
        String s4 = readFromFile(path4);
        String s5 = readFromFile(path5);
        createNewFile(path6);
        writeStringToFile(path6, s1 + s2 + s3 + s4 + s5);

        ArrayList<File> listFiles2 = new ArrayList<>();
        for (File element : file0.listFiles()) {
            if (element.isFile()) {
                listFiles2.add(element);
            }
        }
        createNewFile(path7);
        writeStringToFile(path7, listFiles2.toString());
    }

    public static File createNewFile(String path) {
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static void writeRandomIntToFile(String path) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            printWriter.print((int) (Math.random() * 100));
            printWriter.print(' ');
        }
        printWriter.close();
    }

    public static void writeStringToFile(String path, String content) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        printWriter.println(content);
        printWriter.close();
    }

    public static String readFromFile(String path) throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String string = null;
        try {
            string = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }
}
