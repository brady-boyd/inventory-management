package com.example.demo.logging;

public class LogEntry {
    private String timestamp;
    private String userAction;
    private String level;
    private String thread;
    private String logger;

    public LogEntry(String timestamp, String userAction, String level, String thread, String logger) {
        this.timestamp = timestamp;
        this.userAction = userAction;
        this.level = level;
        this.thread = thread;
        this.logger = logger;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getUserAction() {
        return userAction;
    }

    public String getLevel() {
        return level;
    }

    public String getThread() {
        return thread;
    }

    public String getLogger() {
        return logger;
    }
}
