import java.util.ArrayList;

public class pth_menu {
	// Some text with no user visible actions.
	public String printMenu(String description) {
		return printMenuWithActions(description, null);
	}

	// Some text describing the context around what actions may be taken.
	public String printMenuWithActions(String description, ArrayList<String> actions){
		StringBuilder menu = new StringBuilder();
		menu.append(description)
			.append("\n\n");
		
		// Actions.
		if (actions != null && !actions.isEmpty()) {
			for (int i = 0; i < actions.size(); ++i) {
				menu.append(i+1)
					.append(": ")
					.append(actions.get(i))
					.append('\n');
			}
			menu.append("\n");
		}

		// User input.
		menu.append(": ");
		return menu.toString();
	}

}
