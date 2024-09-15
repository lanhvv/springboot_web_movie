package com.example.demo.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class CommonHandleCollectionUtils {
    public static Map<String, Object> objectToMap(Object object) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        for (Field field : object.getClass().getFields()) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(object));
        }
        return map;
    }
}
