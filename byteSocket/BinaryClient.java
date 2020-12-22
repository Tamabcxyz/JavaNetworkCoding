import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.net.Socket;
// nhap vao 1 chuoi so nguyen gui toi sever, sever doi ra binary va tra ve cho client, 
public class BinaryClient{
	public static void main(String []args){
		try{
			Socket socket=new Socket("localhost",2020);
			InputStream is=socket.getInputStream();// nhan du lieu tu sever gui tra lai
			OutputStream os=socket.getOutputStream();// gui toi sever
			Scanner sc=new Scanner(System.in);
			while(true){// client cu nhap lien tuc
				System.out.println("Nhap vao chuoi so nguyen/ nhap exit de thoat");
				String str=sc.nextLine();
				// khi day du lieu qua server thi chi day duoc kieu int, byte nen phai chuyen ve mang byte
				byte []data=str.getBytes();
				os.write(data);//gui toi server
				if(str.equals("exit")||str.equals("EXIT")){
					break;
				}
				// nhan du lieu tu server tra ve
				byte []result=new byte[100];
				int n=is.read(result);// lay so byte tra ve
				String result_str= new String(result,0,n);
				System.out.println("Ket qua tra ve: "+result_str);
			}
			socket.close();
		}catch(IOException e){
			System.out.println("Loi phia Client "+e.toString());
		}
	}
}