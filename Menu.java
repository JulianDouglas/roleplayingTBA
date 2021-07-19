import java.util.Arrays;
import java.util.List;
import java.lang.System;

public class Menu {
	public static PlayerInputAction printMenuAndGetPlayerInput(
			String description, String[] actions, pth_input playerInput) {
		printMenu(description, actions);
		return interpretPlayerInput(Arrays.asList(actions), playerInput);
	}

	// Some text with no user visible actions.
	public static void printMenu(String description) {
		printMenu(description, (List<String>)null);
	}

	// Some text describing the context around what actions may be taken.
	public static void printMenu(String description, List<String> actions) {
		System.out.print(buildMenu(description, actions));
	}
	public static void printMenu(String description, String[] actions) {
		printMenu(description, Arrays.asList(actions));
	}

	public static String buildMenu(String description, List<String> actions) {
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

	public static class PlayerInputAction {
		// The raw player input if any special actions need handling.
		String playerInput;

		// -1 if no found action.
		int actionIndex;

		public PlayerInputAction(String playerInput) {
			this.playerInput = playerInput;
			this.actionIndex = -1;
		}
		public PlayerInputAction(String playerInput, int actionIndex) {
			this.playerInput = playerInput;
			this.actionIndex = actionIndex;
		}
	}

	// Looks for a corresponding action based on the player input.
	public static PlayerInputAction interpretPlayerInput(List<String> actions, pth_input playerInput) {
		String input = playerInput.pth_RetrieveInput();
		for (int actionIndex = 0; actionIndex < actions.size(); ++actionIndex) {
			if (actions.get(actionIndex).equalsIgnoreCase(input)) {
				return new PlayerInputAction(input, actionIndex);
			}
		}
		return new PlayerInputAction(input);
	}
}
