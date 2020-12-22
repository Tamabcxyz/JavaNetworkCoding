
import java.net.*;
import java.io.*;
public class Bai1Client{
	public static void main(String []args){
		try{
			// tao ket noi toi server
			Socket socket= new Socket("localhost",2020);
			// tao 2 lop stream in-out
			InputStream is= socket.getInputStream();
			OutputStream os= socket.getOutputStream();
			// luon hoi server
			while(true){
				System.out.println("Nhap tu 0-9");
				int ch=System.in.read();// doc 1 ky tu
				System.in.skip(2);
				// gui toi server
				os.write(ch);
				// kiem tra dk ket thuc
				if(ch=='@')break;
				// nhan du lieu tra ve tu server
				byte []data=new byte[200];
				int n= is.read(data);
				String result=new String(data,0,n);
				// hien thi ket qua ra mang hinh
				System.out.println("Ket qua tra ve: "+result);
			}
			// dong noi ket
			socket.close();
		}catch(IOException e){
			System.out.println("Loi Client "+e.toString());
		}
	}
}