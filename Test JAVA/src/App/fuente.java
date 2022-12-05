package App;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class fuente {

	protected String nombre;
	protected String id;
	protected String evento;
	private static ArrayList<Source> testSources = new ArrayList<Source>();
	private static ArrayList<Event> testEvents = new ArrayList<Event>();

	private static Event searchEventByTimestamp(Timestamp searchKey, List<Event> testEvents) {

		System.out.println("\n" + "***************************");
		System.out.println("Testing searchEventByTimestamp");

		for (Event event : testEvents) {

			if (event.getTimestamp().equals(searchKey)) {

				System.out.println("***************************");
				return event;
			}
		}

		System.out.println("***************************");
		return null;
	}

	private static Event searchEventBySourceID(String searchKey, List<Event> testEvents) {

		System.out.println("\n" + "***************************");
		System.out.println("Testing searchEventBySourceID");

		for (Event event : testEvents) {

			if (event.getSource_id().equals(searchKey)) {

				System.out.println("***************************");
				return event;
			}
		}
		System.out.println("***************************");
		return null;
	}

	private static ArrayList<Event> searchEventWithinValueRange(int value1, int value2, List<Event> testEvents) {

		ArrayList<Event> returnEvents = new ArrayList<Event>();
		System.out.println("\n" + "***************************");
		System.out.println("Testing searchEventWithinValueRange");

		for (Event event : testEvents) {

			if (event.getValue() >= value1 && event.getValue() <= value2) {
				returnEvents.add(event);
			}
		}
		System.out.println("***************************");
		return returnEvents;
	}

	protected static void setupData() {

		Date date = new Date();

		// Set source tests
		Source sourceTest = new Source();
		Source sourceTest2 = new Source();

		sourceTest.setId("1");
		sourceTest.setName("Test1");

		sourceTest2.setId("2");
		sourceTest2.setName("Test2");

		testSources.add(sourceTest);
		testSources.add(sourceTest2);

		// Set event tests

		Event event1 = new Event();
		Event event2 = new Event();

		event1.setId("1");
		event1.setSource_id("1");
		event1.setTimestamp(Timestamp.valueOf("2022-02-13 17:53:10.0"));
		event1.setValue(1);

		event2.setId("2");
		event2.setSource_id("2");
		event2.setTimestamp(new Timestamp(date.getTime()));
		event2.setValue(2);

		testEvents.add(event1);
		testEvents.add(event2);
	}

	protected static Event testSearchEventByTimestamp(String value) {

		Event searchEventByTimestamp = searchEventByTimestamp(Timestamp.valueOf(value), testEvents);

		if (searchEventByTimestamp != null) {

			System.out.println(searchEventByTimestamp);
		} else {

			System.out.println("Unable to find any Event with provided Timestamp " + value);
		}
		
		return searchEventByTimestamp;
	}

	protected static Event testSearchEventBySourceID(String value) {

		Event searchEventBySourceIDResults = (searchEventBySourceID(value, testEvents));

		if (searchEventBySourceIDResults != null) {

			System.out.println(searchEventBySourceIDResults);
		} else {

			System.out.println("Unable to find any Event with provided SourceID " + value);
		}
		
		return searchEventBySourceIDResults;
	}

	protected static ArrayList<Event> testSearchEventWithinValueRange(int value1, int value2) {

		ArrayList<Event> searchEventWithinValueRangeResults = (searchEventWithinValueRange(value1, value2, testEvents));

		if (!searchEventWithinValueRangeResults.isEmpty()) {

			System.out.println(searchEventWithinValueRangeResults);
		} else {

			System.out.println("Unable to find any Event with provided Value Range (" + value1 + "," + value2 + ")");
		}
		
		return searchEventWithinValueRangeResults;
	}

	public static void main(String[] args) {

		try {

			// Test Data
			setupData();

			// Positive Test searchEventByTimestamp
			testSearchEventByTimestamp("2022-02-13 17:53:10.0");

			// Negative Test searchEventByTimestamp
			testSearchEventByTimestamp("2022-02-14 17:53:10.0");

			// Positive Test searchEventBySourceIDResults
			testSearchEventBySourceID("1");

			// Negative Test searchEventBySourceIDResults
			testSearchEventBySourceID("3");

			// Positive Test searchEventWithinValueRange
			testSearchEventWithinValueRange(1, 2);

			// Negative Test searchEventWithinValueRange
			testSearchEventWithinValueRange(8, 9);

		} catch (Exception e) {

			System.out.println("Error: " + e.toString());
		}
	}

}
