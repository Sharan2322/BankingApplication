package com.BankingApplication;

import java.lang.*;
import java.util.*;

public class bankingApp {
        public static void main(String[] args) {

            String[] myInfo = new String[6];
            myInfo = creatUserId();
            Scanner sc = new Scanner(System.in);
            //System.out.println(" do you want to login ?");
            String yesNo, pw = "", Id = "";

            while (true) {

                System.out.println(" do you want to login ?");

                yesNo = sc.next();
                if (yesNo.equals("Y") || yesNo.equals("N")) {
                    break;
                } else {
                    System.out.println(" invalid input ");
                }
            }


            if (yesNo.equals("Y")) {
                while (true) {
                    System.out.println(" welcome..... ");
                    System.out.println(" write userId:- ");
                    Id = sc.next();

                    System.out.println(" write password:- ");
                    pw = sc.next();
                    if (Id.equals(myInfo[2]) && pw.equals(myInfo[3])) {
                        System.out.println(" user authorised ");
                        break;
                    } else {
                        System.out.println(" user not authorised  ");
                    }
                }

                //Transaction and editing
                System.out.println("do you want to do transaction(T) or you want to edit(E) credentials ");
                while (true) {
                    //System.out.println("do you want to do transaction(T) or you want to edit(E) credentials ");

                    System.out.println("enter option");
                    String t = sc.next();
                    String d = "";
                    String w = "";

                    //	while (true) {
                    if (t.equals("T") || t.equals("E")) {

                        if (t.equals("T")) {
                            //Trasaction phase....
                            while (true) {
                                System.out.println(" enter W for withdraw and D for deposit ");
                                d = sc.next();
                                if (d.equals("W") || d.equals("D")) {
                                    if (d.equals("W")) {
                                        //Withdraw case...
                                        System.out.println(" enter withdraw amount ");
                                        int amt = sc.nextInt();
                                        int intamt = Integer.parseInt(myInfo[4]);
                                        if (amt <= intamt) {
                                            intamt = intamt - amt;
                                            myInfo[4] = Integer.toString(intamt);
                                            System.out.println(" transactioin successfull");
                                            System.out.println(" your balance is " + intamt);
                                        } else {
                                            System.out.println(" sorry Insufficient balance");
                                        }
                                        break;

                                    } else {
                                        // deposit case

                                        System.out.println("Lets Deposit");
                                        System.out.println("Enter Amount to Deposit");
                                        int Amt = sc.nextInt();
                                        int IntAmt = Integer.parseInt(myInfo[4]);
                                        if (Amt >= 0) {
                                            IntAmt = IntAmt + Amt;
                                            myInfo[4] = Integer.toString(IntAmt);
                                            System.out.println("Transaction Successful");
                                            System.out.println("YOur Balance is " + IntAmt);
                                        } else {
                                            System.out.println("Wrong Deposit");
                                        }
                                        break;
                                    }

                                } else {
                                    System.out.println("Invald Input..............");
                                }
                            }
                        }

                        //			}
                        else {
                            System.out.println(" welcome to edit phase.... ");


                            //edite case
                            System.out.println(" update all 'A' , update individual 'I' ");
                            String update = sc.next();
                            while (true) {
                                if (update.equals("A")) {
                                    //update code for all
                                    System.out.println(" update name ");
                                    myInfo[0] = sc.next();

                                    System.out.println(" update Id");
                                    myInfo[1] = sc.next();

                                    System.out.println(" update password ");
                                    myInfo[2] = sc.next();

                                    System.out.println("updated name is : " + myInfo[0]);
                                    System.out.println("updated Id is : " + myInfo[1]);
                                    System.out.println(" updated password is : " + myInfo[2]);

                                } else if (update.equals("I")) {
                                    System.out.println("what do you want to update : name(1), contact(2), password(3)  ");
                                    int ind = sc.nextInt();
                                    switch (ind) {
                                        case 1:
                                            //change in name
                                            myInfo[0] = sc.next();
                                            System.out.println( " updated name is : " + myInfo[0]);
                                            break;
                                        case 2:
                                            myInfo[1] = sc.next();
                                            System.out.println(" updated Id is " + myInfo[1]);
                                            break;
                                        case 3:
                                            myInfo[2] = sc.next();
                                            System.out.println(" updated password is : " + myInfo[2]);
                                            break;


                                    }
                                    //	break;
                                }
                                break;
                            }
                            //break;
                        }

                    }
                    break;
                    //}
                }


            }
            else {
                System.out.println("thanks for using our app");
            }
        }



        public static String[] creatUserId(){
            String name;
            String userid;
            String password;
            String contact;
            int initialDeposit;
            int transcation;
            Scanner sc = new Scanner(System.in);
            String info [] = new String[6];

            while (true) {
                System.out.println(" enter name:- ");
                name = sc.nextLine();
                if(name.length()>0&& name.matches("^[a-zA-Z ]*$")){
                    System.out.println(name);
                    break;
                }
                else {
                    System.out.println(" invalid input ");
                }
            }

            while(true) {
                System.out.println(" enter contact:- ");
                contact = sc.next();
                if (contact.length() == 10 && contact.matches("^[0-9]*$")) {
                    System.out.println(contact);
                    break;
                } else {
                    System.out.println(" not a number ");
                }
            }

            System.out.println(" enter userid:- ");
            userid = sc.nextLine();
            userid = sc.nextLine();

            System.out.println(" enter password:- " );
            password = sc.nextLine();

            while( true){
                System.out.println(" enter initial deposit:- ");
                initialDeposit = sc.nextInt();
                if(initialDeposit>=1000){
                    break;}

                else{
                    System.out.println(" re-enter");
                }
            }

            while(true) {

                System.out.println(" enter Min. transaction amount:- ");
                transcation = sc.nextInt();
                if( transcation>0){
                    break;
                }
                else{
                    System.out.println(" re-enter min transaction");
                }
            }

            info[0] = name;
            info[1] = contact;
            info[2] = userid;
            info[3]= password;
            info[4]= Integer.toString(initialDeposit);

            info[5]= Integer.toString(transcation);
            return info;

        }

    }
