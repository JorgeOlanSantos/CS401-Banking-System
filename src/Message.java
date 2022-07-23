import java.io.Serializable;

@SuppressWarnings("serial")
public class Message implements Serializable {
    protected String type;
    protected String status;
    protected String text;

    public Message(){
        this.type = "Undefined";
        this.status = "Undefined";
        this.text = "Undefined";
    }

    public Message(String type, String status, String text){
        type = type.toLowerCase();
        if (type.equals("login") || type.equals("text") || type.equals("logout")) {
            this.type = type;
            this.status = status;
            this.text = text;
        } else {
        	this.type = "Undefined";
            this.status = "Undefined";
            this.text = "Undefined";
        }
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getType(){
        return type;
    }

    public String getStatus(){
        return status;
    }

    public String getText(){
        return text;
    }

}
