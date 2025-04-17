package CollectionDemo.ListDemo;

import java.util.TreeSet;

class Employee
{
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class comparatorDemo
{
    public static void main(String[] args) {

        Employee emp1 = new Employee(1 , "Prasad");
        Employee emp2 = new Employee(1 , "Bhalkikar");
        Employee emp3 = new Employee(1 , "Meoq");
        Employee emp4 = new Employee(1 , "Vaishnavi");
        System.out.println(emp1);

        TreeSet<Employee> treeSet = new TreeSet<>();
        treeSet.add(emp1);
        treeSet.add(emp2);
        treeSet.add(emp3);
        treeSet.add(emp4);

        System.out.println(treeSet);


    }
}
