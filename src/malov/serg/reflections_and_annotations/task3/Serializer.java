package malov.serg.reflections_and_annotations.task3;

import java.io.FileWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.InvalidParameterException;

/**
 * Created by Admin on 05.03.2017.
 */
public class Serializer {
    public static String path = "F:\\serializer.txt";

    public static void serialize(Object a) {

        StringBuilder stringBuilder = new StringBuilder();
        try(FileWriter fileWriter = new FileWriter(path)) {
            Class<?> cls = a.getClass();


            Field[] fields = cls.getDeclaredFields();
            for (Field f : fields) {
                if (!f.isAnnotationPresent(Save.class)) {
                    continue;
                }
                if (Modifier.isPrivate(f.getModifiers())) {
                    f.setAccessible(true);
                }

                stringBuilder.append(f.getName() + "=");
                fileWriter.write(f.getName() + "=");

                if (f.getType() == int.class) {
                    stringBuilder.append(f.getInt(a));
                    fileWriter.write(f.getInt(a));
                }
                if (f.getType() == String.class) {
                    stringBuilder.append((String) f.get(a));
                    fileWriter.write((String) f.get(a));
                }
                if (f.getType() == long.class) {
                    stringBuilder.append(f.getLong(a));
                    fileWriter.write((int) f.getLong(a));
                }
                stringBuilder.append(";");
                fileWriter.write(";");

            }
            fileWriter.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
        //return stringBuilder.toString();
    }


    public static <T> T deserialize(String a, Class<T> cls) throws IllegalAccessException, InstantiationException, NoSuchFieldException {

        T res = (T) cls.newInstance();
        String[] pairs = a.split(";");

        for (String p : pairs) {
            String[] s = p.split("=");
            if (s.length != 2) {
                throw new InvalidParameterException(a);
            }

            String name = s[0];
            String value = s[1];
            Field f = cls.getDeclaredField(name);
            if (Modifier.isPrivate(f.getModifiers())) {
                f.setAccessible(true);
            }

            if (f.isAnnotationPresent(Save.class)) {
                if (f.getType() == int.class) {
                    f.setInt(res, Integer.parseInt(value));
                } else if (f.getType() == String.class) {
                    f.set(res, value);
                } else if (f.getType() == long.class) {
                    f.setLong(res, Long.parseLong(value));
                }
            }
        }
        return res;
    }
}
