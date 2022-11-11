package BankApplication;
import java.lang.*;
import java.util.*;

public class appByDeepakSir  {

	public static void main(String[] args) {
		String[] MyInfo=new String[6];
		Scanner Sc=new Scanner(System.in);
		MyInfo=CreateUserId();
		String Uid="",Pss="";
		// Login With Userid Password
		System.out.println("Do you want To login");
		String Dcsc;
		while(true){
			System.out.println("Do you want To login");
			Dcsc=Sc.next();
			if (Dcsc.equals("Y")|| Dcsc.equals("N")){
				break;
			}
			else{
				System.out.println("Invalid Input");
			}
		}
		if (Dcsc.equals("Y")){
			System.out.println("Welcome to our bank");

			System.out.println("Enter Your Credentials");


			while(true){
				System.out.println("Enter User ID");
				Uid=Sc.next();
				System.out.println("Enter Password");
				Pss=Sc.next();
				if (Uid.equals(MyInfo[2]) && Pss.equals(MyInfo[3])){
					System.out.println("HI "+MyInfo[0]);
					break;
				}
				else {
					System.out.println("Invalid Credential Try Again");
				}
			}


			// Transaction and editing Phase
			System.out.println("Press T for Transaction");
			System.out.println("Press U for Updating Info");

			while (true){
				System.out.println("Enter Your Option");
				String Chk=Sc.next();
				if (Chk.equals("T") || Chk.equals("U")){
					if (Chk.equals("T")){
						// Case of Trasaction
						System.out.println("Press W to withdraw");
						System.out.println("Press D to deposit");
						while (true){
							System.out.println("Enter Your Option");
							Chk=Sc.next();
							if (Chk.equals("W") || Chk.equals("D")){
								if (Chk.equals("W")){
									// with draw case
									System.out.println("Lets Withdraw");
									System.out.println("Enter Amount to Withdraw");
									int Amt=Sc.nextInt();
									int IntAmt=Integer.parseInt(MyInfo[4]);
									if (Amt<=IntAmt){
										IntAmt=IntAmt-Amt;
										MyInfo[4]=Integer.toString(IntAmt);
										System.out.println("Transaction Successful");
										System.out.println("YOur Balance is "+IntAmt);
									}
									else{
										System.out.println("Insufficient balance");
									}

									break;
								}
								else{
									// deposit case
									System.out.println("Lets Deposit");
									System.out.println("Enter Amount to Deposit");
									int Amt=Sc.nextInt();
									int IntAmt=Integer.parseInt(MyInfo[4]);
									if (Amt>=0){
										IntAmt=IntAmt+Amt;
										MyInfo[4]=Integer.toString(IntAmt);
										System.out.println("Transaction Successful");
										System.out.println("YOur Balance is "+IntAmt);
									}
									else{
										System.out.println("Wrong Deposit");
									}
									break;
								}

							}
							else {
								System.out.println("Invalid Input");
							}

						}

					}
					else{


					}
					break;
				}
				else{
					System.out.println("Not a Valid Input");
				}

			}

		}
		else{
			System.out.println("Thanks For Using Our App");
		}


	}












	public static String[] CreateUserId(){
		Scanner Sc=new Scanner(System.in);
		String Name,Userid,Pass,Cntc;
		int IntBal,Mtrans;
		String[] Info=new String[6];
		while (true){
			System.out.println("Enter Your Name: ");
			Name=Sc.next();
			if (Name.length()>0 && Name.matches("^[a-zA-Z]*$")){
				System.out.println(Name);
				break;
			}
			else{
				System.out.println("Invalid Input");
			}
		}

		// For Contact INput
		while (true){
			System.out.println("Enter Your Contact: ");
			Cntc=Sc.next();
			if (Cntc.length()==10 && Cntc.matches("^[0-9]*$")) {
				System.out.println(Cntc);
				break;
			}
			else{
				System.out.println("Invalid Input");
			}

		}

		// Userid
		System.out.println("Enter User Id");
		Userid=Sc.next();

		// Password
		System.out.println("Enter Password");
		Pass=Sc.next();

		// Initial Balance
		while(true) {
			System.out.println("Enter Deposit Amount");
			IntBal=Sc.nextInt();
			if (IntBal>1000){
				System.out.println(IntBal);
				break;
			}
			else{
				System.out.println("Please Deposit >1000");
			}
		}

		// Minimum Transaction
		while(true) {
			System.out.println("Enter Min Transaction");
			Mtrans=Sc.nextInt();
			if (Mtrans>0){
				System.out.println(Mtrans);
				break;
			}
			else{
				System.out.println("Invalid Input");
			}
		}


		Info[0]=Name;
		Info[1]=Cntc;
		Info[2]=Userid;
		Info[3]=Pass;
		Info[4]=Integer.toString(IntBal);
		Info[5]=Integer.toString(Mtrans);

		return Info;

	}

}
