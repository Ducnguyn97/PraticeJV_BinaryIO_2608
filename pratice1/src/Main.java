import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter source file:");
        String sourceFile = sc.nextLine();
        System.out.println("Enter destination file:");
        String destinationFile = sc.nextLine();

        File souFile = new File(sourceFile);
        File desFile  = new File(destinationFile);

        try{
            //copyFileUsingStreams(souFile, desFile);
            copyFileUsingJava7Files(souFile, desFile);
            System.out.println("Files copied successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void copyFileUsingJava7Files(File source, File dest ) throws IOException {
      Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    private static void copyFileUsingStreams(File source, File dest ) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while((length = is.read(buffer))> 0){//read() trả về -1 nếu hết file
                os.write(buffer, 0, length);
            }
        }finally {
            is.close();
            os.close();
        }
    }
}
