package malov.serg.reflections_and_annotations.task2;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Admin on 05.03.2017.
 */
@SaveToFile(path = "F:\\1.txt")
public class TextContainer {

    String text = "Hello World!";

    @SaveMethod
    public void save(String path) throws NoSuchFieldException {


        if(path != null) {

                try(FileWriter out = new FileWriter(path, false))
                {
                    //out.write(" ");
                    out.write(text);
                    out.flush();
                }
                catch (IOException e) {
                    throw new RuntimeException(e);
                }

        }
        else{

            System.out.println("path_to_file (no found annotation) == " + path);
        }

    }
}
