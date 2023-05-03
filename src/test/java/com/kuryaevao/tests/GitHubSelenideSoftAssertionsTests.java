package com.kuryaevao.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubSelenideSoftAssertionsTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.browserSize = "3840×2160";
        Configuration.pageLoadTimeout = 600000;
    }

    @Test
    void softAssertionsShouldHaveJUnit5Examples() {

        open("https://github.com/selenide/selenide");//открывает страничку Selenide на GitHub
        $("#wiki-tab").click();// переход на страницу Wiki
        $(byClassName("markdown-body")).$("ul").$$("li a").findBy(text("Soft assertions")).shouldBe(visible);//проверка наличия Soft assertions
        $(byClassName("markdown-body")).$("ul").$$("li a").findBy(text("Soft assertions")).click();// переход в Soft assertions
        $(byClassName("markdown-body")).$("ol").$$("li").findBy(text("JUnit5 extension")).shouldBe(visible);// проверка наличия примера JUnit5 extension
        System.out.println($(byClassName("markdown-body")).$$(byClassName("highlight")));
        $(byClassName("markdown-body")).$$(byClassName("highlight")).findBy(text("public class Tests {\n" +
                "  @Test\n" +
                "  public void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }")).shouldBe(visible);// проверка наличия примера кода JUnit5
    }
}
