import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.net.Socket;
import java.net.ServerSocket;
import java.lang.NumberFormatException;
public class BinaryServer{
	public static void main(String []args){
		try{
			ServerSocket socketserver= new ServerSocket(2020);
			System.out.println("Server da khoi tao thanh cong");
			System.out.println("dang cho client ket noi");
			while(true){// server luon cho doi de phuc vu client
				Socket socket=socketserver.accept(); // nhan du lieu tu client
				System.out.println("Hello client with port "+socket.getPort());
				InputStream is=socket.getInputStream();
				OutputStream os=socket.getOutputStream();
				while(true){
					byte[] data=new byte[100];
					int n=is.read(data);// doc du lieu duoc gui toi
					String data_str=new String(data,0,n);
					if(data_str.equals("exit")||data_str.equals("EXIT")){
						break;
					}
					String kq="";
					try{
						int so=Integer.parseInt(data_str);
						kq=Integer.toBinaryString(so);
					}catch(NumberFormatException ex){
						kq="Khong phai so nguyen";
					}
					os.write(kq.getBytes());
				}
				socket.close();
				System.out.println("Socket closed port "+socket.getPort());
			}
		}catch(IOException e){
			System.out.println("Loi server "+e.toString());
		}
	}
}