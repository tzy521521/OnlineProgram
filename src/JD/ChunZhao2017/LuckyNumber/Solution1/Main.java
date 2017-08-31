package JD.ChunZhao2017.LuckyNumber.Solution1;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by tzy on 2017/8/31.
 */
public class Main {
    private static int f(int i) {
        int ans = 0;
        while (i > 0) {
            ans += i % 10;
            i /= 10;
        }
        return ans;
    }

    private static int g(int i) {
        int ans = 0;
        while (i > 0) {
            ans += i & 1;
            i >>= 1;
        }
        return ans;
    }

    private static TreeMap<Integer, Integer> cache = new TreeMap<>();
    static {
        int cnt = 0;
        for (int i = 1; i <= 100000; i++) {
            if (f(i) == g(i)) {
                cache.put(i, ++cnt);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(cache.floorEntry(scanner.nextInt()).getValue());
        }
    }
}
