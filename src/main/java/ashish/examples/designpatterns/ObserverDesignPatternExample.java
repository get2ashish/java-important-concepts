package ashish.examples.designpatterns;


import java.util.HashSet;
import java.util.Set;
interface Observer {
    public void update(String m);
}
interface Observable{
    public void register(Observer o);
    public void unRegister(Observer o);
    public void notify(String m);
}

class IPhoneObservable implements Observable{
    Set<Observer> subscribers = new HashSet<>();

    @Override
    public void register(Observer observer) {
        System.out.println("Observer added to list "+observer);
        subscribers.add(observer);
    }

    @Override
    public void unRegister(Observer observer) {
        System.out.println("Observer removed from list "+observer);
        subscribers.remove(observer);
    }

    @Override
    public void notify(String changedMessaged) {
        for(Observer observer : subscribers){
            observer.update(changedMessaged);
        }
    }
}

class User1 implements Observer{
    @Override
    public void update(String message) {
        System.out.println("User 1 received the update for message "+message);
    }
}

class User2 implements Observer{
    @Override
    public void update(String message) {
        System.out.println("User 2 received the update for message "+message);
    }

}

class User3 implements Observer{
    @Override
    public void update(String message) {
        System.out.println("User 3 received the update for message "+message);
    }
}

public class ObserverDesignPatternExample {

    public static void main(String[] args) {
        IPhoneObservable outOfStockIphonePublisher = new IPhoneObservable();

        User1 user1 = new User1();
        User2 user2 = new User2();
        User3 user3 = new User3();

        outOfStockIphonePublisher.register(user1);
        outOfStockIphonePublisher.register(user2);
        outOfStockIphonePublisher.register(user3);
        outOfStockIphonePublisher.notify("Iphone 14 Pro back in stock.");

        outOfStockIphonePublisher.unRegister(user3);

        outOfStockIphonePublisher.notify("Iphone 14 Pro is out of stock.");

    }
}
