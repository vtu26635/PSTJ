package tasks;

import java.util.*;

class Child {   // NOT public
    int id;
    String name;
    double cgpa;

    Child(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    double getCgpa() {
        return cgpa;
    }
}

public class Solution3{

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<Child> children = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int id = in.nextInt();
            String name = in.next();
            double cgpa = in.nextDouble();

            children.add(new Child(id, name, cgpa));
        }

        Collections.sort(children, (a, b) -> {
            if (Double.compare(b.getCgpa(), a.getCgpa()) != 0)
                return Double.compare(b.getCgpa(), a.getCgpa());

            if (!a.getName().equals(b.getName()))
                return a.getName().compareTo(b.getName());

            return a.getId() - b.getId();
        });

        for (Child c : children) {
            System.out.println(c.getName());
        }

        in.close();
    }
}

