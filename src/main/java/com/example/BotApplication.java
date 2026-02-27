package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@SpringBootApplication
public class BotApplication {
    public static void main(String[] args) {
        SpringApplication.run(BotApplication.class, args);
    }
}

@Component
class SimpleBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() { return "@eskertiwshiiibot"; }
    @Override
    public String getBotToken() { return "8749815758:AAE2q8kC0-2cEAD3Vr09ehlsB07GaDlS4mY"; }
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText("Salom! Men Render-da ishlayapman!");
            try { execute(message); } catch (TelegramApiException e) { e.printStackTrace(); }
        }
    }
}
