package App;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestingApp {

	protected String nombre;
	protected String id;
	protected String evento;
	private static ArrayList<Fuente> testSources = new ArrayList<Fuente>();
	private static ArrayList<Event> testEvents = new ArrayList<Event>();
	
	//Funci�n para obtener listado por Timestamp
	private static Event searchEventByTimestamp(Timestamp searchKey, List<Event> testEvents) {

		System.out.println("\n" + "***************************");
		System.out.println("Testing searchEventByTimestamp");
		
		//Foreach para sacar Timestamp
		for (Event event : testEvents) {

			if (event.getTimestamp().equals(searchKey)) {

				System.out.println("***************************");
				return event;
			}
		}

		System.out.println("***************************");
		return null;
	}
	
	//Funci�n para obtener listado por Fuente_id
	private static Event searchEventBySourceID(String searchKey, List<Event> testEvents) {

		System.out.println("\n" + "***************************");
		System.out.println("Testing searchEventBySourceID");
		
		//Foreach para sacar Fuente_id
		for (Event event : testEvents) {

			if (event.getFuente_id().equals(searchKey)) {

				System.out.println("***************************");
				return event;
			}
		}
		System.out.println("***************************");
		return null;
	}
	
	//Funci�n para obtener listado dentro de un rango de valores
	private static ArrayList<Event> searchEventWithinValueRange(int valor1, int valor2, List<Event> testEvents) {

		ArrayList<Event> returnEvents = new ArrayList<Event>();
		System.out.println("\n" + "***************************");
		System.out.println("Testing searchEventWithinValueRange");

		for (Event event : testEvents) {

			if (event.getValor() >= valor1 && event.getValor() <= valor2) {
				returnEvents.add(event);
			}
		}
		System.out.println("***************************");
		return returnEvents;
	}
	
	//Base de datos
	protected static void setupData() {

		Date date = new Date();

		// Set source tests
		Fuente sourceTest = new Fuente();
		Fuente sourceTest2 = new Fuente();

		sourceTest.setId("1");
		sourceTest.setNombre("Test1");

		sourceTest2.setId("2");
		sourceTest2.setNombre("Test2");

		testSources.add(sourceTest);
		testSources.add(sourceTest2);

		// Set event tests
		Event event1 = new Event();
		Event event2 = new Event();

		event1.setId("1");
		event1.setFuente_id("1");
		event1.setTimestamp(Timestamp.valueOf("2022-02-13 17:53:10.0"));
		event1.setValor(1);

		event2.setId("2");
		event2.setFuente_id("2");
		event2.setTimestamp(new Timestamp(date.getTime()));
		event2.setValor(2);

		testEvents.add(event1);
		testEvents.add(event2);
	}
	
	//Testeo de casos para Timestamp
	protected static Event testSearchEventByTimestamp(String value) {

		Event searchEventByTimestamp = searchEventByTimestamp(Timestamp.valueOf(value), testEvents);

		if (searchEventByTimestamp != null) {

			System.out.println(searchEventByTimestamp);
		} else {

			System.out.println(" No se puede encontrar ning�n evento con el tiempo proporcionado " + value);
		}
		
		return searchEventByTimestamp;
	}

	//Testeo de casos para Fuente_id
	protected static Event testSearchEventBySourceID(String value) {

		Event searchEventBySourceIDResults = (searchEventBySourceID(value, testEvents));

		if (searchEventBySourceIDResults != null) {

			System.out.println(searchEventBySourceIDResults);
		} else {

			System.out.println(" No se puede encontrar ning�n evento con el fuente_id proporcionado  " + value);
		}
		
		return searchEventBySourceIDResults;
	}
	
	//Testeo de casos para rango de valores
	protected static ArrayList<Event> testSearchEventWithinValueRange(int value1, int value2) {

		ArrayList<Event> searchEventWithinValueRangeResults = (searchEventWithinValueRange(value1, value2, testEvents));

		if (!searchEventWithinValueRangeResults.isEmpty()) {

			System.out.println(searchEventWithinValueRangeResults);
		} else {

			System.out.println(" No se puede encontrar ning�n evento con el rango de valores proporcionado (" + value1 + "," + value2 + ")");
		}
		
		return searchEventWithinValueRangeResults;
	}

	public static void main(String[] args) {

		try {

			// Test Data
			setupData();

			// Test Positivo searchEventByTimestamp
			testSearchEventByTimestamp("2022-02-13 17:53:10.0");

			// Test Negativo searchEventByTimestamp
			testSearchEventByTimestamp("2022-02-14 17:53:10.0");

			// Test Positivo searchEventBySourceIDResults
			testSearchEventBySourceID("1");

			// Test Negativo searchEventBySourceIDResults
			testSearchEventBySourceID("3");

			// Test Positivo searchEventWithinValueRange
			testSearchEventWithinValueRange(1, 2);

			// Test Negativo searchEventWithinValueRange
			testSearchEventWithinValueRange(8, 9);

		} catch (Exception e) {

			System.out.println("Error: " + e.toString());
		}
	}

}
