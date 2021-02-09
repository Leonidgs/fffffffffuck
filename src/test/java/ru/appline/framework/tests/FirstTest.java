package ru.appline.framework.tests;

import org.junit.Test;
import ru.appline.framework.basetestsclass.BaseTests;

public class FirstTest extends BaseTests {

    @Test
    public void startTest() {
        app.getStartPage()
                //.searchMeth("playstation 4 slim balck")
                .searchMeth("playstation 4")
                //.selectThing("playstation 4 slim black 1 tb")
                .selectThing("playstation 4")
                .selectPS4()
                .clickGuarantee()
                .selectGuarantee("2 года")
                .buyProduct()
                .searchGame("Detroit")
                .rememberCost()
                .buyProduct()
                .checkCostBacket()
                .clickOnBasket()
                .checkGuaranteeType()
                .checkCostOfProducts()
                .dltProductInCartByName("Игра Detroit: Стать человеком (PS4)")
                .checkDltGameFromBasket("Игра Detroit: Стать человеком (PS4)")
                .checkCostBasketAfterDlt("35 399")
                .enhanceQuantityProduct()
                .costConsole()
                .totalAmountBasket("106 197 ₽");
                //.dltProductInCartByName("Игра Detroit: Стать человеком (PS4)");
                //.selectSubMenu("Перейти в каталог")
                //.selectTypeInsuranceByName("Страхование для путешественников")
/*               .selectTariffMin()
                .clickBtnArrange()
                .fillField("Застрахованные - Фамилия", "Privet")
                .fillField("Застрахованные - Имя", "Адам")
                .fillField("Застрахованные - Дата рождения", "12.06.1990")
                .fillField("Страхователь - Фамилия", "Петров")
                .fillField("Страхователь - Имя", "Вася")
                .fillField("Страхователь - Отчество", "Петрович")
                .fillField("Страхователь - Дата рождения", "16.07.1980")
                .fillField("Страхователь - Серия паспорта", "4510")
                .fillField("Страхователь - Номер паспорта", "745602")
                .fillField("Страхователь - Дата выдачи", "16.09.2019")
                .fillField("Страхователь - Кем выдан", "Кем-то")
                .clickBtnContinue()
                .checkErrorMessageAtField("Контакты - Мобильный телефон", "Поле не заполнено.")
                .checkErrorMessageAtField("Контакты - Электронная почта", "Поле не заполнено.")
                .checkErrorMessageAtField("Контакты - Повтор электронной почты", "Поле не заполнено.")
                .checkErrorMessageAlert("При заполнении данных произошла ошибка");*/
    }
}
