import java.net.*;
import java.io.*;
import java.util.Scanner;

public class DateClient{
	private static int PORT=13;
	public static void main(String []args){
		try{
			DatagramSocket socket= new DatagramSocket();
			InetAddress serveraddress= InetAddress.getByName("localhost");
			Scanner sc= new Scanner(System.in);
			while(true){
				// day du lieu di
				System.out.println("Nhap vao cau lenh");
				String request=sc.nextLine();
				byte []be= request.getBytes();
				// co 4 doi so, du lieu dang byte, do day, server address, port
				DatagramPacket packed= new DatagramPacket(be,be.length,serveraddress,PORT);
				socket.send(packed);
				
				//nhan du lieu tra ve
				byte[] data= new byte[60000];
				DatagramPacket result= new DatagramPacket(data,data.length);
				socket.receive(result);
				// doi thanh chuoi hien thi ra mang hinh
				// 3 doi so: mang byte, 0, do day
				String str= new String(result.getData(), 0, result.getLength());
				System.out.println("ket qua tra ve "+str);
			}
			
		}catch(IOException e){
			System.out.println("Loi client "+e.toString());
		}
	}
}