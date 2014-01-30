import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.apache.commons.io.IOUtils;

import edu.ksu.cis.huffmanCodes.HuffmanTree;

public class compress {
	
	private FileInputStream file;
	private String fileStr;

	public static class letter {
		public char alph;
		public int value;

	}

	public static class binMap {
		public char alph;
		public String bin = "";
		public int set = 0;

	}

	private void readFile(String loc) throws Exception {
		this.file = new FileInputStream(loc);
		this.fileStr = IOUtils.toString(this.file);
	}

	public void print() {
		System.out.println(this.fileStr);
	}
	
	public void zipFile(String inloc,String outloc) throws Exception {
		
		
		System.out.print("Reading file ...");
		this.readFile(inloc);
		System.out.println(" Done");
		
		System.out.print("Compressing ...");
		zipUtil.compress(this.fileStr,outloc);
		System.out.print(" Done\n");
		
		System.out.println("File Written");

	}
	
	public void unzipFile(String loc) throws Exception{
		
		String str;
		
		System.out.print("Reading file ...");
		this.readFile(loc);
		System.out.println(" Done");
		
		System.out.print("Decompressing ...\n");
		str = zipUtil.decompress(loc);
		System.out.println("Done");
		
		//System.out.print(str);
	}
	
	
	
public void compressFile(String loc) throws Exception {
		
		int i,j,num=0;
		Float per;
		String str = "";
		System.out.print("Reading file ...");
		this.readFile(loc);
		System.out.println(" Done");
		StringBuilder sb;
		PrintWriter out = new PrintWriter(new FileWriter("out.txt"));
		
		System.out.print("Huffman coding ...");
		HuffmanTree ht = new HuffmanTree(this.fileStr);
		System.out.println(" Done");
		
		//int len = this.fileStr.length();
		System.out.println("Building Encoded ...");
		
		
		Character b;
		Character[] chars;
		chars = ht.getCharacters();

		
		for(i=0;i<chars.length;i++){
			b=chars[i];
			this.fileStr = this.fileStr.replace(b.toString(), ht.getEncoding(b));
			per = ((i)*1f/(chars.length)*1f)*100;
			System.out.println(per+"%");
			//print();
		}
		str = this.fileStr;
		
	
		/*j=0;
		int count=0;
		for (i = 0; i < len; i++) {
			c = temp.charAt(i);
			str += ht.getEncoding(c);
			j++;
			count++;
			
			if(j==10000){
				per = (count*1f/len*1f)*100;
				System.out.println(per+"%");
				j=0;
			}
			
		}*/
		System.out.print("Done\n");
		//System.out.print(str);
		

		sb = new StringBuilder(str.length()*Byte.SIZE);
		
		for(j=0;j<str.length()/8;j+=8){
			
			for(i=j;i<j+8;i++){
				if(str.charAt(i)=='1'){
					num += 2^i;
				} else if (str.charAt(i)=='0'){
					;
				}else{
					System.out.print("p");
				}
			}
			sb.append(num);
			num=0;
			
		}
		//System.out.println
		out.print(sb.toString());
		out.close();
		System.out.println("File Written");
		//System.out.println(str);

	}


}
