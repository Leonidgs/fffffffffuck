package ru.appline.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @author Arkadiy_Alaverdyan
 * Стартовая страница приложения
 */
public class StartPage extends BasePage {

    @FindBy(xpath = "//ul[contains(@class,'kitt-top-menu__list')]//a[@aria-label and @role='button']")
    private List<WebElement> menuBaseList;

    @FindBy(xpath = "//*[@placeholder='Поиск по сайту']")
    private WebElement search;

    @FindBy(xpath = "//*[@class='ui-link presearch__suggest']")
    private List<WebElement> listofThing;


    @FindBy(xpath = "//a[contains(@class,'kitt-top-menu__link_second')]")
    private List<WebElement> menuSubList;

    /**
     * Функция наведения мыши на любой пункт меню
     *
     * //@param nameBaseMenu - наименование меню
     * @return StartPage - т.е. остаемся на этой странице
     */

    //outerText: "playstation 4 slim black 1 tb"
    //Search on DNS
    public StartPage searchMeth(String thing) {
        if (elementToBeClickable(search).equals(search)) {
            search.sendKeys(thing);
            return this;
        }
        Assert.fail("Меню '" + "' не было найдено на стартовой странице!");
        return this;
    }
    public ListOfConsoles selectThing(String nameThing) {

        for (WebElement menuItem : listofThing) {
            if (menuItem.getAttribute("outerText").equalsIgnoreCase(nameThing)) {
                elementToBeVisible(menuItem);
                elementToBeClickable(menuItem).click();
                return app.getInsurancePage().checkOpenPlayStationsPage();
            }
            System.out.println(menuItem.getAttribute("outerText"));
        }
        Assert.fail(nameThing + "' не была найдена в поиске!");
        return app.getInsurancePage();
    }


/*//    @Step("Переход в главное меню {nameBaseMenu}")
    public StartPage selectBaseMenu(String nameBaseMenu) throws InterruptedException {
        for (WebElement menuItem : menuBaseList) {
            if (menuItem.getText().trim().equalsIgnoreCase(nameBaseMenu)) {
                elementToBeClickable(menuItem).click();

                return this;

            }
        }
        Assert.fail("Меню '" + nameBaseMenu + "' не было найдено на стартовой странице!");
        return this;
    }

    *//**
     * Функция клика на любое подменю
     *
     * @param nameSubMenu - наименование подменю
     * @return ListOfConsoles - т.е. переходим на страницу {@link ListOfConsoles}
     *//*
//    @Step("Выбираем подменю {nameSubMenu}")
    public ListOfConsoles selectSubMenu(String nameSubMenu) {
        for (WebElement menuItem : menuSubList) {
            if (menuItem.getText().equalsIgnoreCase(nameSubMenu)) {
                elementToBeClickable(menuItem).click();
                return app.getInsurancePage().checkOpenInsurancePage();
            }
        }
        Assert.fail("Подменю '" + nameSubMenu + "' не было найдено на стартовой странице!");
        return app.getInsurancePage();
    }*/


}
