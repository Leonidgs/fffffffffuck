package ru.appline.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @author Arkadiy_Alaverdyan
 * Класс описывающий страничку страхование путешественников
 */
//Переименовать в страничка консолей
//a[contains(@href,'040b40013e6b3332') and @data-role='clamped-link'] - хpath для консоли
public class ListOfConsoles extends BasePage {

    @FindBy(xpath = "//h1[@class='uc-form__title']")
    private WebElement pageTitle;

    @FindBy(xpath = "//a[@class='ui-link' and @href='/product/08eaab57cae91b80/igrovaa-konsol-playstation-4-slim-black-1-tb--3-igry/']")
    private WebElement choosePs;



    @FindBy(xpath = "//div[@class='uc-full__item']")
    private List<WebElement> listInsurance;

    @FindBy(xpath = "//a[@class='ui-link ui-link_gray_dark']")
    private WebElement pagePsTitle;

    /**
     * Проверка открытия страницы, путём проверки title страницы
     *
     * @return ListOfConsoles - т.е. остаемся на этой странице
     */
//    @Step("Проверка открытия страницы ListOfConsoles")
   /* public ListOfConsoles checkOpenInsurancePage() {
        Assert.assertEquals("Заголовок отсутствует/не соответствует требуемому",
                "Страхование", pageTitle.getText());
        return this;
    }*/
    public ListOfConsoles checkOpenPlayStationsPage() {
        Assert.assertEquals("Заголовок отсутствует/не соответствует требуемому",
                "Консоли PlayStation", pagePsTitle.getText());
        return this;
    }


    /**
     * Выбрать тип страхования по имени
     *
     * //@param ps - наименование типа страховки
     * @return TariffPage - т.е. переходим на страницу {@link TariffPage}
     */
//    @Step("Выбрать тип страхования '{insuranceName}'")
   /* public TariffPage selectTypeInsuranceByName(String insuranceName) {
        for (WebElement insuranceItem : listInsurance) {
            WebElement title = insuranceItem.findElement(By.xpath(".//h3[@class='uc-full__header']"));
            if (title.getText().trim().equalsIgnoreCase(insuranceName)) {
                WebElement buttonCheckoutOnline = insuranceItem.findElement(By.xpath(".//b[.='Оформить онлайн']/.."));
                scrollToElementJs(buttonCheckoutOnline);
                elementToBeClickable(buttonCheckoutOnline).click();
                return app.getTariffPage();
            }
        }
        Assert.fail("Тип страховки '" + insuranceName + "' не было найдено на стартовой странице!");
        return app.getTariffPage();
    }*/
    public OpenPsPage selectPS4() {
        elementToBeClickable(choosePs).click();
        //Assert.fail("Тип страховки '" + ps + "' не было найдено на стартовой странице!");
        return app.getOpenPsPage();
    }

}
