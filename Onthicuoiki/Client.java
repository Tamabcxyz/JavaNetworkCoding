import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Client{
	private static int tcpPort=4444;
	private static int updPort=3333;
	private static String serverAddress="127.0.0.1";
	public static void main(String []args){
		try{
			// tcp
			Socket s= new Socket(serverAddress,tcpPort);
			InputStream is= s.getInputStream();
			OutputStream os= s.getOutputStream();
			Scanner kb= new Scanner(System.in);
			Scanner sc=new Scanner(is);
			PrintWriter pw= new PrintWriter(os);
			//udp
			DatagramSocket ds= new DatagramSocket();
			InetAddress ia= InetAddress.getByName(serverAddress);
			// nhap username
			System.out.println("Nhap username");
			String username=kb.nextLine();
			// nhap pass
			System.out.println("Nhap pass");
			String pass=kb.nextLine();
			
			String namePASS=username+" "+pass;
			DatagramPacket dp= new DatagramPacket(namePASS.getBytes(), namePASS.length(), ia, updPort);
			ds.send(dp);
			
			// nhan ve password tro choi
			byte []b= new byte[60000];
			DatagramPacket result= new DatagramPacket(b,b.length);
			ds.receive(result);
			String str= new String(result.getData(),0, result.getLength());
			System.out.println("Chuoi pass tro choi nhan duoc la: "+str);
			// gui chuoi pass tro choi lai cho serverAddress
			String passplay=kb.nextLine();
			pw.println(passplay);
			pw.flush();
			// nhan cau hoi va dap an
			int i,j=0;
			for(i=0;i<5;i++){
				String question=sc.nextLine();
				System.out.println(question);
				for(j=0;j<4;j++){
					String answer=sc.nextLine();
					System.out.println(answer);
				}
				System.out.println("Dap an ban cho la: ");
				String yourchoose=kb.nextLine();
				
				//day dap an cho server
				pw.println(yourchoose);
				pw.flush();
			}
			// nhan diem tra ve
			String core=sc.nextLine();
			System.out.println("Diem cua ban la: "+core);
			s.close();
			ds.close();
			
			
		}catch(IOException e){
			System.out.println(e.toString());
		}
	}
}