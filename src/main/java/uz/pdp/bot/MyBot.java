package uz.pdp.bot;
import lombok.Getter;
import lombok.Setter;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import uz.pdp.images.Files1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class MyBot extends TelegramLongPollingBot {



    @Override
    public void onUpdateReceived(Update update) {


        if (update.hasMessage() && update.getMessage().hasText()) {
            String command = update.getMessage().getText();
            if (command.equals("/start")) {
                String message = "Добро пожаловать в мой бот! Вот доступные команды:\n" +
                        "/menu - все товары здесь.\n" +
                        "/help - Отобразить это справочное сообщение.\n" +
                        "/INSTA - нажмите и узнаете что там.";

                sendMessage(update.getMessage().getChatId().toString(), message);
            }
            if (command.equals("/help")) {
                String message = "Вот доступные команды:\n" +
                        "/menu - все товары здесь.\n" +
                        "/help - Отобразить это справочное сообщение.\n" +
                        "/contact - Получить контактную информацию.\n" +
                        "/INSTA - нажмите и узнаете что там. \n"+
                        "напишите /comment потом напишите свой коментарий - Оставить комментарий.";

                sendMessage(update.getMessage().getChatId().toString(), message);
            }
            if (command.equals("/menu")) {

                String message =
                        "Если вы нажмёте /Cars то выйдеть фото машин которых вы можете купить.\n" +
                        "Если хотите купить запчасти для авто \n" +
                        "то вам сюда "+ "\uD83D\uDC49" +" /CarSpareParts .\n"+
                                "/well нажмите чтобы узнать курс валюты \n" +
                        "если вы хотите аксессуары для авто то \uD83D\uDC49 /accessories \n"+
                        "/help - Отобразить справочное сообщение\n";
                sendMessage(update.getMessage().getChatId().toString(), message);
            }


            if (command.equals("/contact")) {
                String message = "Вы можете связаться с владельцем бота по телегарму @BeCool_17";
                sendMessage(update.getMessage().getChatId().toString(), message);
            }


            if (command.startsWith("/comment")) {
                String comment = command.substring("/comment".length()).trim();
                String message = "Спасибо за ваш комментарий: " + comment;

                sendMessage(update.getMessage().getChatId().toString(), message);
            }




/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            if (messageText.equals("/Cars")) {


                InlineKeyboardMarkup markup1 = InlineKeyboardMarkup.builder().
                        keyboardRow(List.of(
                                InlineKeyboardButton.builder().text("Купить")
                                        .url("https://www.lamborghini.com/ru-en/%D0%BC%D0%BE%D0%B4%D0%B5%D0%BB%D0%B8/huracan/huracan-sterrato").build())).build();

                InlineKeyboardMarkup markup2 = InlineKeyboardMarkup.builder().
                        keyboardRow(List.of(
                                InlineKeyboardButton.builder().text("Купить")
                                        .url("https://auto.ru/cars/used/sale/nissan/skyline/1120272692-90d7f3fe/").build())).build();

                InlineKeyboardMarkup markup3 = InlineKeyboardMarkup.builder().
                        keyboardRow(List.of(
                                InlineKeyboardButton.builder().text("Купить")
                                        .url("https://auto.ru/cars/used/sale/bmw/m5/1121267403-6b086ebf/").build())).build();

                InlineKeyboardMarkup markup4 = InlineKeyboardMarkup.builder().
                        keyboardRow(List.of(
                                InlineKeyboardButton.builder().text(" Купить")
                                        .url("https://auto.ru/cars/used/sale/mercedes/cls_klasse/1121350212-bdde671b/").build())).build();




                    SendPhoto sendPhoto1 = new SendPhoto();
                    sendPhoto1.setChatId(chatId);
                    sendPhoto1.setPhoto(Files1.readImage());
                    sendPhoto1.setCaption("ЛАМБОРГИНИ ХУРАКАН\n" +
                            "рабочий объем цилиндров5204 cm3.\n" +
                            "максимальная мощность (КВТ/CV)470/640 кВт/л. с. при 8000 об/мин\n" +
                            "максимальная скорость325 км/ч\n" +
                            "разгон 0–100 км/ч (0–62 мили в час)3,2 с\n" +
                            "Экономия топлива комбинированный цикл*15 mpg.\n\n" +
                            "LAMBORGHINI цена 0$ 100% скидка");
                    sendPhoto1.setReplyMarkup(markup1);




                    SendPhoto sendPhoto2 = new SendPhoto();
                    sendPhoto2.setChatId(chatId);
                    sendPhoto2.setPhoto(Files1.R43());
                    sendPhoto2.setCaption("NISSAN SKYLINE R34\n" +
                            "Мощность–280 лс @ 6800 об./мин.\n" +
                            "Мощность на литр рабочего объема–109 лс/л\n" +
                            "Крутящий момент–392 Нм @ 4400 об./мин.289.12lb.\n" +
                            "-ft.@ 4400 об./мин.\n" +
                            "Компоновка двигателя–переднее, продольное\n\n"+
                            "Nissan Skyline цена 42 562,74$");

                    sendPhoto2.setReplyMarkup(markup2);


                    SendPhoto sendPhoto3 = new SendPhoto();
                    sendPhoto3.setChatId(chatId);
                    sendPhoto3.setPhoto(Files1.BMwM5());
                    sendPhoto3.setCaption("BMW M5 Competition\n" +
                            "Поколение  VI (F90)\n" +
                            "Год выпуска - 2019\n" +
                            "Пробег - 49 000 км\n" +
                            "Кузов - Седан\n" +
                            "Двигатель - 4.4 л / 625 л.с. / Бензин\n\n"+
                            "BMW M5 Competition цена 87 925,65$");


                    sendPhoto3.setReplyMarkup(markup3);


                    SendPhoto sendPhoto4 = new SendPhoto();
                    sendPhoto4.setChatId(chatId);
                    sendPhoto4.setPhoto(Files1.MercedesCls());
                    sendPhoto4.setCaption("Mercedes-Benz CLS\n" +
                            "Поколение - II (C218) Рестайлинг\n" +
                            "Год выпуска -2014\n" +
                            "Пробег - 204 000 км\n" +
                            "Кузов - Седан\n" +
                            "Двигатель - 3.0 л / 333 л.с. / Бензин\n\n"+
                            "Mercedes-Benz CLS цена 35 842,30$");

                    sendPhoto4.setReplyMarkup(markup4);


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


                    try {
                        execute(sendPhoto1);
                        execute(sendPhoto2);
                        execute(sendPhoto3);
                        execute(sendPhoto4);

                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }




                    String message = "Если вы передумали покупать тогда нажмите /menu \n" +
                            "/INSTA - нажмите и узнаете что там.";
                    sendMessage(update.getMessage().getChatId().toString(), message);

                }
            }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


                String messageText = update.getMessage().getText();
                long chatId1 = update.getMessage().getChatId();

                if (messageText.equals("/CarSpareParts")){
                    SendPhoto sendPhoto = new SendPhoto();

                    sendPhoto.setChatId(chatId1);
                    sendPhoto.setPhoto(Files1.SpareParts());
//                    sendPhoto.setCaption();

                    //List<InlineKeyboardButton> row = new ArrayList<>();
                    SendMessage message1 = new SendMessage();
                    List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();



                    List<InlineKeyboardButton> row = new ArrayList<>();
                    InlineKeyboardButton buyButton = new InlineKeyboardButton("         Посмотреть запчасти        ");
                    buyButton.setUrl("https://the-parts.ru/");
                    buyButton.setCallbackData("https://the-parts.ru/");
                    row.add(buyButton);


                    InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                    inlineKeyboardMarkup.setKeyboard(keyboard);

                    keyboard.add(row);

                    message1.setReplyMarkup(inlineKeyboardMarkup);

                    try {
                        execute(sendPhoto);


                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

                    message1.setReplyMarkup(inlineKeyboardMarkup);
                    message1.setChatId(chatId1);
                    message1.setText("     Запчасти на любой автомобиль любой марки в мире.  ");
                    message1.setReplyMarkup(inlineKeyboardMarkup);
                    try {
                        execute(message1);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    String message2 = "Если вы передумали покупать тогда нажмите /menu \n" +
                            "/INSTA - нажмите и узнаете что там. ";
                    sendMessage(update.getMessage().getChatId().toString(), message2);

                }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


                String messageText2 = update.getMessage().getText();
                long chatId = update.getMessage().getChatId();
                if (messageText2.equals("/accessories")){

                    SendPhoto sendPhoto9 = new SendPhoto();

                    sendPhoto9.setChatId(chatId);
                    sendPhoto9.setPhoto(Files1.accessories());
//                    sendPhoto.setCaption();

                    //List<InlineKeyboardButton> row = new ArrayList<>();
                    SendMessage message3 = new SendMessage();
                    List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();



                    List<InlineKeyboardButton> row = new ArrayList<>();
                    InlineKeyboardButton buyButton = new InlineKeyboardButton("      аксессуары для авто  ");
                    buyButton.setUrl("https://b2motor.ru/catalog/accessories");
                    buyButton.setCallbackData("https://b2motor.ru/catalog/accessories");
                    row.add(buyButton);


                    InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                    inlineKeyboardMarkup.setKeyboard(keyboard);

                    keyboard.add(row);

                    message3.setReplyMarkup(inlineKeyboardMarkup);

                    try {
                        execute(sendPhoto9);


                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

                    message3.setReplyMarkup(inlineKeyboardMarkup);
                    message3.setChatId(chatId1);
                    message3.setText("     аксессуары на любой автомобиль , любой марки в мире." +
                                                "         Доставка тоже есть по этому номеру +998979993007");
                    message3.setReplyMarkup(inlineKeyboardMarkup);
                    try {
                        execute(message3);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    String message2 = "Если вы передумали покупать тогда нажмите /menu \n" +
                            "/INSTA - нажмите и узнаете что там. ";
                    sendMessage(update.getMessage().getChatId().toString(), message2);


                }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



                if (messageText.equals("/INSTA")){
                    String messageText1 = update.getMessage().getText();
                    long chatId2 = update.getMessage().getChatId();
                    long chatId3 = update.getMessage().getChatId();
                    SendVideo sendVideo = new SendVideo();
                    SendVideo sendVide1 = new SendVideo();
                    SendMessage message3 = new SendMessage();



                    sendVide1.setChatId(chatId3);
                    sendVide1.setVideo(Files1.BMWMP4());
//                    sendVideo.setCaption("ПОДПИШИТЕСЬ");

                    sendVideo.setChatId(chatId2);
                    sendVideo.setVideo(Files1.miata());

                    List<List<InlineKeyboardButton>> keyboard2 = new ArrayList<>();



                    List<InlineKeyboardButton> row6 = new ArrayList<>();
                    InlineKeyboardButton buyButton9 = new InlineKeyboardButton("         Мой инстаграм        ");
                    buyButton9.setUrl("https://www.instagram.com/becool_mb/#");
                    buyButton9.setCallbackData("https://www.instagram.com/becool_mb/#");
                    row6.add(buyButton9);



                    InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                    inlineKeyboardMarkup.setKeyboard(keyboard2);

                    keyboard2.add(row6);

                    message3.setReplyMarkup(inlineKeyboardMarkup);



                    try {
                    execute(sendVide1);
                    execute(sendVideo);

                    }catch (TelegramApiException e){
                        e.printStackTrace();
                    }
                    message3.setReplyMarkup(inlineKeyboardMarkup);
                    message3.setChatId(chatId2);
                    message3.setText("Выберите видео которая вам понравилась и отправте мне в инстаграм и  " +
                            "я подпишусь в замен вы тоже должны"+
                            "ПОДПИСАТСЯ что бы узнавать обновления \n"+
                            "Телеграм Бота ");
                    message3.setReplyMarkup(inlineKeyboardMarkup);

                    try {
                        execute(message3);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    String message1 = "Если вы передумали тогда нажмите /menu";
                    sendMessage(update.getMessage().getChatId().toString(), message1);

                }



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                if (messageText.equals("/well")) {
                    String currencyRate = getCurrencyRate();
                    sendTextMessage(chatId, "Курс валют: " + currencyRate);
                    String message1 = "Если вы передумали покупать тогда нажмите /menu \n" +
                            "/INSTA - нажмите и узнаете что там.";
                    sendMessage(update.getMessage().getChatId().toString(), message1);
                }


        }

    private void sendTextMessage(long chatId, String text) {


        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);

        try {
            execute(sendMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String getCurrencyRate() {


        String apiUrl = "https://finance.rambler.ru/currencies/USD/ ";

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                return apiUrl;
            } else {
                System.out.println("Ошибка HTTP: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "USD: 1.0, EUR: 0,91 ";
    }






        private void sendMessage (String chatId, String message){

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(chatId);

            sendMessage.setText(message);
            try {
                execute(sendMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        @Override
        public String getBotUsername () {
            return "BUyCar17_bot";
        }

        @Override
        public String getBotToken () {
            return "6854231221:AAE9Vf8ZZv8ANqsmQarITbwTRw9QzXxghnI";
        }



    }
