import java.net.*;
import java.io.*;
import java.util.Scanner;
public class CalculatorThread extends Thread{
	Socket socket;
	String op;
	double num1=0.0,num2=0.0;
	public CalculatorThread(Socket socket){
		this.socket=socket;
	}
	@Override
	public void run(){
		try{
			InputStream is= socket.getInputStream();
			OutputStream os= socket.getOutputStream();
			Scanner inputScanner= new Scanner(is);
			PrintWriter outputPrint= new PrintWriter(os);
			while(true){
				String request=inputScanner.nextLine();
				if(request.equals("exit")){
					break;
				}
				process(request);
				double result=0.0;
				switch(op){
					case "+":result=num1+num2;break;
					case "-":result=num1-num2;break;
					case "*":result=num1*num2;break;
					case "/":result=num1/num2;break;
				}
				outputPrint.println(result);
				outputPrint.flush();
			}
			socket.close();
			System.out.println("Socket close port "+socket.getPort());
		}catch(IOException e){
			System.out.println("Loi thread "+e.toString());
		}
	}
	public void process(String str){
		str=str.trim();
		int i=str.indexOf(" ");
		int j=str.lastIndexOf(" ");
		op=str.substring(0,i);
		String number1=str.substring(i+1,j);
		num1=Double.parseDouble(number1);
		String number2=str.substring(j+1);
		num2=Double.parseDouble(number2);
	}
}