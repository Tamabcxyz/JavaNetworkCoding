import java.io.*;
import java.net.*;
import java.util.Date;
import java.lang.*;
public class MulticastFileServer{
	public static void main (String []args){
		try{
			DatagramSocket ds=new DatagramSocket();
			FileInputStream fi=new FileInputStream("C:/Users/student/Desktop/download.jpg");
			byte b[]=new byte[60000];
			int n=fi.read(b);
			fi.close();
			InetAddress inet= InetAddress.getByName("230.10.10.10");
			DatagramPacket goigui=new DatagramPacket(b,n,inet,9013);
			while(true){
				ds.send(goigui);
				Thread.sleep(5000);
			}
		}catch(IOException e){
			System.out.println("loi server");
		}catch(InterruptedException i){
			System.out.println(i);
		}
	}
}