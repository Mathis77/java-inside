package fr.esipe.javainside.labfive;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Objects;

import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	void testToJSONObjectPerson() {
		var person = new Person("John", "Doe");
		assertEquals(person.toJSON(), Main.toJSON(person));
	}
	
	void testToJSONObjectAlien() {
		var alien = new Alien("E.T.", 100);
		assertEquals(alien.toJSON(), Main.toJSON(alien));
	}
	
	static class Person {
		private final String firstName;
		private final String lastName;

		public Person(String firstName, String lastName) {
			this.firstName = Objects.requireNonNull(firstName);
			this.lastName = Objects.requireNonNull(lastName);
		}
		
		public String toJSON() {
			return "{\n" + "  \"firstName\": \"" + firstName + "\"\n" + "  \"lastName\": \""
					+ lastName + "\"\n" + "}\n";
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}
	}
	
	static class Alien {
		private final String planet;
		private final int age;

		public Alien(String planet, int age) {
			if (age <= 0) {
				throw new IllegalArgumentException("Too young...");
			}
			this.planet = Objects.requireNonNull(planet);
			this.age = age;
		}
		
		public String toJSON() {
			return "{\n" + "  \"planet\": \"" + planet + "\"\n" + "  \"members\": \"" + age + "\"\n"
					+ "}\n";
		}

		public String getPlanet() {
			return planet;
		}

		public int getAge() {
			return age;
		}
	}

}
