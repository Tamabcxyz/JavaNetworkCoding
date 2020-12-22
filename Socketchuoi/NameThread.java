import java.io.*;
import java.net.*;
public class NameThread extends Thread{
	Socket socket;
	public NameThread(Socket socket){
		this.socket=socket;
	}
	@Override
	public void run(){
		try{
			InputStream is=socket.getInputStream();
			OutputStream os=socket.getOutputStream();
			while(true){
				// nhan du lieu
				byte[] data= new byte[100];
				int n= is.read(data);
				String data_str= new String(data,0,n);
				if(data_str.equals("exit")){
					break;
				}
				// xu ly tra ve ten 
				String ten=tachTen(data_str);
				// tra du lieu ve
				os.write(ten.getBytes());
			}
			socket.close();
			System.out.println("Socket close port "+socket.getPort());
		}catch(IOException e){
			System.out.println("error "+e.toString());
		}
	}
	private String tachTen(String fullname){
		fullname=fullname.trim();
		int index=fullname.lastIndexOf(" ");
		String name=fullname.substring(index+1);
		return name;
	}
	
}