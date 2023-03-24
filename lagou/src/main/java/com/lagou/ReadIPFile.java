package com.lagou;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadIPFile {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Windows\\Desktop\\kxsw\\ip.txt"));
            FileWriter writer = new FileWriter("C:\\Users\\Windows\\Desktop\\kxsw\\all.txt");
            String line;
            Pattern pattern = Pattern.compile("\"([^\"]*)\"");
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String match = matcher.group(1);
                    writer.write(match + "\n");
                }
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
