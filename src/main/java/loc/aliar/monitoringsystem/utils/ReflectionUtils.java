package loc.aliar.monitoringsystem.utils;

import java.lang.reflect.Field;

public abstract class ReflectionUtils {
    private ReflectionUtils() {
    }

    public static void setFieldValue(Object obj, String name, Object value) throws ReflectiveOperationException {
        Class<?> clazz = obj.getClass();
        Field field = clazz.getField(name);
        field.setAccessible(true);
        field.set(obj, value);
    }

    public static Object getFieldValue(Object obj, String name) throws ReflectiveOperationException {
        Class<?> clazz = obj.getClass();
        Field field = clazz.getField(name);
        field.setAccessible(true);
        return field.get(obj);
    }
}
