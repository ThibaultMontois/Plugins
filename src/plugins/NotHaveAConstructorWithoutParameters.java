package plugins;

public class NotHaveAConstructorWithoutParameters implements Plugin {

	private NotHaveAConstructorWithoutParameters() {
	}

	@Override
	public String transform(String input) {
		return "I'm not a Plugin";
	}

	@Override
	public String getLabel() {
		return "Not a Plugin";
	}

}
