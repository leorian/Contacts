import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FioStream {
	private static File file = new File("history.txt");
	public static void inputtoTxt(String s) {
		//将字符串写入指定文本文件中
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String shijian = formatter.format(date);
			PrintWriter pw;
				try {
					pw = new PrintWriter(new FileWriter(file, true));
					pw.append(shijian+"\t"+s+"\n");
					pw.flush();
					pw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	public static String readFromtxt(String s) {
		String str = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				String ss = "";
				while((ss=br.readLine())!=null) {
					if(ss.startsWith(s)) {
						str += ss.substring(20, ss.length())+"\n";
					}
				}
				br.close();
				return str;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
