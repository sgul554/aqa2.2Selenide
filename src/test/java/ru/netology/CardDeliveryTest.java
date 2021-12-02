package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;


class CardDeliveryTest {
    @Test
void shouldOrderTheCardForDelivery(){
        open("http://localhost:9999/");
        $("[data-test-id=city] input").setValue("Москва");
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys. DELETE);
        $("[data-test-id=date] input").setValue(date);
        $("[data-test-id=name] input").setValue("Петр Копатыч");
        $("[data-test-id=phone] input").setValue("+79876543211");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=notification]")
                .shouldBe(Condition.visible, Duration.ofSeconds(5));


    }

}