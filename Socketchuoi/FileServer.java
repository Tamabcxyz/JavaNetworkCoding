import java.io.*;
import java.net.*;
public class FileServer{
	public static void main(String []args){
		try{
			ServerSocket serversocket= new ServerSocket(2020);
			System.out.println("Server da duoc khoi tao");
			System.out.println("Dang cho client ket noi");
			while(true){
				Socket socket=serversocket.accept();
				System.out.println("Hello client port "+socket.getPort());
				FileThread f= new FileThread(socket);
				f.start();
			}
		}catch(IOException e){
			System.out.println("Loi server "+e.toString());
		}
	}
}