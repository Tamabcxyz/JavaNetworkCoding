import java.net.*;
import java.util.Scanner;
import java.io.*;
/*
public class ServerSS{
	//nhap vao username="tam" va mat khau=123 neu dung thi tra ve dung, sai tra ve sai
	public static void main(String []args){
		try{
			ServerSocket ss=new ServerSocket(2020);
			System.out.println("Server da duoc khoi tao cho ket noi");
			Socket s=ss.accept();
			System.out.println("Accept ket noi tu port "+s.getPort());
			ServerThread st=new ServerThread(s);
			st.start();
			
		}catch(IOException e){
			System.out.println("Loi client "+e.toString());
		}
	}
}
class ServerThread extends Thread{
	private Socket s;
	public ServerThread(Socket s){
		this.s=s;
	}
	@Override 
	public void run(){
		try{
			InputStream is=s.getInputStream();
			OutputStream os=s.getOutputStream();
			Scanner sc=new Scanner(is);
			PrintWriter pw=new PrintWriter(os);
			// nhan chuoi gui qua
			String str=sc.nextLine();
			str=str.trim();
			String name=str.substring(0,str.indexOf(" "));
			System.out.println(name);
			String pass=str.substring(str.indexOf(" ")+1);
			System.out.println(pass);
			if(name.equals("tam")&&pass.equals("123")){
				pw.println("Xac thuc thanh cong");
				pw.flush();
			}else{
				pw.println("Xac thuc that bai");
				pw.flush();
			}
		}catch(IOException b){
			System.out.println("Loi thread "+b.toString());
		}
		
	}
}
*/
public class ServerSS{
	//nhap vao username="tam" va mat khau=123 neu dung thi tra ve dung, sai tra ve sai
	public static void main(String []args){
		try{
			ServerSocket ss=new ServerSocket(2020);
			System.out.println("Server da duoc khoi tao cho ket noi");
			while(true){
				Socket s=ss.accept();
				System.out.println("Accept ket noi tu port "+s.getPort());
				ServerThread st=new ServerThread(s);
				st.start();
			}
		}catch(IOException e){
			System.out.println("Loi client "+e.toString());
		}
	}
}
class ServerThread extends Thread{
	private Socket s;
	public ServerThread(Socket s){
		this.s=s;
	}
	@Override 
	public void run(){
		try{
			InputStream is=s.getInputStream();
			OutputStream os=s.getOutputStream();
			Scanner sc=new Scanner(is);
			PrintWriter pw=new PrintWriter(os);
			// nhan chuoi gui qua
			while(true){
				String str=sc.nextLine();
				if(str.equals("exit"))break;
				str=str.trim();
				String name=str.substring(0,str.indexOf(" "));
				System.out.println(name);
				String pass=str.substring(str.indexOf(" ")+1);
				System.out.println(pass);
				if(name.equals("tam")&&pass.equals("123")){
					pw.println(1);
					pw.flush();
				}else{
					pw.println(0);
					pw.flush();
				}
			}
			s.close();
		}catch(IOException b){
			System.out.println("Loi thread "+b.toString());
		}
		
	}
}