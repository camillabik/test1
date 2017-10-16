package classCode.consolFileEditor;

import java.util.List;

public interface Editor {
    /**
     * Read from file to console.
     * @return
     */
    String read();

    /**
     * Write to file from console.
     */
    void write(String text);

    /**
     * append some text to file.
     */
    void append(String text);
}
