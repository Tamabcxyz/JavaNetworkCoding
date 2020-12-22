import java.io.*;
import java.net.*;
import java.util.Scanner;
public class FileClient{
	public static void main(String []args){
		try{
			Socket socket= new Socket("localhost",2020);
			InputStream is= socket.getInputStream();
			OutputStream os= socket.getOutputStream();
			Scanner sc= new Scanner(System.in);
			
			Scanner inputScanner=new Scanner(is);
			PrintWriter outputPrint=new PrintWriter(os);
			
			while(true){
				System.out.println("Nhap vao cau lenh:");
				String request=sc.nextLine();
				// day du lieu len server
				outputPrint.println(request);
				outputPrint.flush();
				if(request.equals("exit")){
					break;
				}
				// nhan du lieu tra ve tu server
				while(true){
					String result=inputScanner.nextLine();
					if(result.equals(".")){
						break;// khi server tra ve dau . co nghia la het du lieu
					}
					System.out.println(result);
				}
			}
		}catch(IOException e){
			System.out.println("Loi client "+e.toString());
		}
	}
}