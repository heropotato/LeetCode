import java.util.LinkedHashMap;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 11/10/13
 * Time: 12:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class LRUCache {

    /*
    *
    * LRU Cache
    *
    * Design and implement a data structure for Least Recently Used (LRU) cache.
    *
    * It should support the following operations: get and set.
    *
    * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
    *
    * set(key, value) - Set or insert the value if the key is not already present.
    * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
    *
    * */

    // according to the question, how the cache work is similar to "F-I-F-O".
    // considering the key --> value, choose LinkedHashMap (keeping insertion order)
    // each time set/get the key existed in the cache, it has to be re-inserted to let it be the most recently used

    LinkedHashMap<Integer, Integer> cache;
    final int capacity;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key, value);
            return value;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (value < 0) return;
        if (cache.containsKey(key)) cache.remove(key);
        cache.put(key, value);
        if (cache.size() > capacity) cache.remove(cache.keySet().iterator().next());
    }
}
