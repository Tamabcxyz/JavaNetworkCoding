import java.net.*;
import java.io.*;
import java.util.Scanner;
class testRequestServer{
	public static void main(String []args){
		try{
			ServerSocket ss= new ServerSocket(80);
			Socket s=ss.accept();
			System.out.println("Server da khoi tao");
			InputStream is= s.getInputStream();
			OutputStream os=s.getOutputStream();
			Scanner sc= new Scanner(is);
			while(true){
				String str=sc.nextLine();
				if(str.equals("")){
					break;
				}
				System.out.println(str);
			}
			s.close();
			ss.close();
		}catch(IOException e){
			System.out.println("Loi server" +e.toString());
		}
	}
}