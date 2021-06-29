package ru.training.at.hw5.tests.steps;

import ru.training.at.hw5.context.TestContext;
import ru.training.at.hw5.pages.DifferentElementsPage;
import ru.training.at.hw5.pages.HomePage;
import ru.training.at.hw5.pages.LoggedInHomePage;
import ru.training.at.hw5.pages.UserTablePage;

public abstract class AbstractStep {

    protected HomePage homePage;
    protected LoggedInHomePage loggedInHomePage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;

    protected AbstractStep() {
        loggedInHomePage = new LoggedInHomePage(TestContext.getInstance().getDriver());
        differentElementsPage = new DifferentElementsPage(TestContext.getInstance().getDriver());
        userTablePage = new UserTablePage(TestContext.getInstance().getDriver());
    }
}
