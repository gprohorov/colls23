package edu.pro;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("/home/george/Desktop/harry.txt")));
        content = content.replaceAll("[^A-Za-z ]", " ").toLowerCase(Locale.ROOT);

        String[] words = content.split(" +");
        Arrays.sort(words);

    for (int i = 0; i < 30; i++) {
    //  System.out.println(i + "." + words[i]);
    }

    String distinctsAsString = "";

    for (int i = 0; i < words.length; i++) {
      if (!distinctsAsString.contains(words[i])) {
          distinctsAsString += words[i] + " ";
      }
    }

    System.out.println(distinctsAsString.substring(0, 100));

        String[] distinctsArray = distinctsAsString.split(" ");

        for (int i = 0; i < 10; i++) {
       //       System.out.println(i + "." + distinctsArray[i]);
        }

        int[] frequency = new int[distinctsArray.length];

    for (int i = 0; i < distinctsArray.length; i++) {
         int count = 0;
      for (int j = 0; j < words.length; j++) {
        if (distinctsArray[i].equals(words[j])) {
            count++;
        }
        frequency[i] = count;
      }
    }

    for (int i = 0; i < 100; i++) {
      System.out.println( distinctsArray[i] + " - " + frequency[i]);
    }

   Arrays.sort(frequency);

    for (int i = 0; i < 10; i++) {
      System.out.println(frequency[frequency.length -1 -i]);
    }
    }
}

// 10 last words in alphabetic order - 5 points
// 10 most used words    - 3 points
// every word frequency  - 2
