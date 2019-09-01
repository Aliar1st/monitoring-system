package loc.aliar.monitoringsystem.utils;

import java.lang.reflect.Field;

public abstract class ReflectionUtils {
    private ReflectionUtils() {
    }

    public static void setFieldValue(Object obj, String name, Object value) {
        Class<?> clazz = obj.getClass();
        Field field = getField(name, clazz);
        org.springframework.util.ReflectionUtils.setField(field, obj, value);
    }

    private static Field getField(String name, Class<?> clazz) {
        Field field = org.springframework.util.ReflectionUtils.findField(clazz, name);
        org.springframework.util.ReflectionUtils.makeAccessible(field);
        return field;
    }

    public static Object getFieldValue(Object obj, String name) {
        Class<?> clazz = obj.getClass();
        Field field = getField(name, clazz);
        return org.springframework.util.ReflectionUtils.getField(field, obj);
    }

    public static <T> T getFieldValue(Object obj, String name, Class<T> fieldClass) {
        return fieldClass.cast(getFieldValue(obj, name));
    }
}
