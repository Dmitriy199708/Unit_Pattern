package ru.netology.selenium.patterns.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.netology.selenium.patterns.data.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationCard {

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    @DisplayName("Should successful plan and replan meeting")
    void shouldSuccessfulPlanAndReplanMeetin() {
        open("http://localhost:9999");
        DataGenerator.UserInfo validUser = DataGenerator.Registration.generateUser("ru");
        int daysToAddForFirstMeeting = 4;
        String firstMeetingDate = DataGenerator.generateDate(daysToAddForFirstMeeting);
        int daysToAddForSecondMeeting = 7;
        String secondMeetingDate = DataGenerator.generateDate(daysToAddForSecondMeeting);

        $x("//span[@data-test-id='city']//input").setValue(validUser.getCity());
        $x("//span[@data-test-id='date']//input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME, Keys.DELETE));
        $x("//span[@data-test-id='date']//input").setValue(firstMeetingDate);
        $x("//span[@data-test-id='name']//input").setValue(validUser.getName());
        $x("//span[@data-test-id='phone']//input").setValue(validUser.getPhone());
        $x("//label[@data-test-id='agreement']").click();
        $x("//span[@class='button__text']").click();
        $x("//div[@data-test-id= 'success-notification'] //div[@class='notification__title']")
                .shouldBe(visible, Duration.ofSeconds(15));
        $x("//div[@data-test-id= 'success-notification'] //div[@class='notification__content']")
                .shouldHave(exactText("Встреча успешно забронирована на " + firstMeetingDate))
                .shouldBe(visible);
        $x("//span[@data-test-id='date']//input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME, Keys.DELETE));
        $x("//span[@data-test-id='date']//input").setValue(firstMeetingDate);
        $x("//span[@class='button__text']").click();
        $x("//div[@data-test-id= 'replan-notification'] //div[@class='notification__title']")
                .shouldBe(visible, Duration.ofSeconds(15));
        $x("//div[@data-test-id= 'replan-notification'] //div[@class='notification__content']")
                .shouldHave(exactText("У вас уже запланирована встреча на другую дату. Перепланировать?" + firstMeetingDate))
                .shouldBe(visible);
    }
//    @Test
//    void shouldRegisterByAccountNumberDOMModification() {
//        DataGenerator.UserInfo validUser = DataGenerator.Registration.generateUser("ru");
//        int daysToAddForFirstMeeting = 4;
//        String firstMeetingDate = DataGenerator.generateDate(daysToAddForFirstMeeting);
//        int daysToAddForSecondMeeting = 7;
//        String secondMeetingDate = DataGenerator.generateDate(daysToAddForSecondMeeting);
//        $("[data-test-id=city] input").setValue(validUser.getCity());
//        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME, Keys.DELETE));
//        $("[data-test-id=date] input").setValue(firstMeetingDate);
//        $("[data-test-id=name] input").setValue(validUser.getName());
//        $("[data-test-id=phone] input").setValue(validUser.getPhone());
//        $x("//label[@data-test-id='agreement']").click();
//        $x("//span[@class='button__text']").click();
//        $("[data-test-id='success-notification'] .notification__title")
//                .shouldBe(visible, Duration.ofSeconds(15))
//                .shouldBe(exactText("Успешно!"));
//        $("[data-test-id='success-notification'] .notification__content")
//                .shouldBe(visible)
//                .shouldBe(exactText("Встреча успешно забронирована на " + firstMeetingDate));
//    }
//    @Test
//    void successfulUserRegistrationOnTheSelectedDate() {
//        $x("//span[@data-test-id='city']//input").setValue("Москва");
//        $x("//span[@data-test-id='date']//input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME, Keys.DELETE));
//        String date = ("22.01.2024");
//        $x("//span[@data-test-id='date']//input").setValue(date);
//        $x("//span[@data-test-id='name']//input").setValue("Иванов-Иванович Иван");
//        $x("//span[@data-test-id='phone']//input").setValue("+79200077999");
//        $x("//label[@data-test-id='agreement']").click();
//        $x("//span[@class='button__text']").click();
//        $x("//div[@class='notification__content']")
//                .shouldBe(Condition.visible, Duration.ofSeconds(15))
//                .shouldBe(Condition.exactText("Встреча успешно забронирована на " + date));
//    }
//
//    @Test
//    void successfulUserRegistrationOnTheSelectedDateFromTheCalendar() {
//        $x("//span[@data-test-id='city']//input").setValue("Москва");
//        $x("//span[@data-test-id='date']//input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME, Keys.DELETE));
//        $x("//span[@data-test-id='date'] //span[@class='icon-button__content']").click();
//        $x("//td[@class='calendar__day' and text()='17']").click();
//        String data = $x("//span[@data-test-id='date'] //input[@type='tel']").val();
//        $x("//span[@data-test-id='name']//input").setValue("Иванов-Иванович Иван");
//        $x("//span[@data-test-id='phone']//input").setValue("+79200077999");
//        $x("//label[@data-test-id='agreement']").click();
//        $x("//span[@class='button__text']").click();
//        $x("//div[@class='notification__content']")
//                .shouldBe(Condition.visible, Duration.ofSeconds(15))
//                .shouldBe(Condition.exactText("Встреча успешно забронирована на " + data));
//    }
}


