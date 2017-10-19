package JinRiTouTiao.QiuZhao2017.Rooms;

import java.util.Scanner;

/**
 * Created by tzy on 2017/10/18.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in );
        int n = in.nextInt();
        int x = in.nextInt();
        long[] rooms = new long[n];
        long min = in.nextInt();
        rooms[0] = min;
        for(int i = 1; i < n; i++) {
            rooms[i] = in.nextInt();
            min = min < rooms[i] ? min : rooms[i];
        }
        in.close();
        long sum = 0;
        long dis = min - 1;
        if(dis > 0){
            for(int i = 0; i < n; i++){
                sum += dis;
                rooms[i] -= dis;
            }
        }
        x = (x - 1) % n;
        while(rooms[x] > 0) {
            rooms[x]--;
            sum++;
            x = (x - 1 + n) % n;
        }
        rooms[x] = sum;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++) {
            sb.append(String.valueOf(rooms[i]));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
