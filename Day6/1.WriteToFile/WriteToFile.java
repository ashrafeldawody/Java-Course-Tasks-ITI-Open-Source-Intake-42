import java.io.*;

public class WriteToFile {
    public static void main(String[] args) {
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        try {
            fileWriter = new FileWriter("sample.txt", true);
            printWriter = new PrintWriter(fileWriter);
            printWriter.println();
            for (String data : args) {
                printWriter.println(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally { 
            try {
                printWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}