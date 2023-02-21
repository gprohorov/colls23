package edu.pro;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        LocalDateTime start = LocalDateTime.now();
        String content = new String(Files.readAllBytes(Paths.get("/home/george/Desktop/harry.txt")));
        Map<String, Long> sortedMap = new LinkedHashMap<>();
        Arrays.stream(content.replaceAll("[^A-Za-z ]", " ").toLowerCase(Locale.ROOT).split(" +"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(entry -> sortedMap.put(entry.getKey(), entry.getValue()));
    sortedMap.entrySet().stream().limit(10).forEach(System.out::println);
    LocalDateTime finish = LocalDateTime.now();
    System.out.println(ChronoUnit.MILLIS.between(start, finish));
    }
}

// 10 last words in alphabetic order - 5 points
// 10 most used words    - 3 points
// every word frequency  - 2
