package com.example.accessingdatamysql.utils;

import java.util.Collection;

import org.springframework.data.domain.Page;

public class ResponsePage<T> {
  private Collection<T> items;

  private int currentPage;

  private long totalItems;

  private int totalPages;

  public ResponsePage() {
  }

  public ResponsePage(Page<T> page) {
    this.items = page.getContent();
    this.currentPage = page.getNumber();
    this.totalItems = page.getTotalElements();
    this.totalPages = page.getTotalPages();
  }

  public Collection<T> getItems() {
    return this.items;
  }

  public void setItems(Collection<T> items) {
    this.items = items;
  }

  public int getCurrentPage() {
    return this.currentPage;
  }

  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
  }

  public long getTotalItems() {
    return this.totalItems;
  }

  public void setTotalItems(long totalItems) {
    this.totalItems = totalItems;
  }

  public int getTotalPages() {
    return this.totalPages;
  }

  public void setTotalPages(int totalPages) {
    this.totalPages = totalPages;
  }
}
