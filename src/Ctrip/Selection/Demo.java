package Ctrip.Selection;

/**
 * Created by tzy on 2017/10/7.
 */
public class Demo {
    public static void main(String[] args) {
        Base obj=new Sub();
        obj.Func();
    }
    static class Base{
        public Base() {
            Func();
        }
        public void Func(){
            System.out.println("Base.Func");
        }
    }
    static class Sub extends Base{
        public Sub() {
            Func();
        }
        @Override
        public void Func() {
            System.out.println("Sub.Func");
        }
    }
}
