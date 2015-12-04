package plugins;

public class APlugin implements Plugin {

	@Override
	public String transform(String input) {
		return "I'm a Plugin";
	}

	@Override
	public String getLabel() {
		return "A Plugin";
	}

}
