package malov.serg.reflections_and_annotations.task1;

/**
 * Created by Admin on 05.03.2017.
 */
public class Tester {
    @Test(a = 14, b = 10)
    public void test(int a, int b){
        int c = a + b;
        System.out.println(c);
    }

}
