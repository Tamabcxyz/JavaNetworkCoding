import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.Date;
public class DateServer{
	private static final int PORT=13;
	public static void main(String []args){
		try{
			DatagramSocket socket= new DatagramSocket(PORT);
			System.out.println("Server da duoc khoi tao\n dang doi yeu cau tu client");
			while(true){
				// nhan du lieu
				byte []be= new byte[60000];
				DatagramPacket in= new DatagramPacket(be,0);// do de bai yeu cau luon tra ve thoi gian cho du client ko yeu cau nen o day la 0
				socket.receive(in);
				System.out.println("Yeu cau tu dia chi:"+in.getAddress());
				// xu ly
				Date date= new Date();
				String str=date.toString();
				// tra ve client
				byte []result=str.getBytes();
				DatagramPacket ou= new DatagramPacket(result,result.length,in.getAddress(),in.getPort());
				socket.send(ou);
			}
		}catch(IOException e){
			System.out.println("Loi server "+e.toString());
		}
	}
}