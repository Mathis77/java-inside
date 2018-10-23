package fr.esipe.javainside.labfive;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Arrays;
import java.util.stream.Collectors;

import fr.esipe.javainside.labfive.annotations.JSONProperty;

public class Main {

//	WITHOUT ANNOTATION
//	
//	public static String toJSON(Object o) {
//		return Arrays.stream(o.getClass().getMethods())
//					.filter(not(Main::isObjectGetClass))
//					.filter(Main::isGetter)
//					.map(method -> format(o, method))
//					.collect(Collectors.joining("\n", "{\n", "\n}\n"));
//	}
	
	// WITH ANNOTATION
	
	public static String toJSON(Object o) {
		return Arrays.stream(o.getClass().getMethods())
					.filter(Main::isMethodAnnotedByJSONProperty)
					.map(method -> format(o, method))
					.collect(Collectors.joining("\n", "{\n", "\n}\n"));
	}
	
	private static boolean isMethodAnnotedByJSONProperty(Method m) {
		return m.isAnnotationPresent(JSONProperty.class);
	}
	
	private static boolean isObjectGetClass(Method m) {
		return m.getDeclaringClass() == Object.class && m.getName().equals("getClass");
	}
	
	private static String format(Object o, Method m) {
		return "  \""+propertyName(m.getName())+"\": \""+getValue(o, m)+"\"";
	}
	
	private static boolean isGetter(Method m) {
		return m.getName().startsWith("get");
	}

	private static String propertyName(String name) {
		return Character.toLowerCase(name.charAt(3)) + name.substring(4);
	}
	
	private static Object getValue(Object o, Method m) {
		try {
			return m.invoke(o);
		} catch (IllegalAccessException e) {
			throw new IllegalStateException(e);
		} catch (InvocationTargetException e) {
			var cause = e.getCause();
			if(cause instanceof Error) {
				throw (Error)cause;
			}
			if(cause instanceof RuntimeException) {
				throw (RuntimeException)cause;
			}
			throw new UndeclaredThrowableException(cause);
		}
	}

	public static void main(String[] args) {

	}
}
