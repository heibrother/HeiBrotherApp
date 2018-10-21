package com.hei.heibrotherapp.common;


import java.util.HashMap;
import java.util.Map;

public final class Singletons {

    private static Map<Class<?>, Object> container = new HashMap<>();

    private Singletons() {
    }

    /**
     * @param type this class must have an accessible parameterless constructor.
     * @return
     */
    public static <T> T get(Class<T> type) {
        T obj = (T) container.get(type);
        if (obj == null) {
            synchronized (type) {
                obj = (T) container.get(type);
                if (obj == null) {
                    try {
                        obj = type.newInstance();
                        container.put(type, obj);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return obj;
    }

    /**
     * @param type
     * @param func return true to remove the existed object.
     * @param <T>
     */
    public static <T> void ifExists(Class<T> type, BooleanFunction<T> func) {
        T obj = (T) container.get(type);
        if (obj != null) {
            if (func.apply(obj)) {
                container.remove(type);
            }
        }
    }

    public static boolean contains(Class<?> type) {
        return container.containsKey(type);
    }

    /**
     * @param type
     * @return the previous created object of the given type, might be null.
     */
    public static <T> T remove(Class<T> type) {
        return (T) container.remove(type);
    }

    public static void release() {
        container.clear();
    }
}
