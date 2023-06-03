package ashish.examples.multithreading;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalExample {

    /*
    ThreadLocals are per thread instances for memory efficiency and thread safety
    If multiple threads share an object then it needs to be thread safe, if you create that object per thread its
    becomes an overhead.
    */
    public static void main(String[] args) {

        for(int i=0;i<10;i++){
            Thread thread = new Thread(()->{
                String formattedDate = showDetails(new Date());
                System.out.println(Thread.currentThread().getName() + "-"+formattedDate);
            },"T"+i);
            thread.start();
        }

    }

    public static String showDetails(Date date){
        SimpleDateFormat simpleDateFormat = ThreadSafeFormatter.dateFormatter.get();
        return simpleDateFormat.format(date);
    }
}

class ThreadSafeFormatter{
    public static ThreadLocal<SimpleDateFormat> dateFormatter =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyy-MM-dd"));
}
