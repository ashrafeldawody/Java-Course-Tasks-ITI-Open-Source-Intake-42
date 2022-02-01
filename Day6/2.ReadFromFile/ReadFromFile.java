import java.io.*;

public class ReadFromFile{
public static void main (String[] args)
{
    try (FileInputStream fis = new FileInputStream("sample.txt")) {
        int size = fis.available();
        byte[] b = new byte[size];
        fis.read(b);
        System.out.println(new String(b));
        fis.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}