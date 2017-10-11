package iQIYI.Selection;

/**
 * Created by tzy on 2017/10/7.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("!");
        byte b1=1,b2=2,b3,b6,b8;
        final byte b4=4,b5=6,b7;
        /*

        b3=(b1+b2);
        b6=b4+b5;
        b8=(b1+b4);
        b7=(b2+b5);
         */
        int a1=1,a2=2,a3,a4,a5;
        final int a6=4,a7=5;
        a3=(a1+a2);
        a4=(a1+a6);
        a5=(a6+a7);
        System.out.println(a3);
        System.out.println(a4);
        System.out.println(a5);

        short c1=1,c2=2,c3,c4,c5;
        final short c6=4,c7=5;

//         c3=(c1+c2);
//         c4=(c1+c6);
//         c5=(c6+c7);
//        c1=c1+c2;
        c1+=c2;
        char a='a',b='b',c,d,e;
        final char f='f',g='g';
        //c=a+b;
//        d=a+f;
        e=f+g;
        System.out.println(e);
    }
}
