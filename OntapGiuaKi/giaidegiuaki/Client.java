import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client{
	public static void main(String[]args){
		try{
			//tao ra socket voi cong 2020
			Socket s = new Socket("127.0.0.1",2020);
			//lay ra hai lop in out
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			//chuyen thanh hai lop thua ke
			Scanner sc = new Scanner(is);
			PrintWriter pw = new PrintWriter(os);
			//nhan sdt va mat khau
			Scanner kb = new Scanner(System.in);
			System.out.println("Nhap mat khau va so dien thoai cua ban");
			String sdt = kb.nextLine();
			pw.println(sdt);
			pw.flush();
			String mk = kb.nextLine();
			pw.println(mk);
			pw.flush();
			String kq = sc.nextLine();
			System.out.println("Ket qua: "+kq);
		}
		catch(IOException e){
			System.out.println("Loi nhap xuat");
		}
	}
}