package de.fuberlin.csw.Esper.event;

import java.util.Random;

import org.apache.log4j.Logger;

import de.fuberlin.csw.Esper.data.RandomString;

public class EventProducer {

	static Logger log = Logger.getLogger(EventProducer.class);
	static long eventCount = 0;
	RandomString randomString;

	public EventProducer() {
		randomString = new RandomString(1);
	}

	/*
	 * generate the next event Tuple
	 */
	public MessageEvent nextTuple() {

		MessageEvent currentStock = new MessageEvent( randomString.nextString());

		eventCount += 1;
		return currentStock;
	}

	/*
	 * generate the next event Tuple
	 */
	public MessageEvent nextTupleDegree() {

		Random rand = new Random();
		// a random number between 1-10
		int randomNum = rand.nextInt((10 - 1) + 1) + 1;
		MessageEvent currentStock;
		if (randomNum >= 5)
			currentStock = new MessageEvent("Person-" + randomString.nextString());
		else
			currentStock = new MessageEvent("Person-" + randomString.nextString());

		eventCount += 1;
		return currentStock;
	}

}
