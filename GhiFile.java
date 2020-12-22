import java.util.Scanner;
import java.io.*;
class GhiFile {
	public static void main(String[] args) 	{
		try {
			Scanner kb = new Scanner(System.in);
			System.out.print("Nhap ten file can ghi: ");
			String tenfile = kb.nextLine();
			FileOutputStream f = new FileOutputStream(tenfile);
			PrintWriter pw = new PrintWriter(f);
			System.out.println("Nhap du lieu can luu vao file");
			System.out.println("Ket thuc khi chi nhap . tren 1 dong");
			while(true) {
				String str = kb.nextLine();
				if(str.equals(".")) break;
				pw.println(str);	// Ghi chuoi str vao file
				pw.flush();
			}
			f.close();
			System.out.println("Da ghi file thanh cong");
		}
		catch(FileNotFoundException e) {
			System.out.println("Khong tim thay file");
		}
		catch(IOException e) {
			System.out.println("Co loi khi ghi file");
		}

	}
}
