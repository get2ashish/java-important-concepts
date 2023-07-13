package ashish.examples.designpatterns;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BreakingSingletonDesignPatternExample {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor [] declaredConstructors = SingletonDesignPatternExample.class.getDeclaredConstructors();
        Constructor constructor = declaredConstructors[0];
        constructor.setAccessible(true);
        SingletonDesignPatternExample reflectedInstance = (SingletonDesignPatternExample)constructor.newInstance();
        SingletonDesignPatternExample instance = SingletonDesignPatternExample.getInstance();
        System.out.println(reflectedInstance.hashCode());
        System.out.println(instance.getInstance().hashCode());

        //Other way to break Singleton pattern is using Serialization thats why we have created the readResolve method
    }
}
