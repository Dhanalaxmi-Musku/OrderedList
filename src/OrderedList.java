import java.io.*;
import java.util.Scanner;

public class OrderedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        String fileName = "numbers.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] numbers = line.split("\\s+");
                for (String num : numbers) {
                    list.add(Integer.parseInt(num));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        System.out.println("Current List: " + list);
        System.out.print("Enter a number to search: ");
        int number = scanner.nextInt();

        if (list.search(number)) {
            list.delete(number);
            System.out.println("Number found and removed from the list.");
        } else {
            list.add(number);
            System.out.println("Number not found and added to the list.");
        }

        System.out.println("Updated List: " + list);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            Node<Integer> current = list.head;
            while (current != null) {
                writer.write(current.data + " ");
                current = current.next;
            }
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }
}

