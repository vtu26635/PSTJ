package tasks;
import java.util.*;

class Employee {
    int id;
    int importance;
    List<Integer> subordinates;

    Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
}

public class Main1 {

    public static int getImportance(List<Employee> employees, int id) {

        for (Employee e : employees) {
            if (e.id == id) {
                int total = e.importance;

                for (int subId : e.subordinates) {
                    total += getImportance(employees, subId);
                }

                return total;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, 5, Arrays.asList(2, 3)));
        employees.add(new Employee(2, 3, new ArrayList<>()));
        employees.add(new Employee(3, 3, new ArrayList<>()));

        int id = 1;

        System.out.println(getImportance(employees, id)); // Output: 11
    }
}

