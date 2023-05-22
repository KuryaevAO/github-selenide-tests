package com.kuryaevao.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAll() {

        Configuration.startMaximized = true;
        Configuration.browserSize = "1920×1080";
        Configuration.pageLoadTimeout = 600000;
        Configuration.pageLoadStrategy = "eager";
    }
}
