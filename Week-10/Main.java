package tasks;
import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class Main  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            students.add(new Student(sc.next(), sc.nextInt()));
        }

        int K = sc.nextInt();

        String result = students.stream()
                .sorted(Comparator.comparingInt((Student s) -> s.marks).reversed()
                        .thenComparing(s -> s.name))
                .limit(K)
                .map(s -> s.name)
                .collect(Collectors.joining(" "));

        System.out.println(result);
        sc.close();
    }
}

