package command;

import command.impl.EchoCommand;
import command.impl.PingCommand;
import command.impl.UnknownCommand;

import java.util.Arrays;

public class CommandFactory {
    public static Command createCommand(String input) {
        String[] parts = input.split(" ");
        String command = parts[0];
        String[] values = Arrays.copyOfRange(parts, 1, parts.length);

        if (command.equalsIgnoreCase("PING")) {
            return new PingCommand();
        } else if (command.equalsIgnoreCase("ECHO")) {
            return new EchoCommand(values);
        } else {
            return new UnknownCommand();
        }
    }
}
