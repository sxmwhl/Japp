import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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
		while ((line = br.readLine()) != null) {
			line=line+"dfsdf";
			bw.write(line + "\r\n");
		}
		br.close();
		isr.close();
		fis.close();
		bw.close();
		osw.close();
		fos.close();
		return;
	}
}
