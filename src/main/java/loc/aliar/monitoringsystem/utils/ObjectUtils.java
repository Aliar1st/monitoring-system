package loc.aliar.monitoringsystem.utils;

import java.util.Optional;
import java.util.function.Function;

public abstract class ObjectUtils {
    private ObjectUtils() {
    }

    public static <T, R> R nullSafe(T obj, Function<T, R> function) {
        return Optional.ofNullable(obj)
                .map(function)
                .orElse(null);
    }
}
