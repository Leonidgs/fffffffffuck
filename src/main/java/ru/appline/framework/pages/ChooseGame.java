package ru.appline.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChooseGame extends BasePage{

    protected static Integer gameCost = 0;
    protected static Integer totalCost = 0;

    @FindBy(xpath = "//a[@data-role='credit-calculator-open-link']")
    private WebElement getCostGame;

    //span[@class='cart-link__badge']
    @FindBy(xpath = "//span[@class='cart-link__price']")
    private WebElement costBacket;

    //Запоминаем цену игры
    public ChooseGame rememberCost() {
        System.out.println("Стоимость игры " + getCostGame.getAttribute("data-price"));
        gameCost = Integer.parseInt(getCostGame.getAttribute("data-price"));
        return this;
    }
    //Нажимаем купить
    public ChooseGame buyProduct() {
        app.getOpenPsPage().buyProduct();
        return this;
    }

    public ChooseGame checkCostBacket() {
        //Добавляем пробел
        Integer counter = OpenPsPage.afterCost + gameCost;
        String a = counter.toString();
        String b = a.substring(0,2);
        String c = a.substring(2,5);
        String strokaForAttributeToBe = b + " " + c;
        if (attributeToBe(costBacket, "outerText", strokaForAttributeToBe)) {
            System.out.println(totalCost = Integer.parseInt(costBacket.getText().replaceAll(" ", "")));
            return this;
        }
        Assert.fail("Некорректная суммка корзины");
        return this;
    }
    //Переходим в корзину
    public BasketPage clickOnBasket() {
        elementToBeClickable(costBacket).click();
        return app.getBasketPage();
    }
}
