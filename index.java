import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileReaderExample {
    public static void main(String[] args) {
        String filePath = "file.txt"; // Путь к файлу
        List<String> lines = new ArrayList<>(); // Список для хранения строк

        // Ввод данных пользователем и запись в файл
        try (Scanner scanner = new Scanner(System.in);
             BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            System.out.println("Введите строки для сохранения в файл (введите пустую строку для завершения):");

            while (true) {
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    break; // Выход, если введена пустая строка
                }
                writer.write(input);
                writer.newLine(); // Переход на новую строку
            }
            System.out.println("Данные успешно записаны в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }

        // Чтение данных из файла и их сортировка
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line); // Добавляем строку в список
            }
            
            // Сортировка строк
            Collections.sort(lines);
            
            // Вывод отсортированных строк на экран
            System.out.println("Отсортированные данные:");
            for (String sortedLine : lines) {
                System.out.println(sortedLine);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
