import java.io.*;
import java.net.*;
import java.util.Scanner;
public class NameServer{
	public static void main(String []args){
		try{
			ServerSocket serversocket= new ServerSocket(2020);
			System.out.println("Server da khoi tao ");
			System.out.println("Dang doi client ket noi");
			while(true){
				Socket socket=serversocket.accept();
				System.out.println("Hello client port "+socket.getPort());
				NameThread namethread= new NameThread(socket);
				namethread.start();// chay phuong thuc run ben class NameThread
			}
			
		}catch(IOException e){
			System.out.println("Loi server "+e.toString());
		}
	}
}