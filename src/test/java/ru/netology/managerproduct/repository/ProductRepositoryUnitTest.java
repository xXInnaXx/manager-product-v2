package ru.netology.managerproduct.repository;

import org.junit.jupiter.api.Test;
import ru.netology.managerproduct.domain.Book;
import ru.netology.managerproduct.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryUnitTest {

    private static final String TEST = "test";
    private static final int ID = 1;

    @Test
    void shouldSaveProduct() {
        ProductRepository productRepository = new ProductRepository();
        Book expected = new Book(ID, TEST, ID, TEST);
        productRepository.save(expected);

        Product actual = productRepository.findById(ID);
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindNothingIfIdIsIncorrect() {
        ProductRepository productRepository = new ProductRepository();
        Book expected = new Book(ID, TEST, ID, TEST);
        productRepository.save(expected);

        Product actual = productRepository.findById(2);
        assertNull(actual);
    }

    @Test
    void shouldFindNothingIfWasNotSaved() {
        ProductRepository productRepository = new ProductRepository();

        Product actual = productRepository.findById(ID);
        assertNull(actual);
    }

    @Test
    void shouldRemoveById() {
        ProductRepository productRepository = new ProductRepository();

        Book book = new Book(ID, TEST, ID, TEST);
        Book secondBook = new Book(2, TEST, ID, TEST);
        productRepository.save(book);
        productRepository.save(secondBook);

        Product found = productRepository.findById(ID);
        productRepository.removeById(ID);

        Product notFound = productRepository.findById(ID);

        assertNotNull(found);
        assertEquals(productRepository.findById(2), secondBook);
        assertNull(notFound);
    }
}