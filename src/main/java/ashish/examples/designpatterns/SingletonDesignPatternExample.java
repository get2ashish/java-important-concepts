package ashish.examples.designpatterns;

import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SingletonDesignPatternExample implements Serializable {
    private static volatile SingletonDesignPatternExample instance = null;
    private static final Lock lock = new ReentrantLock(true);

    private SingletonDesignPatternExample() {
    }

    public static SingletonDesignPatternExample getInstance() {
        if (Objects.isNull(instance)) {
            lock.lock();
            if (Objects.isNull(instance)) {
                instance = new SingletonDesignPatternExample();
            }
            lock.unlock();
        }
        return instance;
    }

    /**
     * This method will be invoked when the deserialization of object happens and it will maintain the same Object
     */
    protected Object readResolve(){
        return instance;
    }
}
