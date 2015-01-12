import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) throws IOException {
		if (args.length < 2) {
			System.out.println("参数不符合要求！");
			return;
		}
		System.out.println("参数正确!");
		FileInputStream fis = new FileInputStream(args[0]);
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		FileOutputStream fos = new FileOutputStream(new File(args[1]));
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		String line = "";
		int hangshu = 0;
		int cishu=0;
		while ((line = br.readLine()) != null) {
			++hangshu;
			String regEx="\\.\\d{3,10}"; 
			Pattern pat=Pattern.compile(regEx);  
			Matcher mat=pat.matcher(line);
			StringBuffer sbs = new StringBuffer(); 			
			while(mat.find()){
				++cishu;			
				String ss=mat.group();
				String sb=ss.substring(0,3);
				mat.appendReplacement(sbs, sb);  
			}
			mat.appendTail(sbs); 
			line=sbs.toString();
			bw.write(line + "\r\n");			
		}
		br.close();
		isr.close();
		fis.close();
		bw.close();
		osw.close();
		fos.close();
		System.out.println("共替换 "+hangshu+" 行 "+cishu+" 次。");
		System.out.println("======OVER=====");
		return;
	}
}
