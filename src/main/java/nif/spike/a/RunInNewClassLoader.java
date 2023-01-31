package nif.spike.a;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;

public class RunInNewClassLoader {

	public static void main(String[] args) throws Exception {
		Timer a = newInstanceTimer(newClassLoader(), "instance_1");
		Timer b = newInstanceTimer(newClassLoader(), "instance_2");
		Timer c = newInstanceTimer(newClassLoader(), "instance_3");
	}

	private static URLClassLoader newClassLoader() throws MalformedURLException, URISyntaxException {
		URL[] urlArray = new URL[] {
				RunInNewClassLoader.class.getProtectionDomain().getCodeSource().getLocation().toURI().toURL() };
		URLClassLoader firstClassloader = new URLClassLoader(urlArray, null);
		return firstClassloader;
	}

	private static Timer newInstanceTimer(ClassLoader cl, String name) {
		try {
			String className = Timer.class.getCanonicalName();
			Class<?> c = cl.loadClass(className);
			return (Timer)c.getConstructor(String.class).newInstance(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
