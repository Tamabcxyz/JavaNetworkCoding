import java.util.Scanner;
import java.net.*;
import java.io.*;
class ClientDocFile {
	public static void main(String[] args) {
		try {
			// Noi ket
			Socket s = new Socket("127.0.0.1", 22222);
			// Lay ra 2 stream
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			// Doi thanh cac doi tuong thuoc lop thua ke
			Scanner sc = new Scanner(is);
			PrintWriter pw = new PrintWriter(os);
			// Nhap ten file can lay ve
			Scanner kb = new Scanner(System.in);
			System.out.print("Nhap ten file tren Server: ");
			String tenfile = kb.nextLine();
			// Nhap ten file can luu
			System.out.print("Nhap ten file can luu: ");
			String fileghi = kb.nextLine();
			// Gui cau lenh
			String caulenh = "READ " + tenfile;
			pw.println(caulenh); pw.flush();
			// Nhan ket qua
			String str = sc.nextLine();
			int n = Integer.parseInt(str);
			if(n==-1)
				System.out.println("File khong ton tai");
			else
				if(n==0)
					System.out.println("File rong");
				else {
					// Luu ket qua
					FileOutputStream f = new FileOutputStream(fileghi);
					byte b[] = new byte[n];
					System.out.println("Kich thuoc file " + n);
					DataInputStream dis = new DataInputStream(is);
					dis.readFully(b);
					f.write(b);
					f.close();	// Dong file da ghi
					System.out.println("Da ghi file thanh cong");
				}
			// Dong noi ket
			s.close();
		}
		catch(IOException e) {
			System.out.println("Co loi");
		}
	}
}
