package loc.aliar.monitoringsystem.utils;

import org.springframework.core.convert.ConversionService;

import java.util.List;
import java.util.stream.Collectors;

public abstract class ConverterUtils {
    private ConverterUtils() {
    }

    public static <T> List<T> convertList(List<?> list, Class<T> clazz, ConversionService conversionService) {
        return list.parallelStream()
                .map(o -> conversionService.convert(o, clazz))
                .collect(Collectors.toList());
    }
}
