package nif.spike.a;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;

public class RunInNewClassLoader {

	public static void main(String[] args) throws Exception {
		newInstanceTimer(newClassLoader(), "instance_1");
		newInstanceTimer(newClassLoader(), "instance_2");
		newInstanceTimer(newClassLoader(), "instance_3");
	}

	private static URLClassLoader newClassLoader() throws MalformedURLException, URISyntaxException {
		URL[] urlArray = new URL[] {
				RunInNewClassLoader.class.getProtectionDomain().getCodeSource().getLocation().toURI().toURL() };
		URLClassLoader firstClassloader = new URLClassLoader(urlArray, null);
		return firstClassloader;
	}

	private static void newInstanceTimer(ClassLoader cl, String name) {
		try {
			String className = Timer.class.getCanonicalName();
			Class<?> c = cl.loadClass(className);
			c.getConstructor(String.class).newInstance(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
