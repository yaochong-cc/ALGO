package Zuo_26;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Zuo_26_Comparator {
    
    public static class Employee {
        public int company;
        public int age;

        public Employee(int c, int a) {
            company = c;
            age = a;
        }
    }

    public static class EmployeeComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            // //谁年龄小，谁优先级高
            // if(o1.age < o2.age){
            //     return -1;//返回负数，前者优先级高
            // }else if(o1.age > o2.age){
            //     return 1;//返回正数，后者优先级高
            // }else{
            //     return 0;
            // }
            return o1.age - o2.age;//谁年龄小，谁优先级高
        }
    }

    public static void main(String[] args) {
        Employee s1 = new Employee(2, 27);
        Employee s2 = new Employee(1, 60);
        Employee s3 = new Employee(4, 19);
        Employee s4 = new Employee(3, 23);
        Employee s5 = new Employee(1, 35);
        Employee s6 = new Employee(3, 55);

        Employee[] arr = {s1, s2, s3, s4, s5, s6};
        Arrays.sort(arr, new EmployeeComparator());
        for (Employee e : arr) {
            System.out.println(e.company + "," + e.age);
        }
        System.out.println("==========");
        Arrays.sort(arr, (a, b) -> a.age - b.age);//返回负数，前者优先级高，返回正数，后者优先级高
        for(Employee e : arr){
            System.out.println(e.company + "," + e.age);
        }
        
        System.out.println("===========");
        //先按照，谁的公司编号小，谁在前。编号一致，年龄越小，越靠前
        Arrays.sort(arr, (a, b) -> a.company != b.company ? (a.company - b.company) : (a.age - b.age));
        for(Employee e : arr){
            System.out.println(e.company + "," + e.age);
        }

        //使用TreeSet,有序表会去重
        //如果不想去重，就需要增加更多的比较，比如对象的地址
        TreeSet<Employee> treeset = new TreeSet<>(new EmployeeComparator());
        for(Employee e : arr){
            treeset.add(e);
        }
        System.out.println(treeset.size());
        //有序表会去重
        treeset.add(new Employee(2, 27));
        System.out.println("增加一个employee后，遭到去重，个数仍为" + treeset.size());

        System.out.println("=========");

        //防止有序表去重 
        TreeSet<Employee> treeSet2 = new TreeSet<>(
            (a, b) ->
            a.company != b.company
            ? (a.company - b.company)
                :a.age != b.age ? (a.age - b.age)
                    :a.toString().compareTo(b.toString())//最后比较内存地址
        );
        for(Employee e : arr){
            treeSet2.add(e);
        }
        System.out.println(treeSet2.size());
        //不会去重
        treeSet2.add(new Employee(2, 27));
        System.out.println("未去重，个数为" + treeSet2.size());


        //字典序
        String str1 = "abcke";
        String str2 = "ks";

        System.out.println(str1.compareTo(str2));
        System.out.println(str2.compareTo(str1));//后者字典序小，返回10
    }
}
