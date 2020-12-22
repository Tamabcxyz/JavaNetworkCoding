
import java.net.*;
import java.io.*;
public class Bai1Server{
	private static Socket socket;
	public static void main(String []args){
		try{
			// tao server socket
			ServerSocket ss= new ServerSocket(2020);
			System.out.println("Server da duoc khoi tao\n dang cho client ket noi");
			// cho phen server co nhieu ket noi toi
			while(true){
				socket=ss.accept();
				System.out.println("Chap nhan ket noi tu dia chi"+socket.getInetAddress()+" o cong "+socket.getPort());
				// tao 2 lop stream in-out
				InputStream is= socket.getInputStream();
				OutputStream os= socket.getOutputStream();
				// luon lang nghe yeu cau tu client
				while(true){
					// nhan yeu cau
					int request=is.read();
					System.out.println("Da nha ky tu: "+(char)request);
					String result="Khong phai so nguyen";
					if(request=='@')break;
					// xu ly yeu cau
					switch(request){
						case '0': result="Khong";break;
						case '1': result="Mot";break;
						case '2': result="Hai";break;
						case '3': result="Ba";break;
						case '4': result="Bon";break;
						case '5': result="Nam";break;
						case '6': result="Sau";break;
						case '7': result="Bay";break;
						case '8': result="Tam";break;
						case '9': result="Chin";break;
					}
					// tra ve ket qua
					os.write(result.getBytes());
				}
				socket.close();
				System.out.println("Da ngat ket voi "+socket.getInetAddress()+" o cong "+socket.getPort());
			}
		}catch(IOException e){
			System.out.println("Loi Server "+e.toString());
		}
	}
}