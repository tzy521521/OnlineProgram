package FenHuoTongXin.TypeTring;

import java.util.Scanner;

/**
 * Created by tzy on 2017/9/6.
 * 小明同学刚刚学习打字，现在老师叫他输入一个英文字符串。小明发现，这个英文字符串只由大写和小写的英文字母构成。
 * 小明同学只会使用Caps Lock键来切换大小写输入。最开始，大写锁定处于关闭状态，小明的电脑只能输入小写英文字母。
 * 当大写锁定关闭时，按一下Caps Lock键可以打开大写锁定，之后只能输入大写字母；当大写锁定打开时，按一下Caps Lock键可以关闭大写锁定，
 * 之后只能输入小写字母。现在小明想知道输入这个字符串最少需要按键多少次。
 * 输入（只有一行，一个字符串，字符串中只有大写字母和小写字母，字符串长度不超过100000）aAAbB
 * 输出一行，最少的按键次数。8
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String string=scanner.nextLine();
            System.out.println(countSting(string));
        }
    }
    public static int countSting(String string){
        if (string==null||string.length()<1)
            return 0;
        //大小写变换次数。
        int num=0;
        if (string.charAt(0)>='A'&&string.charAt(0)<='Z')
            num++;
        for (int i = 1; i <string.length() ; i++) {
            if (string.charAt(i)>='A'&&string.charAt(i)<='Z'){
                if (string.charAt(i-1)>='a'&&string.charAt(i-1)<='z')
                    num++;
            }else {
                if (string.charAt(i-1)>='A'&&string.charAt(i-1)<='Z')
                    num++;
            }
        }

        return num+string.length();
    }
}
