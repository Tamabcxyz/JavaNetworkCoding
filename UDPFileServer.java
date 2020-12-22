import java.io.*;
import java.net.*;
class UDPFileServer {
	public static void main(String[] args) {
		try {
			// Tao Socket UDP cong 7000
			DatagramSocket ds = new DatagramSocket(7000);
			// Nhan goi yeu cau tu Client
			byte b[] = new byte[1000];
			DatagramPacket goinhan = new DatagramPacket(b,1000);
			ds.receive(goinhan);
			// Xu ly yeu cau => lay file
			byte b1[] = goinhan.getData();
			int len1 = goinhan.getLength();
			String command = new String(b1,0,len1);
			String tenfile = command.substring(8);
			InetAddress dc = goinhan.getAddress();
			int p = goinhan.getPort();
			File f = new File(tenfile);
			int len2 =  (int)f.length();
			if(f.exists() && len2>0) {
				FileInputStream f1 = new FileInputStream(tenfile);
				byte b2[] = new byte[len2];
				f1.read(b2);
				f1.close();
				DatagramPacket goigui = new DatagramPacket(b2,len2,dc,p);
				ds.send(goigui);
			}
			else {
				byte b3[] = new byte[5];
				DatagramPacket goigui = new DatagramPacket(b3,0,dc,p);
				ds.send(goigui);
			}
		}
		catch(SocketException e) {
			System.out.println("Khong khoi tao duoc UDP Socket");
		}
		catch(FileNotFoundException e) {
			System.out.println("Khong tim thay file");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
	}
}
