package malov.serg.reflections_and_annotations.task3;

/**
 * Created by Admin on 05.03.2017.
 */
public class Main {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, InstantiationException {

        Test test = new Test();
        test.setCount(8);
        test.setDescribe("...describe...");

        Serializer.serialize(test);
        //System.out.println("Serializer = " + res);

        test = Serializer.deserialize(Serializer.path, Test.class);
        System.out.println("Deserializer = " + test.getCount() + ", " +  test.getDescribe() + ", " +     test.getDescribe2());

    }
}
