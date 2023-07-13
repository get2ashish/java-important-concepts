package ashish.examples.designpatterns;

import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SingletonDesignPatternExample {
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
}
