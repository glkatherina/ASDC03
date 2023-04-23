import java.io.*;
import java.nio.file.*;
import java.util.*;

public class MenuRemover {
    public static void removeRecord(String fileName, String query) throws IOException
    {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                if (!line.toLowerCase().contains(query.toLowerCase()))
                {
                    lines.add(line);
                }
            }
        }
        Files.write(Paths.get(fileName), lines);
    }
}
