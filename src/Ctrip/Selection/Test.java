package Ctrip.Selection;

/**
 * Created by tzy on 2017/10/8.
 */
public class Test {
    public static void main(String[] args) {
        Thread[] ths=new Thread[3];
        for (int i = 0; i <ths.length ; i++) {
            ths[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j <5 ; j++) {
                        System.out.print(j);
                    }
                    System.out.print(" ");
                }
            });
        }
        for (Thread th:ths) {
            th.start();
        }
    }
}
