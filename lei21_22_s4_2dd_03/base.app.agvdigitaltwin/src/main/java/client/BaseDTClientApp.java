package client;


import client.presentation.MainMenu;

public final class BaseDTClientApp {

    /**
     * Empty constructor is private to avoid instantiation of this class.
     */
    public BaseDTClientApp() {
    }

    public static void main(String[] args) {
        System.out.println("==============================================================");
        System.out.println("This App was created to communicate to the Digital Twin Server");
        System.out.println("==============================================================");

        new MainMenu().mainLoop();
    }
}