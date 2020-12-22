import java.io.*;
import java.net.*;
import java.util.Date;
import java.lang.*;
public class MulticastDateServer{
	public static void main (String []args){
		try{
			DatagramSocket ds=new DatagramSocket();
			while(true){
				Date d=new Date();
				String kq=d.toString();
				byte b[]=kq.getBytes();
				int len=b.length;
				InetAddress inet= InetAddress.getByName("230.0.0.1");
				DatagramPacket goigui=new DatagramPacket(b,len,inet,9013);
				ds.send(goigui);
				System.out.println("Vua gui goi luc "+kq);
				Thread.sleep(5000);// sau 5s gui lai 1 lan
			}
		}catch(IOException e){
			System.out.println("loi server");
		}catch(InterruptedException i){
			System.out.println(i);
		}
	}
}