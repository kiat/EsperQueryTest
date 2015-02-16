package de.fuberlin.csw.Esper;


import org.apache.log4j.PropertyConfigurator;

import de.fuberlin.csw.Esper.event.EsperEventProcessor;
import de.fuberlin.csw.Esper.event.EventListener;

/**
 * 
 * @author Kia A test class for starting different Esper queries for demonstration purposes.
 */
public class MainStartTest {

	static String query0 = "select * from MessageEvent(name='a')";
	static String query1 = "select * from MessageEvent.win:length(5) where name='a'";
	static String query2 = "select * from pattern[every (A = MessageEvent(name = 'a'))]";


	static String query3 = "select name from MessageEvent.win:length(5) where (name='a')";

	static String query4 =	"select * from MessageEvent.win:time(60) as m1, MessageEvent.win:time(60) as m2 where m1.name  = m2.name";
	static String query5 =	"select * from MessageEvent.win:length(5) as m1, MessageEvent.win:length(5) as m2 where m1.name  = m2.name";

	
	
	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");

		EsperEventProcessor ep = new EsperEventProcessor();
		EventListener my_listener = new EventListener();

		ep.addPattern(query4, my_listener);
		ep.start();

	}

}
