import java.io.*;
import java.net.*;
import java.util.Date;
public class MulticastDateClient{
	public static void main (String []args){
		try{
			MulticastSocket ms= new MulticastSocket(9013);
			InetAddress inet= InetAddress.getByName("230.0.0.1");
			ms.joinGroup(inet);
			while(true){
				byte b[]=new byte[60000];
				DatagramPacket goinhan=new DatagramPacket(b,b.length);
				ms.receive(goinhan);
				
				byte b1[]=goinhan.getData();
				int len=goinhan.getLength();
				String kq=new String(b1,0,len);
				System.out.println("Bay gio la "+kq);
			}
		}catch(IOException e){
			System.out.println("loi client");
		}
	}
}