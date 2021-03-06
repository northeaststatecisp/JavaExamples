package edu.northeaststate.cs2.examples.alexandria.ui.menu.commands.mainmenu;

import edu.northeaststate.cs2.examples.alexandria.models.Library;
import edu.northeaststate.cs2.examples.alexandria.ui.menu.ConsoleMenu;
import edu.northeaststate.cs2.examples.alexandria.ui.menu.commands.MenuCommand;
import edu.northeaststate.cs2.examples.alexandria.ui.menu.commands.additems.*;

public class AddItems implements MenuCommand {
    private final String COMMAND_NAME = "Add Item";
    private Library library;

    public AddItems(Library library) {
        this.library = library;
    }

    @Override
    public void execute() {
        ConsoleMenu menu = new ConsoleMenu(COMMAND_NAME);

        menu.addCommand(new AddBook(this.library));
        menu.addCommand(new AddVHS(this.library));
        menu.addCommand(new AddLaserDisc(this.library));
        menu.addCommand(new AddDVD(this.library));
        menu.addCommand(new AddBluRay(this.library));
        menu.addCommand(new AddJournal(this.library));
        menu.addCommand(new AddNewspaper(this.library));
        menu.addCommand(new AddMagazine(this.library));

        menu.addCommand(new Home());

        menu.show();
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }
}
