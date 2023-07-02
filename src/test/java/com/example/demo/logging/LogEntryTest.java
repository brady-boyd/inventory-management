package com.example.demo.logging;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogEntryTest {

    private LogEntry logEntry;

    @BeforeEach
    public void setUp() {
        logEntry = new LogEntry("2023-06-09T00:00:00Z", "User logged in", "INFO", "Thread-1", "com.example.demo");
    }

    @Test
    public void testTimestamp() {
        assertEquals("2023-06-09T00:00:00Z", logEntry.getTimestamp());
    }

    @Test
    public void testUserAction() {
        assertEquals("User logged in", logEntry.getUserAction());
    }

    @Test
    public void testLevel() {
        assertEquals("INFO", logEntry.getLevel());
    }

    @Test
    public void testThread() {
        assertEquals("Thread-1", logEntry.getThread());
    }

    @Test
    public void testLogger() {
        assertEquals("com.example.demo", logEntry.getLogger());
    }
}
