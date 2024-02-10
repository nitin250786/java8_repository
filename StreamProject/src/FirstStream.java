import java.util.*;
import java.util.stream.Collectors;

public class FirstStream {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8);
        List<Integer> filterList = intList.stream().filter(i->i%2==0).limit(3).collect(Collectors.toList());
        filterList.forEach(l->System.out.println(l));
        System.out.println("###################################");

        List<Employee> employeesList = new ArrayList<>();

        employeesList.add(new Employee(101, "Nitin","Sharma", "Manager", "Male", 25_00_000));
        employeesList.add(new Employee(102, "Vinod","Chouhan", "Software Engineer", "Female", 15_00_000));
        employeesList.add(new Employee(103, "Shine","Sahni", "Lead Engineer", "Female", 20_00_000));
        employeesList.add(new Employee(104, "Nike","Nite", "Manager", "Female", 25_00_000));
        employeesList.add(new Employee(105, "Slagan","Gorden", "Software Engineer", "Male", 15_00_000));
        employeesList.add(new Employee(106, "Murekan","Morya", "Software Engineer", "Male", 15_00_000));
        employeesList.add(new Employee(107, "Gagy","Verma", "Software Engineer", "Male", 15_00_000));

        employeesList.sort(
                Comparator.comparing(Employee::getFirstName)
                        .thenComparing(Employee::getLastName)
        );

        employeesList.forEach(l->System.out.println(l));

        // group by - multiple fields
        // Grouping by designation and Gender two properties and need to get the count.

       Map<String, Map<String, Long>> multipleFieldsMap = employeesList.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDesignation,
                                Collectors.groupingBy(Employee::getGender,
                                        Collectors.counting())));


        Map<String, Long> multipleFieldsMap1 = employeesList.stream()
                .collect(
                                Collectors.groupingBy(Employee::getGender,
                                        Collectors.counting()));

        // printing the count based on the designation and gender.
        System.out.println("Group by on multiple properties" + multipleFieldsMap);
        System.out.println("Group by on single properties" + multipleFieldsMap1);
       // employeesList.stream().filter(el->el.getFirstName().length()

        Map<String,Integer> result1 = employeesList.stream().collect(
                Collectors.toMap(Employee::getFirstName,el->el.getFirstName().length()));
        System.out.println("Group by on result1 properties" + result1);

        List<Integer> result2 = employeesList.stream().map(el->el.getFirstName().length()).collect(Collectors.toList());
        System.out.println("Group by on result2 properties" + result2);

        Map<String, String> map = new HashMap<>();
        map.put("employeeOne", "30");
        map.put("employeeTwo", "40");
        map.put("employeeThree", "60");
        List<String> mapList=map.keySet().stream().collect(Collectors.toList());
        //System.out.println("map list " + mapList);
        mapList.forEach(li->System.out.println(li));
        // find average salary of Employee
        OptionalDouble averageSalary = employeesList.stream().mapToLong(Employee::getSalary).average();
        System.out.println("Average Salary " + averageSalary);
    }
}
