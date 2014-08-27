/**
 * Copyright (C) 2009-2012 Typesafe Inc. <http://www.typesafe.com>
 */
package com.kojavaee.akka;


import scala.concurrent.duration.Duration;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class Pi {
	
	public static void main(String[] args) {
		Pi pi = new Pi();
		pi.calculate(4,10000,10000);
	}
	
	static class Calculate {
	}
	
	static class Work {
		private final int start;
		private final int nrOfElements;
		
		public Work(int start, int nrOfElements) {
			this.start = start;
			this.nrOfElements = nrOfElements;
		}
		
		public int getStart() {
			return start;
		}
		
		public int getNrOfElements() {
			return nrOfElements;
		}
	}
	
	static class Result {
		private final double value;
		public Result(double value) {
			this.value = value;
		}
		
		public double getValue() {
			return value;
		}
	}
	
	static class PiApproximation {
		private final double pi;
		private final Duration duration;
		
		public PiApproximation(double pi,Duration duration) {
			this.pi = pi;
			this.duration = duration;
		}
		
		public double getPi() {
			return pi;
		}
		
		public Duration getDuration() {
			return duration;
		}
	}
	
	public static class Worker extends UntypedActor {
		
		@Override
		public void onReceive(Object message) throws Exception {
			
		}
		
	}
	
	public static class Listener extends UntypedActor {

		@Override
		public void onReceive(Object message) throws Exception {
			
		}
		
	}
	
	private void calculate(final int nrOfWorkers, final int nrOfElements, final int nrOfMessage) {
		ActorSystem system = ActorSystem.create("PiSystem");
		
		final ActorRef listener = system.actorOf(new Props(null, Listener.class, null),"listener");
	}
}
