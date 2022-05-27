package corejava.chapter05.reflect;

import corejava.chapter05.inheritance.sample.Employee;
import corejava.chapter05.inheritance.sample.Manager;

public class Test {
    public static void main(String[] args) {
        Object object = new Employee("Tommy Tester", 40000, 1990, 3, 15);
        Employee employee = (Employee) object;

        Class cl = employee.getClass();
        System.out.println(cl.getName() + " " + employee.getName());

        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        Class clazz = boss.getClass();
        System.out.println(clazz.getName() + " " + boss.getName());
    }
}
