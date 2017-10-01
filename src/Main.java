import java.util.Scanner;

/**
 * Created by tzy on 2017/10/1.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            System.out.println(getNums(n));
        }
    }
    private static int getNums(int n){
        int f[]=new int[n+2];
        if (n<=1)
            return 0;
        else{
            f[0] = 0;
            f[1] = 0;
            f[2] = 1;
            f[3] = 2;
            for (int i = 4; i <=n ; i++) {
                f[i]=(i-1)*(f[i-1]+f[i-2]);
            }
        }
        return f[n];
    }
}
