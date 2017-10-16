package classCode.loader.myCastomerLoader;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class MyCustomLoader extends ClassLoader {
    protected MyCustomLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if(name.contains("C:\\Users\\admin\\IdeaProjects\\test1\\src\\classCode\\loader\\myCastomerLoader")) {
            String fileName =
                    name.replace('.', File.separatorChar) +
                            ".class";
            InputStream stream =
                    getClass()
                            .getClassLoader()
                            .getResourceAsStream(fileName);
            try {
                int size = stream.available();
                byte[] buffer = new byte[size];

                DataInputStream inputStream = new DataInputStream(stream);
                inputStream.readFully(buffer);
                inputStream.close();

                Class cl = defineClass(name, buffer, 0, buffer.length);
                resolveClass(cl);

                return cl;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.loadClass(name);
    }
}