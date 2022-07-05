/*
 * Copyright (c) 2013-2019 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.app.backoffice.console.presentation;

import eapli.base.app.backoffice.console.presentation.salesclerk.*;
import eapli.base.app.backoffice.console.presentation.salesmanager.SeeReportUI;
import eapli.base.app.backoffice.console.presentation.server.CreateServerUI;
import eapli.base.app.backoffice.console.presentation.warehouseemployee.AssignOrderUI;
import eapli.base.app.backoffice.console.presentation.warehouseemployee.*;
import eapli.base.app.backoffice.console.presentation.salesmanager.CreateQuestionnaireUI;
import eapli.base.app.backoffice.console.presentation.salesmanager.CreateSurveyUI;
import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.Application;
import eapli.base.app.backoffice.console.presentation.authz.AddUserUI;
import eapli.base.app.backoffice.console.presentation.authz.DeactivateUserAction;
import eapli.base.app.backoffice.console.presentation.authz.ListUsersAction;
import eapli.base.app.backoffice.console.presentation.clientuser.AcceptRefuseSignupRequestAction;
import eapli.base.ordermanagement.application.eventhandlers.OrderUpdatedToDeliveredWatchDog;
import eapli.base.ordermanagement.domain.events.UpdatedOrderToDeliveredEvent;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.pubsub.EventDispatcher;
import eapli.framework.infrastructure.pubsub.impl.inprocess.service.InProcessPubSub;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * TODO split this class in more specialized classes for each menu
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu extends AbstractUI {

    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;

    // USERS
    private static final int ADD_USER_OPTION = 1;
    private static final int LIST_USERS_OPTION = 2;
    private static final int DEACTIVATE_USER_OPTION = 3;
    private static final int ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION = 4;

    //SALES CLERK
    private static final int CREATE_CUSTOMER = 1;
    private static final int SPECIFY_PRODUCT = 2;
    private static final int VIEW_CATALOG = 3;
    private static final int CREATE_ORDER = 4;
    private static final int CREATE_CATEGORY = 5;
    private static final int UPDATE_ORDER_TO_RECEIVED = 6;

    // WAREHOUSE EMPLOYEE
    private static final int CONFIGURE_AGV = 1;
    private static final int SET_UP_PLANT = 2;
    private static final int UPDATE_ORDER = 3;
    private static final int ASSIGN_ORDER = 4;
    private static final int ASSIGN_TASK = 5;

    //SALES MANAGER
    private static final int CREATE_QUESTIONNAIRE = 1;
    private static final int CREATE_SURVEY = 2;
    private static final int SEE_REPORT = 3;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int USERS_OPTION = 2;
    private static final int SETTINGS_OPTION = 4;

    //ADMIN
    private static final int OPEN_HTTP_SERVER = 1;

    private static final String SEPARATOR_LABEL = "--------------";

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        final Menu menu = buildMainMenu();
        final MenuRenderer renderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "Base [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Base [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.ADMIN)) {
            final Menu usersMenu = buildUsersMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);
            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.SALES_CLERK)) {
            final Menu salesClerkMenu = buildSalesClerkMenu();
            mainMenu.addSubMenu(USERS_OPTION, salesClerkMenu);
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.WAREHOUSE_EMPLOYEE)) {
            final Menu warehouseEmployeeMenu = buildWarehouseEmployeeMenu();
            mainMenu.addSubMenu(USERS_OPTION, warehouseEmployeeMenu);
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.SALES_MANAGER)) {
            final Menu managerMenu = buildSalesManagerMenu();
            mainMenu.addSubMenu(USERS_OPTION, managerMenu);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }


    private Menu buildAdminSettingsMenu() {
        final Menu menu = new Menu("Settings >");
        menu.addItem(OPEN_HTTP_SERVER, "Open Http Server", new CreateServerUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildUsersMenu() {
        final Menu menu = new Menu("Users >");

        menu.addItem(ADD_USER_OPTION, "Add User", new AddUserUI()::show);
        menu.addItem(LIST_USERS_OPTION, "List all Users", new ListUsersAction());
        menu.addItem(DEACTIVATE_USER_OPTION, "Deactivate User", new DeactivateUserAction());
        menu.addItem(ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION, "Accept/Refuse Signup Request",
                new AcceptRefuseSignupRequestAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildSalesClerkMenu() {
        SystemUser systemUser;
        if (authz.session().isPresent()) {
            systemUser = authz.session().get().authenticatedUser();
        }

        final Menu menu = new Menu("Options >");
        menu.addItem(CREATE_CUSTOMER, "Create Customer", new CreateCustomerUI()::show);
        menu.addItem(SPECIFY_PRODUCT, "Specify a new product", new SpecifyProductUI()::show);
        menu.addItem(VIEW_CATALOG, "View Catalog", new ViewCatalogUI()::show);

        menu.addItem(CREATE_ORDER, "Create an Order", new CreateOrderUI()::show);
        menu.addItem(CREATE_CATEGORY, "Create a Category", new CreateCategoryUI()::show);
        menu.addItem(UPDATE_ORDER_TO_RECEIVED, "Update order to as being delivered", new UpdateOrderToDeliveredUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildSalesManagerMenu() {
        final Menu menu = new Menu("Options >");
        menu.addItem(CREATE_QUESTIONNAIRE, "Create Questionnaire", new CreateQuestionnaireUI()::show);
        menu.addItem(CREATE_SURVEY, "Create Survey", new CreateSurveyUI()::show);
        menu.addItem(SEE_REPORT, "See Report", new SeeReportUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }


    private Menu buildWarehouseEmployeeMenu() {
        final Menu menu = new Menu("Options >");
        menu.addItem(CONFIGURE_AGV, "Configure AGV", new ConfigureAGVUI()::show);
        menu.addItem(SET_UP_PLANT, "Set up the warehouse plant", new SetUpPlantUI()::show);
        menu.addItem(UPDATE_ORDER, "Update order to dispatched for customer delivery", new UpdateOrderUI()::show);
        menu.addItem(ASSIGN_ORDER, "Assign order to an AGV", new AssignOrderUI()::show);
        menu.addItem(ASSIGN_TASK, "Assign order automatically to an AGV", new AssignOrderAutomaticallyUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }
}
