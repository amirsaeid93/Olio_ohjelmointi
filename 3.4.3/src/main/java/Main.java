import java.io.*;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(1, "John Doe", 20);
        Course course = new Course("CS101", "Introduction to Computer Science", "Dr. Smith");
        Enrollment enrollment = new Enrollment(student, course, "2023-10-01");


        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("enrollments.ser"))) {
            oos.writeObject(enrollment);
            System.out.println("Serialization successful");
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("enrollments.ser"))) {
            Enrollment deserializedEnrollment = (Enrollment) ois.readObject();
            System.out.println("Deserialization successful");
            System.out.println(deserializedEnrollment);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}