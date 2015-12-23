package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {


    /*

        List books tests. Implement the first three tests for the Verify exercise

     */

    private List<String> books;
    private PrintStream printStream;
    private Library library;

    @Before
    public void setUp() {
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
        library = new Library(books, printStream, null);
    }


    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {

        String title = "Book Title";

        books.add(title);

        library.listBooks();

        // add a verify statement here that shows that the book title was printed by to the printStream
        verify(printStream).println("Book Title");
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {

        library.listBooks();

        verifyZeroInteractions(printStream);

    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() {

        String firstTitle = "First Book Title";
        String secondTitle = "Second Book Title";

        books.add(firstTitle);
        books.add(secondTitle);

        library.listBooks();

        verify(printStream).println("Second Book Title");
        verify(printStream).println("First Book Title");

    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    @Ignore
    public void shouldWelcomeUser() {
        List<String> books = new ArrayList<>();
        PrintStream printStream = mock(PrintStream.class);
        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);
        Library library = new Library(books, printStream, dateTimeFormatter);

        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class
        DateTime time = new DateTime();
        
        library.welcome(time);
        
        verifyZeroInteractions(printStream);
    }

    @Test
    @Ignore
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {
        List<String> books = new ArrayList<>();
        PrintStream printStream = mock(PrintStream.class);
        DateTime time = new DateTime();
        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);

        when(dateTimeFormatter.print(time)).thenReturn("");

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);

        // add a verify here
    }

    @Test
    @Ignore
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {

        // implement me
        // then move common test variables into a setup method
    }
}