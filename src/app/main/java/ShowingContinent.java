package app.main.java;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class ShowingContinent {
    public static void sortByNCDisplayContinent(List<Row> list, boolean flag, int limit) {
        if (flag) {
            list.sort(Comparator.comparingDouble(Row::get_new_cases));
        } else
            list.sort((o1, o2) -> Double.compare(o2.get_new_cases(), o1.get_new_cases()));
        HashMap<String, Double> map = new HashMap<>();
        list.forEach((row)->{
            Double value = map.get(row.get_continent());
            if (value != null) {
                double newCases = value + row.get_new_cases();
                map.put(row.get_iso_code(), newCases);
            } else
                map.put(row.get_iso_code(), row.get_new_cases());
        });
        getMap(flag, limit, map);
    }

    public static void sortByNCSDisplayContinent(List<Row> list, boolean flag, int limit) {
        if (flag) {
            list.sort(Comparator.comparingDouble(Row::get_new_cases_smoothed));
        } else
            list.sort((o1, o2) -> Double.compare(o2.get_new_cases_smoothed(), o1.get_new_cases_smoothed()));
        HashMap<String, Double> map = new HashMap<>();
        list.forEach((row)->{
            Double value = map.get(row.get_continent());
            if (value != null) {
                double newCases = value + row.get_new_cases_smoothed();
                map.put(row.get_iso_code(), newCases);
            } else
                map.put(row.get_iso_code(), row.get_new_cases_smoothed());
        });
        getMap(flag, limit, map);
    }

    public static void sortByNDDisplayContinent(List<Row> list, boolean flag, int limit) {
        if (flag) {
            list.sort(Comparator.comparingDouble(Row::get_new_deaths));
        } else
            list.sort((o1, o2) -> Double.compare(o2.get_new_deaths(), o1.get_new_deaths()));
        HashMap<String, Double> map = new HashMap<>();

        list.forEach((row)->{
            Double value = map.get(row.get_continent());
            if (value != null) {
                double newCases = value + row.get_new_deaths();
                map.put(row.get_iso_code(), newCases);
            } else
                map.put(row.get_iso_code(), row.get_new_deaths());
        });
        getMap(flag, limit, map);
    }

    public static void sortByNDSDisplayContinent(List<Row> list, boolean flag, int limit) {
        if (flag) {
            list.sort(Comparator.comparingDouble(Row::get_new_death_smoothed));
        } else
            list.sort((o1, o2) -> Double.compare(o2.get_new_death_smoothed(), o1.get_new_death_smoothed()));
        HashMap<String, Double> map = new HashMap<>();

        list.forEach((row)->{
            Double value = map.get(row.get_continent());
            if (value != null) {
                double newCases = value + row.get_new_death_smoothed();
                map.put(row.get_iso_code(), newCases);
            } else
                map.put(row.get_iso_code(), row.get_new_death_smoothed());
        });
        getMap(flag, limit, map);
    }

    public static void sortByNTDisplayContinent(List<Row> list, boolean flag, int limit) {
        if (flag) {
            list.sort(Comparator.comparingDouble(Row::get_new_tests));
        } else
            list.sort((o1, o2) -> Double.compare(o2.get_new_tests(), o1.get_new_tests()));
        HashMap<String, Double> map = new HashMap<>();
        list.forEach((row)->{Double value = map.get(row.get_continent());
            if (value != null) {
                double newCases = value + row.get_new_tests();
                map.put(row.get_iso_code(), newCases);
            } else
                map.put(row.get_iso_code(), row.get_new_tests());

        });
        getMap(flag, limit, map);
    }

    private static void getMap(boolean flag, int limit, HashMap<String, Double> map) {
        HashMap<String, Double> sorted;

        AtomicInteger counter = new AtomicInteger();
        HashMap<String, Double> tobeSorted = new HashMap<>();
        map.forEach((key, value) -> {
            if (counter.get() < limit)
                tobeSorted.put(key, value);
            counter.getAndIncrement();
        });

        sorted = sortMap(flag, tobeSorted);
        printMap(sorted);
    }

    public static void printMap(HashMap<String, Double> sorted) {
        sorted.forEach((key, value) -> {
            System.out.println(key + " " + value);
        });
    }

    public static HashMap<String, Double> sortMap(boolean flag, HashMap<String, Double> tobeSorted) {
        HashMap<String, Double> sorted;
        if (flag) {
            sorted = tobeSorted.entrySet().stream()
                    .sorted(comparingByValue())
                    .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (e1, e2) -> e2, LinkedHashMap::new));
        } else {
            sorted = tobeSorted.entrySet()
                    .stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .collect(toMap(Map.Entry::getKey,
                            Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        }
        return sorted;
    }
}
