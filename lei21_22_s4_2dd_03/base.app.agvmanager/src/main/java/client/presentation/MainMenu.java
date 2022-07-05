package client.presentation;

import eapli.base.Application;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

public class MainMenu extends AbstractUI {

    private static final int EXIT_OPTION = 0;

    private static final int CONNECT = 1;

    private static final String SEPARATOR_LABEL = "--------------";

    @Override
    protected boolean doShow() {
        final Menu menu = new Menu("Options >");
        final MenuRenderer renderer;
        menu.addItem(CONNECT, "Connection with the Server", new ConnectUI()::show);
        if (!Application.settings().isMenuLayoutHorizontal()) {
            menu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }
        menu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Exiting the program"));

        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }

    @Override
    public String headline() {
        return "Digital Twin Client App";
    }
}
