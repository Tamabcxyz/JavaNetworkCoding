import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.io.File;
// yeu cau nhap vao: LIST tenthumuc server se tra ve cac tap tin va thu muc trong tenthumuc
public class FileThread extends Thread{
	Socket socket;
	String lenh="";
	String tenthumuc="";
	PrintWriter outputPrint=null;
	public FileThread(Socket socket){
		this.socket=socket;
	}
	@Override
	public void run(){
		try{
			InputStream is= socket.getInputStream();
			OutputStream os= socket.getOutputStream();
			Scanner inputScanner= new Scanner(is);
			outputPrint= new PrintWriter(os);
			while(true){
				// doc du lieu duoc gui len
				String data=inputScanner.nextLine();
				if(data.equals("exit")){
					break;
				}
				tach(data);
				if(lenh.equals("LIST")){
					File file= new File(tenthumuc);
					if(file.isDirectory()){
						processFile(file);
						// sau khi xu ly xong roi day them dau cham de thong bao ket thuc
						outputPrint.println(".");
						outputPrint.flush();
					}else{
						outputPrint.println("Loi ten thu muc");
						outputPrint.println(".");
						outputPrint.flush();
					}
				}else{
					outputPrint.println("Sai cu phap");
					outputPrint.println(".");
					outputPrint.flush();
				}
				
			}
			socket.close();
			System.out.println("socket close port "+socket.getPort());
		}catch(IOException e){
			System.out.println("error thread "+e.toString());
		}
	}
	private void tach(String str){
		str=str.trim();
		int index=str.lastIndexOf(" ");
		lenh=str.substring(0,index);
		tenthumuc=str.substring(index+1);
	}
	private void processFile(File file){
		// lay duong dan cua file
		String path= file.getAbsolutePath();
		
		outputPrint.println(path);
		outputPrint.flush();
		// neu no la thu muc thi xem tree cua no
		if(file.isDirectory()){
			File []listFile=file.listFiles();
			for(File item:listFile){
				processFile(item);// duyet de qui
			}
		}
	}
}