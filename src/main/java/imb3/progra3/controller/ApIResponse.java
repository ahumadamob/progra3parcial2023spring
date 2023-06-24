package imb3.progra3.controller;

import java.util.List;

public class ApIResponse <M> {
	private int status;
	private List <String> messages;
	private M data;
	
	public ApIResponse (int status, List <String> messages, M data) {
		this.status=status;
		this.messages= messages;
		this.data = data;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	public M getData() {
		return data;
	}
	public void setData(M data) {
		this.data = data;
	}

}
