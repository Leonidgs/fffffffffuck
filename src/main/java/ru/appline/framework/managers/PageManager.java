package ru.appline.framework.managers;

import ru.appline.framework.pages.*;

/**
 * @author Arkadiy_Alaverdyan
 * Класс для управления страничками
 */
public class PageManager {

    /**
     * Менеджер страничек
     */
    private static PageManager pageManager;

    /**
     * Стартовая страничка
     */
    private StartPage startPage;

    /**
     * Страничка страхование путешественников
     */
    private ListOfConsoles listOfConsoles;

    /**
     * Страничка выбора полиса или тарифа
     */
    private TariffPage tariffPage;

    /**
     * Страничка оформления полиса страхования
     */
    private RegistrationFormPage registrationFormPage;

    /**
     * Конструктор специально был объявлен как private (singleton паттерн)
     *
     * @see PageManager#getPageManager()
     */
    //Страничка просмотра консоли
    private OpenPsPage psPage;
    //Страничка для работы с игрой
    private ChooseGame gamePage;
    //Для работы с корзиной в финале
    private BasketPage basketPage;

    private PageManager() {
    }

    /**
     * Ленивая инициализация PageManager
     *
     * @return PageManager
     */
    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    /**
     * Ленивая инициализация {@link ru.appline.framework.pages.StartPage}
     *
     * @return StartPage
     */
    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    /**
     * Ленивая инициализация {@link ListOfConsoles}
     *
     * @return ListOfConsoles
     */
    public ListOfConsoles getInsurancePage() {
        if (listOfConsoles == null) {
            listOfConsoles = new ListOfConsoles();
        }
        return listOfConsoles;
    }

    /**
     * Ленивая инициализация {@link TariffPage}
     *
     * @return TariffPage
     */
    public TariffPage getTariffPage() {
        if (tariffPage == null) {
            tariffPage = new TariffPage();
        }
        return tariffPage;
    }

    public OpenPsPage getOpenPsPage() {
        if (psPage == null) {
            psPage = new OpenPsPage();
        }
        return psPage;
    }

    public ChooseGame getOpenGamePage() {
        if (gamePage == null) {
            gamePage = new ChooseGame();
        }
        return gamePage;
    }
    public BasketPage getBasketPage() {
        if (basketPage == null) {
            basketPage = new BasketPage();
        }
        return basketPage;
    }



    /**
     * Ленивая инициализация {@link ru.appline.framework.pages.RegistrationFormPage}
     *
     * @return RegistrationFormPage
     */
    public RegistrationFormPage getRegistrationFormPage() {
        if (registrationFormPage == null) {
            registrationFormPage = new RegistrationFormPage();
        }
        return registrationFormPage;
    }
}
