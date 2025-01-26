package commons;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;

public class Parser {
    public static String bulkString(Object obj) {
        if (obj == null) {
            throw new RuntimeException("Null object passed to bulkString");
        }
        StringBuilder result = new StringBuilder();
        Field[] fields = obj.getClass().getDeclaredFields();
        Arrays.stream(fields)
                .filter(Objects::nonNull)
                .forEach(field -> {
                    field.setAccessible(true);
                    try {
                        result.append(field.getName()).append(":").append(field.get(obj)).append("\n");
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("Error parsing object to bulk string: " + e.getMessage());
                    }
                });
        return result.toString();
    }
}
