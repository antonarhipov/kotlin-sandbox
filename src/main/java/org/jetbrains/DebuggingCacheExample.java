package org.jetbrains;

public class DebuggingCacheExample {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Cache cache = Cache.getInstance();
            System.out.println(i + ": " + cache);
        }
    }
}

/**
 * <pre>
 * \u263A This is a singleton class
 * \u263A Let's use it to demonstrate evaluate and log in the debugger
 * </pre>
 */
class Cache {
    static Cache instance = null;

    private Cache() {}

    public static Cache getInstance() {
        if (instance == null) {
            instance = new Cache();
        }
        return instance;
    }


}
