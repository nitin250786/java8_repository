@FunctionalInterface
interface CustomFunctionalInterface {
    int calculate(int a, int b);
}
public class FunctionalInterfaceTest {
    public static void main(String[] args) {

        CustomFunctionalInterface addition = (int i,int j)->i+j;
        int add = addition.calculate(1,2);

        CustomFunctionalInterface multiplication = (int i,int j)->i*j;
        int mult = multiplication.calculate(3,4);

        CustomFunctionalInterface substraction = (int i,int j)->i-j;
        int substract = substraction.calculate(10,4);

        CustomFunctionalInterface division = (int i,int j)->i/j;
        int devide = division.calculate(6,2);

        System.out.println("addition is "+add);

        System.out.println("multiplication is "+mult);

        System.out.println("substraction is "+substract);

        System.out.println("division is "+devide);
    }
}
