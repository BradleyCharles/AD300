import java.util.HashMap;
import java.util.Map;

public class Cache<T> {
    private final Map<String, T> cache = new HashMap<>();

    public void add(String key, T item) {
        cache.put(key, item);
    }

    public T get(String key) {
        return cache.get(key);
    }

    public void clear() {
        cache.clear();
    }

    public void addAll(Cache<? extends T> otherCache) {
        for (Map.Entry<String, ? extends T> entry : otherCache.cache.entrySet()) {
            this.cache.put(entry.getKey(), entry.getValue());
        }
    }

    public int size() {
        return cache.size();
    }
}
