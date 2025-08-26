import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadAndWrite {
    public static void writeDataToFile(String path, List<Student> students) {
        try {
            FileOutputStream file = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(students);
            out.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readDataFromFile(String path) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            List<Student> students = (List<Student>) in.readObject();
            for (Student student : students) {
                System.out.println(student);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

        public static void main (String[]args){
            List<Student> students = new ArrayList<>();
            students.add(new Student(1, "Nguyen Minh Duc", "Ha Noi"));
            students.add(new Student(2, "Nguyen Minh Quan", "Ha Noi"));
            students.add(new Student(3, "Nguyen Minh Anh", "Da Nang"));
            students.add(new Student(4, "Nguyen Minh Thao", "Ha Noi"));
            students.add(new Student(5, "Nguyen Minh Ha", "Ha Noi"));
            students.add(new Student(6, "Nguyen Minh Tien", "Ha Noi"));
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter source file");
            String path = scanner.nextLine();
            writeDataToFile(path, students);
            System.out.println("Write data to file successfully");
            System.out.println("Enter source file");
            path = scanner.nextLine();
            readDataFromFile(path);

        }
}
