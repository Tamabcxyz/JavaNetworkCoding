import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Server{
	private static int tcpPort=4444;
	private static int updPort=3333;
	private static String serverAddress="127.0.0.1";
	private static Socket s;
	private static DatagramSocket ds;
	
	public static void main(String []args){
		try{
			ServerSocket ss= new ServerSocket(tcpPort);
			//udp
			ds= new DatagramSocket(updPort);
			System.out.println("server da duoc khoi tao thanh cong!");
			// phuc vu nhieu client
			while(true){
				s= ss.accept();
				ServerThread st= new ServerThread(s,ds);
				st.start();
			}
		}catch(IOException e){
			System.out.println("Loi server"+e.toString());
		}
	}
}

class ServerThread extends Thread{
	private Socket s;
	private DatagramSocket ds;
	public ServerThread(Socket s, DatagramSocket ds){
		this.s=s;
		this.ds=ds;
	}
	@Override
	public void run(){
		// khoi tao danh sach cau hoi
		Question []lq=new Question[5];
		lq[0]=new Question("Em an com chua","E an roi","E chua an","E khong biet","Ke e hoi chi?","D");
		lq[1]=new Question("Em an com chua","E an roi","E chua an","E khong biet","Ke e hoi chi?","D");
		lq[2]=new Question("Em an com chua","E an roi","E chua an","E khong biet","Ke e hoi chi?","D");
		lq[3]=new Question("Em an com chua","E an roi","E chua an","E khong biet","Ke e hoi chi?","D");
		lq[4]=new Question("Em an com chua","E an roi","E chua an","E khong biet","Ke e hoi chi?","D");
		try{
			InputStream is= s.getInputStream();
			OutputStream os= s.getOutputStream();
			Scanner sc=new Scanner(is);
			PrintWriter pw= new PrintWriter(os);
			
			// nhan chuoi username va pass tu username
			byte []a= new byte[60000];
			DatagramPacket dp= new DatagramPacket(a, a.length);
			ds.receive(dp);
			String str=new String(dp.getData(),0,dp.getLength());
			System.out.println("nhan duoc tu client"+str);
			// tao chuoi gui lai client
			String passplay="abcd1234";
			DatagramPacket dpsend= new DatagramPacket(passplay.getBytes(),passplay.length(),dp.getAddress(),dp.getPort());
			ds.send(dpsend);
			// nhan pass tro choi lai
			String pl=sc.nextLine();
			if(pl.equals(passplay)){
				int i,j=0;
				int core=0;
				for(i=0;i<5;i++){
					pw.println(lq[i].question);
					pw.flush();
					for(j=0;j<4;j++){
						pw.println(lq[i].answer[j]);
						pw.flush();
					}
					String userchoose=sc.nextLine();
					if(userchoose.equals(lq[i].result)){
						core=core+1;
					}
				}
				// nhan diem tra ve
				//day dap an cho server
				pw.println(core);
				pw.flush();
			}else{
				pw.println("sai chuoi tro choi");
				pw.flush();
			}
		}catch(IOException e){
			System.out.println("Loi thread");
		}
		
	}
}
class Question{
	String question;
	String answer[]=new String[4];
	String result;
	public Question(String q, String A, String B, String C, String D, String r){
		this.question=q;
		this.answer[0]="A: "+A;
		this.answer[1]="B: "+B;
		this.answer[2]="C: "+C;
		this.answer[3]="D: "+D;
		this.result=r;
	}
}
