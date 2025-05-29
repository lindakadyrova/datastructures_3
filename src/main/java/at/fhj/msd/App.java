package at.fhj.msd;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class App {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000};

        try (FileWriter mdWriter = new FileWriter("report.md")) {
            mdWriter.write("# Lineare Suche – Laufzeitanalyse\n\n");

            for (int size : sizes) {
                int[] array = generateRandomArray(size);
                int maxValue = size;
                long minTime = Long.MAX_VALUE;
                long maxTime = Long.MIN_VALUE;
                long totalTime = 0;

                for (int x = 1; x <= maxValue; x++) {
                    long start = System.nanoTime();
                    LinearSearch.linearSearch(array, x);
                    long end = System.nanoTime();
                    long duration = end - start;

                    minTime = Math.min(minTime, duration);
                    maxTime = Math.max(maxTime, duration);
                    totalTime += duration;
                }

                double avgTime = totalTime / (double) maxValue;

                String block = String.format(
                    "## Arraygröße: %d\n\n" +
                    "- Minimale Zeit: `%d ns`\n" +
                    "- Maximale Zeit: `%d ns`\n" +
                    "- Durchschnittliche Zeit: `%.2f ns`\n\n" +
                    "---\n\n",
                    size, minTime, maxTime, avgTime
                );

                System.out.print(block);       // Optional: auch in Konsole
                mdWriter.write(block);         // In Markdown-Datei schreiben
            }

            System.out.println("Markdown-Report gespeichert als linear_search_report.md");
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben: " + e.getMessage());
        }
    }

    public static int[] generateRandomArray(int size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
