import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

//http://stackoverflow.com/questions/453018/number-of-lines-in-a-file-in-java
public class FileIO {
	public static void tail(File src, OutputStream out, int maxLines) throws FileNotFoundException
	{
		try {
			RandomAccessFile raf = new RandomAccessFile(src, null);
			
			raf.seek(0);   
			raf.readLine();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
