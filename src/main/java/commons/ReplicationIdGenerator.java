package commons;

import java.security.SecureRandom;

public class ReplicationIdGenerator {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz0123456789";

    /**
     * Generates a random 40-character string containing only lowercase letters and numbers.
     * */
    public static String generate() {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(40);
        for (int i = 0; i < 40; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
}
