package main.java.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: pratyush
 * Date: 4/22/13
 * Time: 1:48 AM
 */

public class FileReaderUtil {

    public String[] readLines(String filename) throws IOException {

        BufferedReader bufferedReader = null;
        List<String> lines;

        try {
            FileReader fileReader = new FileReader(filename);

            bufferedReader = new BufferedReader(fileReader);
            lines = new ArrayList<String>();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }

        } catch (IOException ioe) {
            throw ioe;
        } finally {
            bufferedReader.close();
        }
        return lines.toArray(new String[lines.size()]);
    }
}


