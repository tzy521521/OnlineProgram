package MeiTuan.Selection;

/**
 * Created by tzy on 2017/10/9.
 */
public class MyDouble {
    private int  value = 1;
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MyDouble aMyDouble = (MyDouble)o;
        return value == aMyDouble.getValue();
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
