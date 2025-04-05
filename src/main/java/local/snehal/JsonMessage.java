package local.snehal;

public class JsonMessage {
    private String userid;
    private String name;
    private String message;
    public String getUserid() {		return userid;	}
    public void setUserid(String userid) {		this.userid = userid;	}
    public String getName() {		return name;	}
    public void setName(String name) {		this.name = name;	}
    public String getMessage() {		return message;	}
    public void setMessage(String message) {		this.message = message;	}

    public void PrintJsonData() {
        System.out.println(this.FormatData());	}

    public String FormatData() {
        return "MessageRequest{" +
                "userId='" + userid + '\'' +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';

    }

}

