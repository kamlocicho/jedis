package command;

import java.io.IOException;
import java.io.OutputStream;

public interface Command {
    void execute(OutputStream outputStream) throws IOException;
}
