package org.LibraryManagent.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ImplementLibraryManagement implements LibraryManagement {

	String url = "jdbc:mysql://localhost:3306?user=root&password=kishore@2004";
	Scanner sc = new Scanner(System.in);

	@Override
	public void addBook() {

		String query = "insert into gejm8.librarydata values(?,?,?,?,?)";

		try {
			Connection connection = DriverManager.getConnection(url);

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			System.out.println("Enter book name:");
			String bName = sc.next();
			preparedStatement.setString(1, bName);

			System.out.println("Enter the book price:");
			int bPrice = sc.nextInt();
			preparedStatement.setInt(2, bPrice);

			System.out.println("Enter number of pages in book ");
			int nPages = sc.nextInt();
			preparedStatement.setInt(3, nPages);

			System.out.println("Enter author's name:");
			String bAuthor = sc.next();
			preparedStatement.setString(4, bAuthor);

			System.out.println("Enter book edition nuber:");
			int bEdition = sc.nextInt();
			preparedStatement.setInt(5, bEdition);

			preparedStatement.executeUpdate();

			System.out.println("Book added successfully!!");

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void searchBook() {

		try {
			Connection connection = DriverManager.getConnection(url);

			System.out.println("Search Book:" + "\n1) By Name" + "\n2) By Author" + "\n3) By Edition"
					+ "\nEnter your choice(1-3):");
			int ch = sc.nextInt();
			sc.nextLine();
			switch (ch) {
			case 1:
				String query1 = "select * from gejm8.librarydata where book=?";
				PreparedStatement preparedStatement = connection.prepareStatement(query1);
				System.out.println("Enter the Book name:");
				String bName = sc.nextLine();
				preparedStatement.setString(1, bName);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					String book = resultSet.getString("book");
					int price = resultSet.getInt("price");
					int pages = resultSet.getInt("NofPages");
					String author = resultSet.getString("author");
					int edition = resultSet.getInt("edition");
					System.out.println("Book Name:" + book + "\tBook Price:" + price + "\t Number of pages:" + pages
							+ "\t Author Name:" + author + "\t Book Edition:" + edition);
				}
				break;

			case 2:
				String query2 = "select * from gejm8.librarydata where author=?";
				PreparedStatement preparedStatement1 = connection.prepareStatement(query2);
				System.out.println("Enter the author name:");
				String bAuthor = sc.nextLine();
				preparedStatement1.setString(1, bAuthor);
				ResultSet resultSet1 = preparedStatement1.executeQuery();
				while (resultSet1.next()) {
					String book = resultSet1.getString("book");
					int price = resultSet1.getInt("price");
					int pages = resultSet1.getInt("NofPages");
					String author = resultSet1.getString("author");
					int edition = resultSet1.getInt("edition");
					System.out.println("Book Name:" + book + "\tBook Price:" + price + "\tNumber of pages:" + pages
							+ "\tAuthor Name:" + author + "\tBook Edition:" + edition);
				}
				break;

			case 3:
				String query3 = "select * from gejm8.librarydata where edition=?";
				PreparedStatement preparedStatement2 = connection.prepareStatement(query3);
				System.out.println("Enter the Book edition:");
				int bEdition = sc.nextInt();
				preparedStatement2.setInt(1, bEdition);
				ResultSet resultSet3 = preparedStatement2.executeQuery();
				while (resultSet3.next()) {
					String book = resultSet3.getString("book");
					int price = resultSet3.getInt("price");
					int pages = resultSet3.getInt("NofPages");
					String author = resultSet3.getString("author");
					int edition = resultSet3.getInt("edition");
					System.out.println("Book Name:" + book + "\tBook Price:" + price + "\tNumber of pages:" + pages
							+ "\tAuthor Name:" + author + "\tBook Edition:" + edition);
				}
				break;

			default:
				System.err.println("Invalid Choice");
			}
			
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateBook() {
		try {
			Connection connection = DriverManager.getConnection(url);

			System.out.println("Delete Book:" + "\n1) By Name" + "\n2) By Author" + "\nEnter your choice(1-2):");
			int ch = sc.nextInt();
			sc.nextLine();
			switch (ch) {
			case 1:
				String query1 = "update gejm8.librarydata set book=? , price=? ,NofPages=? , author=? , edition=? where book=?";
				PreparedStatement preparedStatement = connection.prepareStatement(query1);
				System.out.println("Enter the Book name:");
				String bName = sc.nextLine();
				preparedStatement.setString(6, bName);
				System.out.println("Enter new book name:");
				String nbName = sc.nextLine();
				preparedStatement.setString(1, nbName);

				System.out.println("Enter new book price:");
				int bPrice = sc.nextInt();
				preparedStatement.setInt(2, bPrice);

				System.out.println("Enter new number of pages in book ");
				int nPages = sc.nextInt();
				preparedStatement.setInt(3, nPages);

				System.out.println("Enter new author's name:");
				String bAuthor = sc.nextLine();
				preparedStatement.setString(4, bAuthor);

				System.out.println("Enter new book edition nuber:");
				int bEdition = sc.nextInt();
				preparedStatement.setInt(5, bEdition);
				preparedStatement.executeUpdate();
				System.out.println("Book updated Successfully!!");
				break;

			case 2:
				String query2 = "update gejm8.librarydata set book=? , price=? ,NofPages=? , author=? , edition=? where edition=?";
				PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
				System.out.println("Enter Book edition:");
				int bEdition1 = sc.nextInt();
				preparedStatement2.setInt(6, bEdition1);
				System.out.println("Enter new book name:");
				String bName1 = sc.nextLine();
				preparedStatement2.setString(1, bName1);

				System.out.println("Enter new book price:");
				int bPrice1 = sc.nextInt();
				preparedStatement2.setInt(2, bPrice1);

				System.out.println("Enter new number of pages in book ");
				int nPages1 = sc.nextInt();
				preparedStatement2.setInt(3, nPages1);

				System.out.println("Enter new author's name:");
				String bAuthor1 = sc.nextLine();
				preparedStatement2.setString(4, bAuthor1);

				System.out.println("Enter new book edition nuber:");
				int nbEdition1 = sc.nextInt();
				preparedStatement2.setInt(5, nbEdition1);
				preparedStatement2.executeUpdate();
				System.out.println("Book updated Successfully!!");
				break;

			default:
				System.err.println("Invalid Choice");
			}
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeBook() {

		try {
			Connection connection = DriverManager.getConnection(url);

			System.out.println("Delete Book:" + "\n1) By Name" + "\n2) By Author" + "\nEnter your choice(1-2):");
			int ch = sc.nextInt();
			sc.nextLine();
			switch (ch) {
			case 1:
				String query1 = "delete from gejm8.librarydata where book=?";
				PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
				System.out.println("Enter the Book name:");
				String bName = sc.nextLine();
				preparedStatement1.setString(1, bName);
				preparedStatement1.executeUpdate();
				System.out.println("Book removed Successfully!!");
				break;

			case 2:
				String query2 = "delete from gejm8.librarydata where author=?";
				PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
				System.out.println("Enter the author name:");
				String bAuthor = sc.nextLine();
				preparedStatement2.setString(1, bAuthor);
				preparedStatement2.executeUpdate();
				System.out.println("Book removed Successfully!!");
				break;

			default:
				System.err.println("Invalid Choice");
			}
			
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
