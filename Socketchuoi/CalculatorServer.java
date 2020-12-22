import java.net.*;
import java.io.*;
public class CalculatorServer{
	public static void main(String []args){
		try{
			ServerSocket serversocket= new ServerSocket(2020);
			System.out.println("Server khoi tao thanh cong");
			System.out.println("Dang cho client ket noi");
			while(true){
				Socket socket=serversocket.accept();
				System.out.println("Hello client port "+socket.getPort());
				CalculatorThread ct= new CalculatorThread(socket);
				ct.start();
			}
		}catch(IOException e){
			System.out.println("Loi server "+e.toString());
		}
	}
}