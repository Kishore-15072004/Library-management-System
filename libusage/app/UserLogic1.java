package org.libusage.app;

import java.util.Scanner;

import org.LibraryManagent.app.LibraryManagement;
import org.LibraryManagent.app.ProceedManagement;

public class UserLogic1 {

	public static void main(String[] args) {
		LibraryManagement lb=ProceedManagement.getObject();
		Scanner sc=new Scanner(System.in);
		char c = 'Y';
		while(c=='Y')
		{
			System.out.println("----Library Management Menu----"
					+ "\n1) Add Book"
					+ "\n2) Search Book"
					+ "\n3) Update Book"
					+ "\n4) Remove Book"
					+ "\nEnter Your Choice:");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:lb.addBook();
					break;
			case 2:lb.searchBook();
					break;
			case 3:lb.updateBook();
					break;
			case 4:lb.removeBook();
					break;
			default:System.err.println("Invalid Choice");
			}
			
			System.out.println("Do you want to continue (Y/N):");
			c=sc.next().charAt(0);
		}
		System.out.println("THANK YOU");
	}

}
