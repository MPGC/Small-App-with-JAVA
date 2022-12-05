package App;

import java.sql.Timestamp;

public class Event {

	private String id;
	private String fuente_id;
	private Timestamp timestamp;
	private int valor;

	//Getters y setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFuente_id() {
		return fuente_id;
	}

	public void setFuente_id(String fuente_id) {
		this.fuente_id = fuente_id;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", fuente_id=" + fuente_id + ", timestamp=" + timestamp + ", valor=" + valor + "]";
	}
}