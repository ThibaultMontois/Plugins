package plugins;

public class ToUpperCase implements Plugin {

	@Override
	public String transform(String input) {
		return input.toUpperCase();
	}

	@Override
	public String getLabel() {
		return "To Upper Case";
	}

}
