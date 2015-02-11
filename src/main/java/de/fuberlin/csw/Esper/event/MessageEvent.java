package de.fuberlin.csw.Esper.event;

import java.io.Serializable;

public class MessageEvent implements Serializable {

	/**
	 *  
	 */
	private static final long serialVersionUID = 6523737083526253656L;

	public String name;

	public MessageEvent(String name) {
		this.name = name;
	}

	public boolean getValue(String value) {
		return (this.name.equals(value));
	}

	
	public String getName() {
		return name;
	}
}
