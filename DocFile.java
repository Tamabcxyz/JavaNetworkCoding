import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
class DocFile {
	public static void main(String[] args) {
		try {
			Scanner kb = new Scanner(System.in);
			System.out.print("Nhap ten file can doc: ");
			String tenfile = kb.nextLine();
			FileInputStream f = new FileInputStream(tenfile);
			while(true) {
				int ch = f.read();		// cach 1: Doc tung ky tu
				if(ch==-1) break;		// Dung lai khi het file
				System.out.print((char)ch);
			}
			f.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Khong tim thay file");
		}
		catch(IOException e) {
			System.out.println("Co loi khi doc file");
		}
	}
}
