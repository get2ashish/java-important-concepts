package ashish.examples.cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

public class LRUCache {
    private Map<Integer, String> cache;
    private LinkedList<Integer> order;
    private final int CACHE_SIZE;

    public LRUCache(int cacheSize) {
        CACHE_SIZE = cacheSize;
        order = new LinkedList<>();
        cache = new HashMap<>();
    }

    void addToCache(int key, String value) {
        if (order.size() >= CACHE_SIZE) {
            int keyRemoved = order.removeLast();
            cache.remove(keyRemoved);
        }
        order.addFirst(key);
        cache.put(key, value);
    }

    String getFromCache(Integer key) {
        String res = cache.get(key);
        if (Objects.nonNull(res)) {
            order.remove(key);
            order.addFirst(key);
        }
        return res;
    }
    public void display() {
        for (int key : order) {
            System.out.println(key + " => " + cache.get(key));
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.addToCache(1, "one");
        cache.addToCache(2, "two");
        cache.addToCache(3, "three");
        cache.addToCache(4, "four");

        System.out.println(cache.getFromCache(3));
        System.out.println(cache.getFromCache(2));
        System.out.println(cache.getFromCache(1));

        cache.addToCache(1, "one");

        System.out.println(cache.getFromCache(3));
        System.out.println(cache.getFromCache(1));
        cache.display();
    }

}
