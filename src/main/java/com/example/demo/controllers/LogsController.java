package com.example.demo.controllers;

import com.example.demo.logging.LogEntry;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class LogsController {
    private final String filePath = "logs/app.log";

    @GetMapping("/logs")
    public String logs(Model model) {
        List<LogEntry> logEntries = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            Gson gson = new Gson();
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("{\"timestamp\":")) { // change condition here
                    JsonObject jsonObject = gson.fromJson(line, JsonObject.class);

                    String timestamp = jsonObject.get("timestamp") != null ? jsonObject.get("timestamp").getAsString() : "";
                    String userAction = jsonObject.get("User Action") != null ? jsonObject.get("User Action").getAsString() : "";
                    String level = jsonObject.get("level") != null ? jsonObject.get("level").getAsString() : "";
                    String thread = jsonObject.get("thread") != null ? jsonObject.get("thread").getAsString() : "";
                    String logger = jsonObject.get("logger") != null ? jsonObject.get("logger").getAsString() : "";

                    LogEntry logEntry = new LogEntry(timestamp, userAction, level, thread, logger);
                    logEntries.add(logEntry);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        model.addAttribute("logEntries", logEntries);
        return "logs";
    }
}

