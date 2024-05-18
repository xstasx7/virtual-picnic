import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordProcessor {

    public static void main(String[] args) {
        String filePath = "input.txt";

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            String content = String.join(" ", lines);
            String[] words = content.split("\\s+");

            // Задача 1: Подсчет количества слов
            int wordCount = countWords(words);
            System.out.println("Количество слов: " + wordCount);

            // Задача 2: Нахождение самого длинного слова
            String longestWord = findLongestWord(words);
            System.out.println("Самое длинное слово: " + longestWord);

            // Задача 3: Вычисление частоты слов
            Map<String, Integer> wordFrequency = calculateWordFrequency(words);
            System.out.println("Частота слов: " + wordFrequency);

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    private static int countWords(String[] words) {
        return words.length;
    }

    private static String findLongestWord(String[] words) {
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    private static Map<String, Integer> calculateWordFrequency(String[] words) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        return wordFrequency;
    }
}

