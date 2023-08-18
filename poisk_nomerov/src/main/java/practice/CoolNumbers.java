package practice;

import java.util.*;

public class CoolNumbers {

    public static List<String> generateCoolNumbers() {
        String regex = "[А-Я][0-9]{3}[А-Я]{2}[0-9]{2,3}";
        List<String> letters = Arrays.asList("А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х");
        List<Integer> numbers = Arrays.asList(111, 222, 333, 444, 555, 666, 777, 888, 999);

        HashSet<String> carNumbers = new HashSet<>(2_000_000);

        while (carNumbers.size() <= 2_000_001) {
            StringBuilder sb = new StringBuilder();
            int region = (new Random()).ints(1, 199).iterator().nextInt();
            int index = (new Random()).ints(1, 9).iterator().nextInt();

            Collections.shuffle(letters);
            Collections.shuffle(numbers);

            sb.append(letters.get(index))
                    .append(numbers.get(index))
                    .append(letters.get(index + 1))
                    .append(letters.get(index + 2))
                    .append(region);
            if (sb.toString().matches(regex)) {
                carNumbers.add(sb.toString());
            }
        }
        return new ArrayList<>(carNumbers.stream().toList());
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        return list.contains(number);
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        return Collections.binarySearch(sortedList, number) >= 0;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }

}
