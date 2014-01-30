import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class zipUtil {

	public static void compress(String str, String outFile) throws IOException {
		//Compresses str and writes it to outFile
		FileOutputStream fos = new FileOutputStream(outFile);
		GZIPOutputStream gzip = new GZIPOutputStream(fos);
		
		gzip.write(str.getBytes("UTF-8"));
		gzip.close();
		//out.toString() "ISO-8859-1"
	}
	
	public static String decompress(String inFile) throws IOException {
		//Reads inFile and returns the uncompressed string
		FileInputStream fis = new FileInputStream(inFile);
		GZIPInputStream gzip = new GZIPInputStream(fis);

		String out="";
		int size = fis.available();
		int j = 0;
		byte[] bytein = new byte[8096];
		while((gzip.read(bytein, 0, bytein.length)!=-1)){
			out += (new String(bytein,"UTF-8"));
			j++;
			if(j==1000){
				System.out.println(( (size-fis.available())*1f/size*1f)*100.00f+"%" );
				j=0;
			}
			
		}
		
		gzip.close();

		return out;
	}
	
}
