import java.net.*;
import java.io.*;
import java.util.Scanner;
public class TalkClient{
	private static final int PORT=13;
	public static void main(String []args){
		try{
			DatagramSocket socket=new DatagramSocket();
			InetAddress serveraddress= InetAddress.getByName("localhost");
			Scanner sc= new Scanner(System.in);
			while(true){
				System.out.print("You say: ");
				String str= sc.nextLine();
				// gui di
				byte []to= str.getBytes();
				DatagramPacket ou= new DatagramPacket(to,to.length,serveraddress,PORT);
				socket.send(ou);
				
				//nhan phan hoi
				byte []data= new byte[60000];
				DatagramPacket in=new DatagramPacket(data,data.length);
				socket.receive(in);
				String result= new String(in.getData(),0,in.getLength());
				System.out.println("Friend say: "+result);
			}
		}catch(IOException e){
			System.out.println("Loi client "+e.toString());
		}
	}
}