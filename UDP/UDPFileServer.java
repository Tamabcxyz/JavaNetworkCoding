import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.Date;
public class UDPFileServer{
	private static final int PORT=13;
	public static void main(String []args){
		try{
			DatagramSocket socket= new DatagramSocket(PORT);
			System.out.println("Server da duoc khoi tao\n dang doi yeu cau tu client");
			byte []be= new byte[60000];
			while(true){
				// nhan du lieu
				
				DatagramPacket in= new DatagramPacket(be,be.length);// do de bai yeu cau luon tra ve thoi gian cho du client ko yeu cau nen o day la 0
				socket.receive(in);
				System.out.println("Yeu cau tu dia chi:"+in.getAddress());
				// doc file
				String fileName= new String(in.getData(),0,in.getLength());
				File f=new File(fileName);
				int fileLength=(int)f.length();
				byte []result=new byte[fileLength];
				FileInputStream fis= new FileInputStream(f);
				fis.read(result);
				// tra ve client
				DatagramPacket ou= new DatagramPacket(result,result.length,in.getAddress(),in.getPort());
				socket.send(ou);
			}
		}catch(IOException e){
			System.out.println("Loi server "+e.toString());
		}
	}
}