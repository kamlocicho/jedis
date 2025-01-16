package storage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Storage {
    private final Map<String, String> data;

    private Storage() {
        data = new ConcurrentHashMap<>();
    }

    private static final class InstanceHolder {
        private static final Storage instance = new Storage();
    }

    public static Storage getInstance() {
        return InstanceHolder.instance;
    }

    public String get(String key) {
        return data.get(key);
    }

    public void set(String key, String value) {
        data.put(key, value);
    }
}
