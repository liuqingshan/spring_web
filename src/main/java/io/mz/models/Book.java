package io.mz.models;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Book {

   @NotNull
   @Size(min=1, max=20)
   private String name;

   @NotNull
   @Size(min=10, max=20)
   private String isbn;

   @NotNull
   @NumberFormat(style = NumberFormat.Style.CURRENCY)
   @Digits(integer = 8, fraction = 2)
   private double price = 0;

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
