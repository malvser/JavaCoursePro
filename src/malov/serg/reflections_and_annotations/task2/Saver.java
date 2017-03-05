package malov.serg.reflections_and_annotations.task2;

import java.lang.reflect.Method;

/**
 * Created by Admin on 05.03.2017.
 */
public class Saver {

    boolean save_annotation = false;
    private String path;


    void param_path_Save_to_File (){

        Class<?> cls = TextContainer.class;
            if (cls.isAnnotationPresent(SaveToFile.class))
            {
                SaveToFile test = cls.getAnnotation(SaveToFile.class);
                path = test.path();


            }

    }

    void save_object(){

        save_annotation = false;

        TextContainer textContainer = new TextContainer();
        Class<?> cls = textContainer.getClass();

        Method[] methods = cls.getMethods();
        for (Method method : methods) {

            if(method.isAnnotationPresent(SaveMethod.class))
            {
                save_annotation = true;
            }
        }

        if(save_annotation)
        {
            try {
                textContainer.save(path);
            } catch (NoSuchFieldException e) {
                System.out.println(e.getMessage());
                //e.printStackTrace();
            }
        }

    }
}
