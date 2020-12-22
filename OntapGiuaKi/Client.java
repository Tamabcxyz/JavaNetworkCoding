import java.net.*;
import java.util.Scanner;
import java.io.*;
/*
public class Client{
	//nhap vao username="tam" va mat khau=123 neu dung thi tra ve dung, sai tra ve sai
	public static void main(String []args){
		try{
			Socket s= new Socket("localhost",2020);
			InputStream is= s.getInputStream();
			OutputStream os=s.getOutputStream();
			Scanner sc= new Scanner(is);
			PrintWriter pw= new PrintWriter(os);
			Scanner kb=new Scanner(System.in);
			// nhap tu ban phim
			System.out.println("nhap vao username va pass cach nha boi khoang trang");
			String str=kb.nextLine();
			pw.println(str);
			pw.flush();
			
			String result=sc.nextLine();
			System.out.println(result);
			
		}catch(IOException e){
			System.out.println("Loi client "+e.toString());
		}
	}
}
*/
public class Client{
	//nhap vao username="tam" va mat khau=123 neu dung thi tra ve dung, sai tra ve sai
	public static void main(String []args){
		try{
			Socket s= new Socket("localhost",2020);
			InputStream is= s.getInputStream();
			OutputStream os=s.getOutputStream();
			Scanner sc= new Scanner(is);
			PrintWriter pw= new PrintWriter(os);
			Scanner kb=new Scanner(System.in);
			// nhap tu ban phim
			int result=0;
			do{
				System.out.println("nhap vao username va pass cach nha boi khoang trang");
				String str=kb.nextLine();
				pw.println(str);
				pw.flush();
				// nhan ket qua tra ve
				result=sc.nextInt();
				if(result==1)
					System.out.println("Xac thuc thanh cong");
				else System.out.println("Xac thuc that bai");
			}while(result==0);
			pw.println("exit");
			pw.flush();
			s.close();
		}catch(IOException e){
			System.out.println("Loi client "+e.toString());
		}
	}
}