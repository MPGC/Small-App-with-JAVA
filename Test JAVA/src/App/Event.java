package App;

import java.sql.Timestamp;

public class Event {

	private String id;
	private String source_id;
	private Timestamp timestamp;
	private int value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSource_id() {
		return source_id;
	}

	public void setSource_id(String source_id) {
		this.source_id = source_id;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", source_id=" + source_id + ", timestamp=" + timestamp + ", value=" + value + "]";
	}
}