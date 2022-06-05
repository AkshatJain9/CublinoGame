/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package comp1140.ass2.gui.tools.resources;

import java.util.HashMap;

/**
 * A collection of preloaded resources
 * @param <T> type of resource to store
 */
public abstract class ResourcePool<T> {
    protected HashMap<String, T> pool;

    public ResourcePool() {
        pool = new HashMap<>();
    }

    /**
     * add and preload a resource to the pool
     * @param key resource name
     * @param path resource URI
     */
    public abstract void load(String key, String path);

    /**
     * get a resource provided it was already loaded with load
     * @param key
     * @return
     */
    public T get (String key) {
        if (!pool.containsKey(key))
            throw new RuntimeException("no such " + key + " found in pool");

        return pool.get (key);
    }
}
