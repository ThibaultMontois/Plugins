package plugins;

public class ToLowerCase implements Plugin {

	@Override
	public String transform(String input) {
		return input.toLowerCase();
	}

	@Override
	public String getLabel() {
		return "To Lower Case";
	}

}
