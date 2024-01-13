package ru.netology.selenium.patterns.data;


import com.github.javafaker.Faker;
import ru.netology.selenium.patterns.User.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

        public class DataGenerator {

            static {
                new Faker(new Locale("ru"));
            }

            private DataGenerator() {
            }

            public static class Registration {
                private Registration() {
                }

                public static User generateUser() {
                    return new User(generateCity(), generateDate(3), generateName(), generatePhone());
                }

                public static String generateCity() {
                    String[] cities = new String[]{"Абакан",
                            "Анадырь", "Архангельск", "Астрахань", "Барнаул", "Белгород", "Биробиджан", "Благовещенск",
                            "Брянск", "Великий Новгород", "Владивосток", "Владикавказ", "Владимир", "Волгоград", "Вологда", "Воронеж",
                            "Гатчина", "Горно-Алтайск", "Грозный", "Екатеринбург", "Иваново", "Ижевск", "Иркутск", "Йошкар-Ола",
                            "Казань", "Калининград", "Калуга", "Кемерово", "Киров", "Кострома", "Красногорск", "Краснодар", "Красноярск", "Курган",
                            "Курск", "Кызыл", "Липецк", "Магадан", "Магас", "Майкоп", "Махачкала", "Москва", "Мурманск", "Нальчик",
                            "Нарьян-Мар", "Нижний Новгород", "Новосибирск", "Омск", "Орёл", "Оренбург",
                            "Пенза", "Пермь", "Петрозаводск", "Петропавловск-Камчатский",
                            "Псков", "Ростов-на-Дону", "Рязань", "Салехард", "Самара", "Санкт-Петербург", "Санкт-Петербург",
                            "Саранск", "Саратов", "Севастополь", "Симферополь", "Смоленск", "Ставрополь", "Сыктывкар", "Тамбов",
                            "Тверь", "Томск", "Тула", "Тюмень", "Улан-Удэ", "Ульяновск", "Уфа", "Хабаровск", "Ханты-Мансийск", "Чебоксары",
                            "Челябинск", "Черкесск", "Чита", "Элиста", "Южно-Сахалинск", "Якутск", "Ярославль"};
                    int itemIndex = (int) (Math.random() * cities.length);
                    return cities[itemIndex];
                }

                public static String generateDate(int daysToAdd) {
                    return LocalDate.now().plusDays(daysToAdd).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                }

                public static String generateName() {
                    Faker faker = new Faker(new Locale("ru"));
                    AtomicReference<String> randomName = new AtomicReference<>(faker.name().firstName() + " " + faker.name().lastName());
                    return randomName.get();
                }

                public static String generatePhone() {
                    Faker faker = new Faker(new Locale("ru"));
                    return faker.phoneNumber().phoneNumber();
                }
            }

        }