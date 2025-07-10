package com.aurionpro.model;

public class Book {

	private static int idCounter = 1;
	private int bookId;
	private String title;
	private String author;
	private String publication;
	private boolean isAvailable;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Book(String title, String author, String publication, boolean isAvailable) {
		super();
		this.bookId = idCounter++;
		this.title = title;
		this.author = author;
		this.publication = publication;
		this.isAvailable = isAvailable;
	}

	public Book() {
		super();
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", publication=" + publication
				+ "]";
	}
	
}
