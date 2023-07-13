package ashish.examples.designpatterns;

public class SingletonDesignPatternBillPughExample {
    private static class BillPughSingleton{

        private static final SingletonDesignPatternBillPughExample INSTANCE = new SingletonDesignPatternBillPughExample();

        public static SingletonDesignPatternBillPughExample getInstance(){
            return BillPughSingleton.INSTANCE;
        }

    }
}
