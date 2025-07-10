package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.model.Book;
import com.aurionpro.model.BookAuthorComparator;
import com.aurionpro.model.BookTitleComparator;

public class BookTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int choice = 0;

		List<Book> books = new ArrayList<>();
		List<Book> issuedBooks = new ArrayList<>();

		
		System.out.println("***Book application***");
		do {
			
			System.out.println("\n1. Add a new book");
			System.out.println("2. Issue a book");
			System.out.println("3. Display all available books");
			System.out.println("4. Display all issued books");
			System.out.println("5. Return a book");
			System.out.println("6. Sort books ->\n   - Ascending order of author.\n   - Descending author of title.");
			System.out.println("7. Exit");

			System.out.print("\nEnter your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.print("Enter title: ");
				String title = scanner.nextLine();

				System.out.print("Enter author: ");
				String author = scanner.nextLine();

				System.out.print("Enter publication: ");
				String publication = scanner.nextLine();

				books.add(new Book(title, author, publication, true));
				System.out.println("\nBook added successfully.");
				break;
				
			case 2: 
				System.out.print("Enter title of the book: ");
				String issueTitle = scanner.nextLine();
				
				Boolean found;
				for(Book book : books) {
					if(book.getTitle().equalsIgnoreCase(issueTitle)) {
						if(book.isAvailable()) {
							book.setAvailable(false);
							issuedBooks.add(book);
							System.out.println("Book issued successfully.");
						} else {
							System.out.println("Something went wrong! Book cannot be issued.");
						}
						found = true;
						break;
					}
				}
				break;
				
			case 3:
				for (Book book : books)
					if(book.isAvailable()) 
						System.out.println(book);
				break;
				
			case 4:
				for(Book book: issuedBooks) 
					System.out.println(book);
				break;
				
			case 5: 
				System.out.print("Enter name of the book to be return: ");
				String returnTitle = scanner.nextLine();
				Boolean bookFound = false;
				Iterator<Book> iterator = issuedBooks.iterator();
				while(iterator.hasNext()) {
					Book book = iterator.next();
					if(book.getTitle().equalsIgnoreCase(returnTitle)) {
						if(!book.isAvailable()) {
							book.setAvailable(true);
							iterator.remove();
							System.out.println("Book returned successfully.");
							bookFound = true;
							break;
						}
					}

				}
				if(!bookFound) {
					System.out.println("Something went wrong! Book not found in issued list.");
				}
				break;
			
			case 6:
				System.out.print("Select sorting option: ");
				int sortingOption = scanner.nextInt();
				
				if(sortingOption == 1) {
					Collections.sort(books, new BookAuthorComparator());
					for(Book book : books)
						System.out.println(book);
					
				} else if(sortingOption == 2){
					Collections.sort(books, new BookTitleComparator());
					for(Book book : books)
						System.out.println(book);
				}
			}
			
		} while (choice != 7);
	}
}
