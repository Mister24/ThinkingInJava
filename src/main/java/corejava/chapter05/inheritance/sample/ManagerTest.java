package corejava.chapter05.inheritance.sample;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

public class ManagerTest
{
   public static void main(String[] args)
   {
      // construct a Manager object
      Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
      boss.setBonus(5000);

      Employee[] staff = new Employee[3];

      // fill the staff array with Manager and Employee objects

      staff[0] = boss;
      staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
      staff[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);

      // print out information about all Employee objects
      for (Employee e : staff) {
         System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
      }
   }

   @Test
   public void test() {
      Object object = new Employee("Tommy Tester", 40000, 1990, 3, 15);
      Employee employee = (Employee) object;
      System.out.println(employee.getHireDay());

      Pair pair = new ImmutablePair("Tommy Tester", employee);
      System.out.println(pair.getKey());
      System.out.println(pair.getValue().toString());
      System.out.println(pair.getLeft());
      System.out.println(pair.getRight().toString());

      Employee[] staff = new Employee[3];
      // fill the staff array with Manager and Employee objects
      staff[0] = new Employee("Kobe", 1000000000, 2022, 1,1);
      staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
      staff[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);

   }
}