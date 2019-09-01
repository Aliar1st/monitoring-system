package loc.aliar.monitoringsystem.utils;

import java.util.List;
import java.util.Optional;

public abstract class CollectionUtils {
    private CollectionUtils() {
    }

    public static <T> Optional<T> getFirst(List<T> list) {
        if (list.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(list.get(0));
    }
}
