package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtil {
    static List<String> values = new ArrayList<>();

    public static List<String> readCSVFile(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        scanner.useDelimiter(",");
        while (scanner.hasNext()) {
            values.add(scanner.next());
        }
        scanner.close();
        return values;
    }
}
