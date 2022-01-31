package bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (this.employees.size() < capacity) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        for (int i = 0; i < this.employees.size(); i++) {
            if (this.employees.get(i).getName().equals(name)) {
                this.employees.remove(i);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        int max = Integer.MIN_VALUE;
        Employee employee = null;
        for (Employee employee1 : employees) {
            if (employee1.getAge() > max) {
                max = employee1.getAge();
                employee = employee1;
            }
        }
        return employee;
    }

    public Employee getEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public int getCount() {
        return this.employees.size();
    }
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Bakery %s:",this.name)).append(System.lineSeparator());
        for (Employee employee : employees) {
            sb.append(employee).append(System.lineSeparator());
        }
        return sb.toString();
    }

}
