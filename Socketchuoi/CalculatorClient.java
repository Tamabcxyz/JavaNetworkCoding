import java.net.*;
import java.io.*;
import java.util.Scanner;
public class CalculatorClient{
	public static void main(String []args){
		try{
			Socket socket= new Socket("127.0.0.1", 2020);
			InputStream is=socket.getInputStream();
			OutputStream os=socket.getOutputStream();
			Scanner sc= new Scanner(System.in);
			Scanner inputScanner=new Scanner(is);
			PrintWriter outputPrint=new PrintWriter(os);
			while(true){
				System.out.println("Nhap vao bieu thuc");
				String str=sc.nextLine();
				String new_str=chuyenYeuCau(str);
				outputPrint.println(new_str);
				outputPrint.flush();
				if(new_str.equals("exit")){
					break;
				}
				// nhan kq
				String result=inputScanner.nextLine();
				System.out.println("Ket qua tra ve: "+result);
			}
			socket.close();
		}catch(IOException e){
			System.out.println("Loi client "+e.toString());
		}
	}
	public static String chuyenYeuCau(String str){
		str=str.trim();
		String result="";
		int firstIndex=str.indexOf(" ");
		int secondIndex=str.lastIndexOf(" ");
		if(firstIndex>0){
			String op=str.substring(firstIndex+1,secondIndex);
			String num1=str.substring(0,firstIndex);
			String num2=str.substring(secondIndex+1);
			result=op+" "+num1+" "+num2;
		}else{
			result=str;
		}
		return result;
	}
}