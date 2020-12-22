import java.util.Scanner;
import java.net.*;
import java.io.*;
class UDPFileClient {
	public static void main(String[] args) {
		try {
			// Tao Socket UDP
			DatagramSocket ds = new DatagramSocket();
			// Nhap tu ban phim ten file
			Scanner kb = new Scanner(System.in);
			System.out.print("Nhap ten file tren Server can lay: ");
			String tenfile = kb.nextLine();
			System.out.print("Nhap ten file can luu: ");
			String tenfileghi = kb.nextLine();
			// Dong goi
			String command = "READUDP " + tenfile;
			byte b[] = command.getBytes();
			int len = b.length;
			InetAddress dc = InetAddress.getByName("127.0.0.1");
			int p = 7000;
			DatagramPacket goigui = new DatagramPacket(b,len,dc,p);
			// Gui goi qua Server
			ds.send(goigui);
			// Nhan goi tra loi tu Server
			byte b1[] = new byte[60000];
			DatagramPacket goinhan = new DatagramPacket(b1,60000);
			ds.receive(goinhan);
			// Luu file
			int len2 = goinhan.getLength();
			if(len2==0)
				System.out.println("File khong ton tai hoac file rong");
			else {
				byte b2[] = goinhan.getData();
				FileOutputStream f = new FileOutputStream(tenfileghi);
				f.write(b2,0,len2);
				f.close();
				System.out.println("Da luu file thanh cong");
			}
			ds.close();
		}
		catch(SocketException e) {
			System.out.println("Khong khoi tao duoc UDP Socket");
		}
		catch(UnknownHostException e) {
			System.out.println("Sai dia chi");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
	}
}
