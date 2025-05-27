package com.example.loginapp; // Sesuaikan dengan nama package Anda

public class Task {
    private String id;
    private String title;
    private String details; // Untuk menyimpan tanggal dan waktu
    private boolean completed;

    public Task(String id, String title, String details) {
        this.id = id;
        this.title = title;
        this.details = details;
        this.completed = false; // Defaultnya belum selesai
    }

    // Getter
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public boolean isCompleted() {
        return completed;
    }

    // Setter
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return title; // Ini akan digunakan jika ListView tidak menggunakan cell factory kustom
    }
}

