import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
abstract class Request implements Serializable {
	protected RequestType type;
	protected Date date;
	protected String description;
	
	
	
	Request() {
		type = null;
		date = null;
		description = null;
	}
	
	
	Request(RequestType type, String description) {
		this.type = type;
		this.date = new Date();
		this.description = description;
	}
	
	
	public RequestType getType() {
		return type;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String toString() {
		return "[" + date + "] " + type + " - description:" + description;
	}
}
