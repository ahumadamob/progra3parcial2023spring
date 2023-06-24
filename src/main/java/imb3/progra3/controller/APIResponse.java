package imb3.progra3.controller;

import java.util.List;

public class APIResponse<T> {        // T: parametro generico   =>   objeto
	
	// atributos
	private int status;
	private List<String> messages;
	private T data;
	
	// constructor
	public APIResponse(int status, List<String> messages, T data) {
		this.status = status;
		this.messages = messages;
		this.data = data;
	}

	// getter & setter
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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	

}
