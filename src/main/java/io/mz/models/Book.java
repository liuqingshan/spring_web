package io.mz.models;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Book {
   private String name;
   private String isbn;
   private double price;

   public Book() {

   }

   public Book(String isbn, String name, double price) {
      this.isbn = isbn;
      this.name = name;
      this.price = price;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;

      if (o == null || getClass() != o.getClass()) return false;

      Book book = (Book) o;

      return new EqualsBuilder()
              .append(isbn, book.isbn)
              .isEquals();
   }

   @Override
   public int hashCode() {
      return new HashCodeBuilder(17, 37)
              .append(isbn)
              .toHashCode();
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getIsbn() {
      return isbn;
   }

   public void setIsbn(String isbn) {
      this.isbn = isbn;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

}
