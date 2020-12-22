import java.io.*;
import java.net.*;
import java.util.Date;
public class MulticastFileClient{
	public static void main (String []args){
		try{
			MulticastSocket ms= new MulticastSocket(9013);
			InetAddress inet= InetAddress.getByName("230.10.10.10");
			ms.joinGroup(inet);
			byte b[]=new byte[60000];
			DatagramPacket goinhan=new DatagramPacket(b,b.length);
			ms.receive(goinhan);
			
			byte b1[]=goinhan.getData();
			int lenb1=goinhan.getLength();
			FileOutputStream fs=new FileOutputStream("D:/LTM/result.jpg");
			fs.write(b1,0,lenb1);
			fs.close();
			System.out.println("ghi file thanh cong");
		}catch(IOException e){
			System.out.println("loi client");
		}
	}
}