import java.io.*;
import java.net.*;
import java.util.Scanner;
// nhap vao ho ten gui toi server, server tra ve ten, yeu cau nhieu client ket noi vao
public class NameClient{
	public static void main(String []args){
		try{
			Socket socket = new Socket("localhost",2020);
			InputStream is=socket.getInputStream();
			OutputStream os=socket.getOutputStream();
			Scanner sc= new Scanner(System.in);
			while(true){
				System.out.println("Nhap vao ho ten: ");
				String hoten=sc.nextLine();
				// chuyen no thanh mang byte roi gui toi server
				os.write(hoten.getBytes());
				if(hoten.equals("exit")){
					break;
				}
				// doc du lieu tu server tra ve
				byte []data= new byte[100];
				int n=is.read(data);
				String result=new String(data,0,n);
				System.out.println("Ket qua tra ve la: "+result);
			}
			socket.close();
		}catch(IOException e){
			System.out.println("Loi client "+e.toString());
		}
	}
}