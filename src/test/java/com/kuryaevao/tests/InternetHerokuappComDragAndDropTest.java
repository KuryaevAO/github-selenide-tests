package com.kuryaevao.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class InternetHerokuappComDragAndDropTest extends TestBase {

    @Test
    void dragAndDropTest() {

        SelenideElement squareA = $("#column-a");
        SelenideElement squareB = $("#column-b");

        open("https://the-internet.herokuapp.com/drag_and_drop");//открываем страницу
        sleep(2000);//небольшая задержка чтобы увидеть изначальное расположение блоков
        (squareA).dragAndDropTo(squareB);//переносим блок А на блок Б
        sleep(2000);//небольшая задержка чтобы увидеть финальное расположение блоков
        squareA.shouldHave(Condition.text("B"));//сверяем что А стал Б
        squareB.shouldHave(Condition.text("A"));//сверяем что Б стал А
    }
}
