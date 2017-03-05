package malov.serg.reflections_and_annotations.task1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {


        Tester tester = new Tester();
        Class<?> cls = tester.getClass();

        Method[] methods = cls.getMethods();
        for (Method m : methods)
        {
            if (m.isAnnotationPresent(Test.class))
            {
                Test test = m.getAnnotation(Test.class);
                try {
                    m.invoke(tester, test.a(), test.b());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
	// write your code here
    }
}
