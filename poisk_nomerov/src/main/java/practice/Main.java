package practice;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> list = CoolNumbers.generateCoolNumbers();
        String target = list.get(list.size() - 1);

        long startTime = System.nanoTime();
        boolean result = CoolNumbers.bruteForceSearchInList(list, target);
        long elapsedTime = calcElapsedTime(startTime);
        printResult("Поиск перебором:", result, elapsedTime);

        Collections.sort(list);
        startTime = System.nanoTime();
        result = CoolNumbers.binarySearchInList(list, target);
        elapsedTime = calcElapsedTime(startTime);
        printResult("Бинарный поиск:", result, elapsedTime);

        HashSet<String> hashSet = new HashSet<>(list);
        startTime = System.nanoTime();
        result = CoolNumbers.searchInHashSet(hashSet, target);
        elapsedTime = calcElapsedTime(startTime);
        printResult("Поиск в HashSet:", result, elapsedTime);

        TreeSet<String> treeSet = new TreeSet<>(list);
        startTime = System.nanoTime();
        result = CoolNumbers.searchInTreeSet(treeSet, target);
        elapsedTime = calcElapsedTime(startTime);
        printResult("Поиск в TreeSet:", result, elapsedTime);
    }

    public static long calcElapsedTime(long startTime) {
        return System.nanoTime() - startTime;
    }

    public static void printResult(String scenario, boolean result, long elapsedTime) {
        StringBuilder sb = new StringBuilder(scenario);
        if (result) {
            sb.append(" номер найден, поиск занял ")
                    .append(elapsedTime)
                    .append(" нс");
        }
        System.out.println(sb);
    }
}
