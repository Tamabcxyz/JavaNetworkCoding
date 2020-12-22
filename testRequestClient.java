import java.net.*;
import java.io.*;
import java.util.Scanner;
class testRequestClient{
	public static void main(String []args){
		try{
			Socket s=new Socket("127.0.0.1",80);
			InputStream is= s.getInputStream();
			OutputStream os=s.getOutputStream();
			Scanner sc= new Scanner(is);
			//Scanner kb=new Scanner(System.in);
			PrintWriter pw=new PrintWriter(os);
			// gui du lieu di
			
			pw.write("GET / HTTP/1.1");
			pw.flush();
			pw.write("Host: 127.0.0.1");
			pw.flush();
			pw.write("Connection: keep-alive");
			pw.flush();
			pw.write("Upgrade-Insecure-Requests: 1");
			pw.flush();
			pw.write("User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) coc_coc_browser/90.0.148 Chrome/84.0.4147.148 Safari/537.36");
			pw.flush();
			pw.write("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
			pw.flush();
			
			// nhan du lieu tra ve
			
			while(true){
				byte []data=new byte[200];
				int n= is.read(data);
				String result=new String(data,0,n);
				if(result.equals(""))break;
				System.out.println(result);
			}
		}catch(IOException e){
			System.out.println("Loi client" +e.toString());
		}
	}
}