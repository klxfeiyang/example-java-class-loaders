package nif.spike.a;

public class RunInTheSameClassLoader {

	public static void main(String[] args) throws Exception {
		newInstanceTimer("instance_1");
		newInstanceTimer("instance_2");
		newInstanceTimer("instance_3");
	}

	private static void newInstanceTimer(String name) {
		new Timer(name);

	}

}
