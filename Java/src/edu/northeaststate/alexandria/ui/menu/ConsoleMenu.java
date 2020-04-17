package edu.northeaststate.alexandria.ui.menu;

import edu.northeaststate.alexandria.ui.menu.commands.MenuCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleMenu {
    private String menuHeader;
    private HashMap<Integer, MenuCommand> mapCommands = new HashMap<>();

    public ConsoleMenu(String menuHeader) {
        this.menuHeader = menuHeader;
    }

    public void addCommand(MenuCommand menuItem) {
        this.mapCommands.put(mapCommands.size() + 1, menuItem);
    }

    public void show() {
        Scanner keyboard = new Scanner(System.in);

        MenuCommand c;

        do {
            System.out.println(this.menuHeader);

            // Using for-each loop
            for (Map.Entry mapElement : mapCommands.entrySet()) {
                int key = (int) mapElement.getKey();
                c = (MenuCommand) mapElement.getValue();

                System.out.println(key + ". " + c.getCommandName());
            }

            System.out.print("Chose a number and press enter: ");
            int input = keyboard.nextInt();

            while (!mapCommands.containsKey(input)) {
                System.out.println("Invalid choice. Chose a number and press enter: ");
                input = keyboard.nextInt();
            }

            //Kludge alert
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }

            c = mapCommands.get(input);

            c.execute();
        } while (!c.isExit());
    }
}
