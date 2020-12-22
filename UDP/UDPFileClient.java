import java.net.*;
import java.io.*;
import java.util.Scanner;
public class UDPFileClient{
	private static final int PORT=13;
	public static void main(String []args){
		// de: nhap vao ten file gui toi server, server se thuc hien copy file cho client
		try{
			DatagramSocket socket= new DatagramSocket();
			InetAddress serveraddress= InetAddress.getByName("localhost");
			Scanner sc= new Scanner(System.in);
			String str="";
			do{
				System.out.print("Copy ");
				str=sc.nextLine();
			}while(checkFile(str));
			// gui du lieu di
			byte []pack=str.getBytes();
			DatagramPacket request=new DatagramPacket(pack,pack.length,serveraddress,PORT);
			socket.send(request);
			// nhan yeu cau tra ve va luu thanh file
			File f=new File("result");
			FileOutputStream fos= new FileOutputStream(f);
			// nhan kq tra ve
			byte []kq= new byte[60000];
			DatagramPacket result=new DatagramPacket(kq,kq.length);
			socket.receive(result);
			fos.write(result.getData(),0,result.getLength());
			System.out.println("Luu thanh cong");
			
		}catch(IOException e){
			System.out.println("Loi server "+e.toString());
		}
	}
	private static boolean checkFile(String namefile){
		boolean error=false;
		File f= new File(namefile);
		int maxlength=64*1024;
		int fileLength=(int)f.length();
		if(fileLength>maxlength){
			error=true;
			System.out.println("file qua lon(file phai nho hon 64kb) chon file khac");
		}
		if(!f.exists()){
			error=true;
			System.out.println("file khong ton tai");
		}return error;
	}
}