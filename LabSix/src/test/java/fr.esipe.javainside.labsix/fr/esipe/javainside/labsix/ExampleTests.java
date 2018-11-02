package fr.esipe.javainside.labsix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import org.junit.jupiter.api.Test;

class ExampleTests {

	@Test
	void callReflexiveAStaticHello() throws ReflectiveOperationException {
		var methodStatic = Example.class.getDeclaredMethod("aStaticHello", int.class);
		methodStatic.setAccessible(true);
		assertEquals("question 5", methodStatic.invoke(null, 5));
	}
	
	@Test
	void callReflexiveAnInstanceHello() throws ReflectiveOperationException {
		var methodStatic = Example.class.getDeclaredMethod("anInstanceHello", int.class);
		methodStatic.setAccessible(true);
		assertEquals("question 5", methodStatic.invoke(new Example(), 5));
	}
	
	@Test
	void callMethodHandlesLookupAStaticHello() throws Throwable {
		var lookup = MethodHandles.privateLookupIn(Example.class, MethodHandles.lookup());
		var methodHandle = lookup.findStatic(Example.class, "aStaticHello", MethodType.methodType(String.class, int.class));
		assertEquals("question 5", (String) methodHandle.invokeExact(5));
	}
	
	@Test
	void callMethodHandlesLookupAnInstanceHello() throws Throwable {
		var lookup = MethodHandles.privateLookupIn(Example.class, MethodHandles.lookup());
		var methodHandle = lookup.findVirtual(Example.class, "anInstanceHello", MethodType.methodType(String.class, int.class));
		assertEquals("question 5", (String) methodHandle.invokeExact(new Example(), 5));
	}
	
	@Test
	void callMethodHandlesLookupAnInstanceHelloWithInsertArguments() throws Throwable {
		var lookup = MethodHandles.privateLookupIn(Example.class, MethodHandles.lookup());
		var methodHandle = lookup.findVirtual(Example.class, "anInstanceHello", MethodType.methodType(String.class, int.class));
		methodHandle = MethodHandles.insertArguments(methodHandle, 1, 8);
		assertEquals("question 8", (String) methodHandle.invokeExact(new Example()));
	}
	
	@Test
	void callMethodHandlesLookupAnInstanceHelloWithDropArguments() throws Throwable {
		var lookup = MethodHandles.privateLookupIn(Example.class, MethodHandles.lookup());
		var methodHandle = lookup.findVirtual(Example.class, "anInstanceHello", MethodType.methodType(String.class, int.class));
		methodHandle = MethodHandles.dropArguments(methodHandle, 0, int.class);
		assertEquals("question 5", (String) methodHandle.invokeExact(6, new Example(), 5));
	}
	
	@Test
	void callMethodHandlesLookupAnInstanceHelloWithAsType() throws Throwable {
		var lookup = MethodHandles.privateLookupIn(Example.class, MethodHandles.lookup());
		var methodHandle = lookup.findVirtual(Example.class, "anInstanceHello", MethodType.methodType(String.class, int.class))
				.asType(MethodType.methodType(String.class, Example.class, Integer.class));
		assertEquals("question 5", (String) methodHandle.invokeExact(new Example(), Integer.valueOf(5)));
	}
	
	@Test
	void callMethodHandlesLookupAnInstanceHelloWithConstant() throws Throwable {
		var methodHandle = MethodHandles.constant(String.class, "test");
		assertEquals("test", (String) methodHandle.invokeExact());
	}
	
	@Test
	void guardWithTest() throws Throwable {
		var testLookup = MethodHandles.lookup();
		var testMethodHandle = testLookup.findVirtual(String.class, "equals", MethodType.methodType(boolean.class, Object.class))
				.asType(MethodType.methodType(boolean.class, String.class, String.class));
		testMethodHandle = MethodHandles.insertArguments(testMethodHandle, 0, "foo");
		
		var targetMethodHandle = MethodHandles.dropArguments(MethodHandles.constant(int.class, 1), 0, String.class);
		var fallbackMethodHandle = MethodHandles.dropArguments(MethodHandles.constant(int.class, -1), 0, String.class);
		
		var method = MethodHandles.guardWithTest(testMethodHandle, targetMethodHandle, fallbackMethodHandle);
		
		assertEquals(1, (int)method.invokeExact("foo"));
		assertEquals(-1, (int)method.invokeExact("bar"));
		
	}
	
	
	

}
