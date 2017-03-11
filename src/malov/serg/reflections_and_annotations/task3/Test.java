package malov.serg.reflections_and_annotations.task3;

/**
 * Created by Admin on 05.03.2017.
 */
public class Test {

    @Save
    public int count;
    @Save
    private String describe;
    public String describe2;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getDescribe2() {
        return describe2;
    }

    public void setDescribe2(String describe2) {
        this.describe2 = describe2;
    }



}
