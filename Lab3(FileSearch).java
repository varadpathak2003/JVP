//java -cp . package.FileCode sample.txt java
package jvp;

import java.io.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FileCode {
    public static void main(String[] args) throws Exception {
        File folder = new File(args[0]);
        String text = args[1];

        ExecutorService service = Executors.newFixedThreadPool(4);
        searchInFolder(folder, text, service);

        service.shutdown();
        service.awaitTermination(1, TimeUnit.HOURS);
    }

    static void searchInFolder(File folder, String text, ExecutorService service) {
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                searchInFolder(file, text, service);
            } else {
                service.submit(() -> countMatches(file, text));
            }
        }
    }

    static void countMatches(File file, String text) {
        int count = 0;
        Pattern pattern = Pattern.compile(Pattern.quote(text), Pattern.CASE_INSENSITIVE);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) count++;
            }
            if (count > 0) {
                System.out.println(file.getName() + " - " + count);
            }
        } catch (IOException e) {
            // ignore unreadable files
        }
    }
}
