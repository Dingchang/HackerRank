
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Chart chart = new Chart();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n;

        try {
            n = Integer.valueOf(reader.readLine());

            for (int i = 0; i < n; i++) {
                String[] arr = reader.readLine().split(",");

                switch (arr[0]) {
                    case "add":
                        chart.add(arr[1], arr[2], arr[3]);
                        break;
                    case "print":
                        chart.print();
                        break;
                    case "move":
                        chart.move(arr[1], arr[2]);
                        break;
                    case "remove":
                        chart.remove(arr[1]);
                        break;
                    case "count":
                        chart.count(arr[1]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Chart {
    private List<Employee> employees;

    Chart() {
        this.employees = new ArrayList<>();
    }

    private boolean checkExist(String id) {
        for (Employee employee : this.employees) {
            if (employee.getId().equals(id)) {
                return true;
            }
        }

        return false;
    }

    void add(String id, String name, String employerID) {
        if (checkExist(id)) {
            // do nothing
        } else if (checkExist(employerID)) {
            this.employees.add(new Employee(id, name, employerID));
        } else {
            this.employees.add(new Employee(id, name, "-1"));
        }
    }

    private void printRecords(String id, List<String> dejavu, int indent) {
        String space = "";

        for (int i = 0; i < indent; i++) {
            space = space.concat(" ");
        }

        for (Employee employee : this.employees) {
            if (employee.getEmployerID().equals(id) && !dejavu.contains(employee.getId())) {
                System.out.println(space.concat(employee.format()));
                dejavu.add(employee.getId());
                printRecords(employee.getId(), dejavu, indent + 2);
            }
        }
    }

    void print() {
        List<String> dejavu = new ArrayList<>();
        for (Employee employee : this.employees) {
            if (!dejavu.contains(employee.getId())) {
                System.out.println(employee.format());
                dejavu.add(employee.getId());
                printRecords(employee.getId(), dejavu, 2);
            }
        }
    }

    void move(String id, String newEmployerId) {
        if (checkExist(id) && checkExist(newEmployerId)) {
           for (Employee employee : this.employees) {
               if (employee.getId().equals(id)) {
                   employee.setEmployerID(newEmployerId);
               }
           }
        }
    }

    void remove(String id) {
        String newEmployer = "";

        if (checkExist(id)) {
            for (Employee employee : this.employees) {
                if (employee.getId().equals(id)) {
                    newEmployer = employee.getEmployerID();
                    this.employees.remove(employee);
                    break;
                }
            }

            for (Employee employee : this.employees) {
                if (employee.getEmployerID().equals(id)) {
                    employee.setEmployerID(newEmployer);
                }
            }
        }
    }

    void count(String id) {
        int count = 0;

        for (Employee employee : this.employees) {
            if (employee.getId().equals(id)) {
                count += countReports(id);
            }
        }

        System.out.println(count);
    }

    private int countReports(String id) {
        int count = 0;

        for (Employee employee : this.employees) {
            if (employee.getEmployerID().equals(id)) {
                count += 1 + countReports(employee.getId());
            }
        }

        return count;
    }
}

class Employee {
    private String id;
    private String name;
    private String employerID;

    Employee(String id, String name, String employerID) {
        this.id = id;
        this.name = name;
        this.employerID = employerID;
    }

    String getId() {
        return this.id;
    }

    String getEmployerID() {
        return this.employerID;
    }

    void setEmployerID(String employerID) {
        this.employerID = employerID;
    }

    String format() {
        return this.name + " [" + this.id + "]";
    }
}
