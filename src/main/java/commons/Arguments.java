package commons;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Arguments {
    private final static Map<String, String> argumentsMap = new HashMap<>();

    public static void parseArguments(String[] args) {
        if (args == null) {
            return;
        }
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("--")) {
                String key = args[i].substring(2);
                String value = args[i + 1];
                argumentsMap.put(key, value);
            }
        }
    }

    public static String getArgument(String key) {
        return argumentsMap.get(key);
    }

    public static boolean hasArgument(String key) {
        return argumentsMap.containsKey(key);
    }

    public static Map<String, String> getArgumentsMap() {
        return argumentsMap;
    }
}
