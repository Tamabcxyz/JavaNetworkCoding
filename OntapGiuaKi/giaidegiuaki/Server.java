import java.net.*;
import java.io.*;
import java.util.Scanner;

class Xulydangnhap{
	public static boolean check(String sdt, String mk){
		if(sdt.equals("0123")&&mk.equals("123")){
			return true;
			}
		else{
			return false;
		}
	}
}

class ServerSS extends Thread{
	private Socket s;
	public ServerSS(Socket s1){
		s = s1;
	}
	public void run(){
		try{
			//lay in out
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			//chuyen hai lop is os thanh scanner va printwriter
			Scanner sc = new Scanner(is);
			PrintWriter pw = new PrintWriter(os);
			
			//nhan sdt va mat khau tu client
			String sdt = sc.nextLine();
			String mk=sc.nextLine();
			//kiem tra sdt va mat khau
			if(Xulydangnhap.check(sdt,mk)){
				pw.println("Thanh cong");
				pw.flush();
			}
			else{
				pw.println("That bai");
				pw.flush();
			}
			s.close();
		}
		catch(IOException e){
			System.out.println("Dong ket noi");
		}
	}
}

public class Server{
	public static void main(String[]args){
		try{
			//tao socket Serversocket
			ServerSocket ss = new ServerSocket(2020);
			while(true){
				//chap nhan ket noi
				try{
					Socket s = ss.accept();
					//tao serverss
					ServerSS sv = new ServerSS(s);
					sv.start();
				}
				catch(IOException e){
					System.out.println("Loi ket noi");
				}
				
			}
		}
		catch(IOException e){
			System.out.println("Tao socket that bai");
		}
	}
}