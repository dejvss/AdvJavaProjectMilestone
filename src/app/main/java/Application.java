package app.main.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {
        String file = args[1];
        String stat = args[3];
        String limit = args[5];
        String by = args[7];
        String display = args[9];
        List<Row> list = readData(file);
        callMethods(stat, limit, by, display, list);
    }

    private static void callMethods(String stat, String limit, String by, String display, List<Row> list) {
        if (by.equalsIgnoreCase("NC") && display.equalsIgnoreCase("Date"))
            ShowingDate.sortByNCDisplayDate(list, stat.equalsIgnoreCase("min"), Integer.parseInt(limit));
        else if (by.equalsIgnoreCase("NCS") && display.equalsIgnoreCase("Date")) {
            ShowingDate.sortByNCSDisplayDate(list, stat.equalsIgnoreCase("min"), Integer.parseInt(limit));
        } else if (by.equalsIgnoreCase("ND") && display.equalsIgnoreCase("Date")) {
            ShowingDate.sortByNDDisplayDate(list, stat.equalsIgnoreCase("min"), Integer.parseInt(limit));
        } else if (by.equalsIgnoreCase("NDS") && display.equalsIgnoreCase("Date")) {
            ShowingDate.sortByNDSDisplayDate(list, stat.equalsIgnoreCase("min"), Integer.parseInt(limit));
        } else if (by.equalsIgnoreCase("NT") && display.equalsIgnoreCase("Date")) {
            ShowingDate.sortByNTDisplayDate(list, stat.equalsIgnoreCase("min"), Integer.parseInt(limit));
        } else if (by.equalsIgnoreCase("NC") && display.equalsIgnoreCase("Country")) {
            ShowingCountry.sortByNCDisplayCountry(list, stat.equalsIgnoreCase("min"), Integer.parseInt(limit));
        } else if (by.equalsIgnoreCase("NCS") && display.equalsIgnoreCase("Country")) {
            ShowingCountry.sortByNCSDisplayCountry(list, stat.equalsIgnoreCase("min"), Integer.parseInt(limit));
        } else if (by.equalsIgnoreCase("ND") && display.equalsIgnoreCase("Country")) {
            ShowingCountry.sortByNDDisplayCountry(list, stat.equalsIgnoreCase("min"), Integer.parseInt(limit));
        } else if (by.equalsIgnoreCase("NDS") && display.equalsIgnoreCase("Country")) {
            ShowingCountry.sortByNDSDisplayCountry(list, stat.equalsIgnoreCase("min"), Integer.parseInt(limit));
        } else if (by.equalsIgnoreCase("NT") && display.equalsIgnoreCase("Country")) {
            ShowingCountry.sortByNTDisplayCountry(list, stat.equalsIgnoreCase("min"), Integer.parseInt(limit));
        } else if (by.equalsIgnoreCase("NC") && display.equalsIgnoreCase("Continent")) {
            ShowingContinent.sortByNCDisplayContinent(list, stat.equalsIgnoreCase("min"), Integer.parseInt(limit));
        } else if (by.equalsIgnoreCase("NCS") && display.equalsIgnoreCase("Continent")) {
            ShowingContinent.sortByNCSDisplayContinent(list, stat.equalsIgnoreCase("min"), Integer.parseInt(limit));
        } else if (by.equalsIgnoreCase("ND") && display.equalsIgnoreCase("Continent")) {
            ShowingContinent.sortByNDDisplayContinent(list, stat.equalsIgnoreCase("min"), Integer.parseInt(limit));
        } else if (by.equalsIgnoreCase("NDS") && display.equalsIgnoreCase("Continent")) {
            ShowingContinent.sortByNDSDisplayContinent(list, stat.equalsIgnoreCase("min"), Integer.parseInt(limit));
        } else if (by.equalsIgnoreCase("NT") && display.equalsIgnoreCase("Continent")) {
            ShowingContinent.sortByNTDisplayContinent(list, stat.equalsIgnoreCase("min"), Integer.parseInt(limit));
        } else
            System.out.println("Invalid arguments");
    }


    private static List<Row> readData(String path) {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            List<Row> list = new ArrayList<>();

            stream.forEach(l -> {
                Row row = new Row();
                List<String> line = List.of(l.split(","));
                if (!line.get(0).equalsIgnoreCase("iso_code")) {
                    try {
                        row.setIsoCode(line.get(Columns.COLUMN_1));
                        row.setContinent(line.get(Columns.COLUMN_2));
                        row.setLocation(line.get(Columns.COLUMN_3));
                        row.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(line.get(Columns.COLUMN_4)));
                        row.setTotalCases(line.get(Columns.COLUMN_5).isEmpty() ? 0.0 : Double.parseDouble(line.get(Columns.COLUMN_5)));
                        row.setNewCases(line.get(Columns.COLUMN_6).isEmpty() ? 0.0 : Double.parseDouble(line.get(Columns.COLUMN_6)));
                        if (line.size() > 49) {
                            row.setNewCasesSmoothed(line.get(Columns.COLUMN_7).isEmpty() ? 0.0 : Double.parseDouble(line.get(Columns.COLUMN_7)));
                            row.setTotalDeaths(line.get(Columns.COLUMN_8).isEmpty() ? 0.0 : Double.parseDouble(line.get(Columns.COLUMN_8)));
                            row.setNewDeaths(line.get(Columns.COLUMN_9).isEmpty() ? 0.0 : Double.parseDouble(line.get(Columns.COLUMN_9)));
                            row.setNewDeathsSmoothed(line.get(Columns.COLUMN_10).isEmpty() ? 0.0 : Double.parseDouble(line.get(Columns.COLUMN_10)));
                            row.setReproductionRate(line.get(Columns.COLUMN_11).isEmpty() ? 0.0 : Double.parseDouble(line.get(Columns.COLUMN_11)));
                            row.setNewTests(line.get(Columns.COLUMN_12).isEmpty() ? 0.0 : Double.parseDouble(line.get(Columns.COLUMN_12)));
                            row.setTotalTests(line.get(Columns.COLUMN_13).isEmpty() ? 0.0 : Double.parseDouble(line.get(Columns.COLUMN_13)));
                            row.setStringencyIndex(line.get(Columns.COLUMN_14).isEmpty() ? 0.0 : Double.parseDouble(line.get(Columns.COLUMN_14)));
                            row.setPopulation(Double.parseDouble(line.get(Columns.COLUMN_15)));
                            row.setMedianAge(line.get(Columns.COLUMN_16).isEmpty() ? 0.0 : Double.parseDouble(line.get(Columns.COLUMN_16)));

                        }
                        list.add(row);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
            return list;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
