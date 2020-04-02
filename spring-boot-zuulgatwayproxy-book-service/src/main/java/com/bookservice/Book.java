package com.bookservice;

public class Book {
        String name;
        String author;

        public Book(String name, String author) {
            super();
            this.name = name;
            this.author=author;
        }

        public String getName() {
            return name;
        }

        public String getAuthor() {
            return author;
        }

    }
