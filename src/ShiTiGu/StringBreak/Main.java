package ShiTiGu.StringBreak;

/**
 * Created by tzy on 2017/8/31.
 */
public class Main {
    public static void main(String[] args) {
        Change change=new Change();
        String[] dic="hot got dot god dog lot log".split("\\s+");
        System.out.println(change.countChanges(dic,dic.length,"hot","dog"));
    }
}
