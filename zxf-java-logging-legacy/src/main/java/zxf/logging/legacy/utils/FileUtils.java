package zxf.logging.legacy.utils;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class FileUtils {
    public static String findClassPathFiles(String filePath) throws IOException {
        Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(filePath);
        StringBuilder stringBuilder = new StringBuilder("[");
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            stringBuilder.append(url.toString());
            if (urls.hasMoreElements()) {
                stringBuilder.append(", ");
            }

        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
