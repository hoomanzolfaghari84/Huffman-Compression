package testGenerator;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Constructor;
import java.util.Optional;
import java.util.Properties;

public class Configs extends Properties {
    private static final String ADDRESS = "src/resources/configs.properties";

    private static Configs instance;


    public static Configs getInstance(){
        if(instance==null){
            instance = new Configs(ADDRESS);
        }
        return instance;
    }

    private Configs(String address){
        try {
            Reader reader = new FileReader(address);
            this.load(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getTestsDirectoryAddress(){
        return getProperty(String.class,"testsDirectoryAddress");
    }


    public <E> E getProperty(Class<E> c, String propertyName) {
        return getObject(c, getProperty(propertyName));
    }

    public <E> Optional<E> getOptionalProperty(Class<E> c, String propertyName) {
        if (containsKey(propertyName)) {
            return Optional.of(getObject(c, getProperty(propertyName)));
        } else {
            return Optional.empty();
        }
    }

    private <E> E getObject(Class<E> c, String value) {
        E e = null;
        try {
            Constructor<E> constructor = c.getConstructor(String.class);
            e = constructor.newInstance(value);
        } catch (ReflectiveOperationException reflectiveOperationException) {
            reflectiveOperationException.printStackTrace();
        }
        return e;
    }
}
