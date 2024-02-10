
class Exception1 extends Exception {
}
class Exception2 extends RuntimeException {
}
public class TestException  {
    public  void  display2(){
        throw new Exception2();
    }
    public  void  display1(){
        //throw new Exception1();
    }
}
