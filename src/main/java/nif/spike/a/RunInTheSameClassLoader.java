package nif.spike.a;

public class RunInTheSameClassLoader {

	public static void main(String[] args) throws Exception {
		Timer a = newInstanceTimer("instance_1");
		Timer b = newInstanceTimer("instance_2");
		Timer c = newInstanceTimer("instance_3");
	}

	private static Timer newInstanceTimer(String name) {
		return new Timer(name);

	}

}
