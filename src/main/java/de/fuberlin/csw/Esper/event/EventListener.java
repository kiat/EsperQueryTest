package de.fuberlin.csw.Esper.event;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import com.espertech.esper.event.bean.BeanEventBean;
import com.espertech.esper.event.map.MapEventBean;

public class EventListener implements UpdateListener {
	static Logger log = Logger.getLogger(EventListener.class);

	public boolean flag = false;

	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		
		System.out.println("\nNEW COMPLEX EVENT");
//		
//	       EventBean event = newEvents[0];
//	        System.out.println(" " + event.get("name"));

		if (newEvents != null) {
			for (EventBean newEvent : newEvents) {

				// EventBean newEvent = newEvents[0];
				if (newEvent instanceof BeanEventBean) {

					MessageEvent sEvent = (MessageEvent) newEvent.getUnderlying();
					System.out.println("Message Name is: " + sEvent.name );

				} else if (newEvent instanceof EventBean) {

					MapEventBean bean = (MapEventBean) newEvent;
					HashMap<?, ?> map = (HashMap<?, ?>) bean.getUnderlying();

					for (Map.Entry<?, ?> entry : map.entrySet()) {

						if (entry.getValue() instanceof BeanEventBean) {

							BeanEventBean tmp = (BeanEventBean) entry.getValue();

							// check whether event is instance of
							if (tmp.getUnderlying().getClass() == MessageEvent.class) {
								// retrieve the actual event from bean
								MessageEvent sEvent = (MessageEvent) tmp.getUnderlying();

								// here we send the enriched Event
								System.out.println("Message Name is: " + sEvent.name );
							}
						}
					} // END OF FOR
				} else {
					System.err.println("ERROR");
					log.debug("Event received not of type TripleEvent.class!");
				}
			}
		}else {
			System.err.println("OBJECT is null");
			log.debug("newEvents are null");
		}
	}
}