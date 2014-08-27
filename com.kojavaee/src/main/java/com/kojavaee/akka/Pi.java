/**
 * Copyright (C) 2009-2012 Typesafe Inc. <http://www.typesafe.com>
 */
package com.kojavaee.akka;


import java.util.concurrent.TimeUnit;

import scala.concurrent.duration.Duration;
import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.actor.UntypedActorFactory;
import akka.routing.RoundRobinRouter;

public class Pi {
	
	public static void main(String[] args) {
		Pi pi = new Pi();
		pi.calculate(4,10000,10000);
//		Pi approximation: 		3.1415926435897883
//		Calculation time: 	515 milliseconds
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
			if(message instanceof Work) {
				Work work = (Work)message;
				double result = calculatePiFor(work.getStart(),work.getNrOfElements());
				getSender().tell(new Result(result), getSelf());
			} else {
				unhandled(message);
			}
		}

		private double calculatePiFor(int start, int nrOfElements) {
			double acc = 0.0;
			for(int i=start*nrOfElements; i<=((start+1) * nrOfElements - 1); i++) {
				acc += 4.0 * ( 1 - (i % 2) * 2) / (2 * i + 1);
			}
			return acc;
		}
	}
	
	public static class Master extends UntypedActor {
		private final int nrOfMessage;
		private final int nrOfElements;
		
		private double pi;
		private int nrOfResults;
		private final long start = System.currentTimeMillis();
		
		private final ActorRef listener;
		private final ActorRef workerRouter;
		
		public Master(int nrOfWorkers,int nrOfMessages,int nrOfElements,ActorRef listener) {
			this.nrOfElements = nrOfElements;
			this.nrOfMessage = nrOfMessages;
			this.listener = listener;
			
			 workerRouter = this.getContext().actorOf(new Props(Worker.class).withRouter(new RoundRobinRouter(nrOfWorkers)),
			          "workerRouter");
		}

		@Override
		public void onReceive(Object message) throws Exception {
			if(message instanceof Calculate) {
				for(int start = 0; start<nrOfMessage; start++) {
					workerRouter.tell(new Work(start,nrOfElements), getSelf());
				}
			} else if (message instanceof Result) {
				Result result = (Result) message;
				pi += result.getValue();
				nrOfResults += 1;
				if(nrOfResults == nrOfMessage) {
					Duration duration = Duration.create(System.currentTimeMillis() - start,TimeUnit.MILLISECONDS);
					listener.tell(new PiApproximation(pi, duration), getSelf());
					
					getContext().stop(getSelf());
				}
			} else {
				unhandled(message);
			}
		}
	}
	
	public static class Listener extends UntypedActor {

		@Override
		public void onReceive(Object message) throws Exception {
			if(message instanceof PiApproximation) {
				PiApproximation approximation = (PiApproximation)message;
				System.out.println(String.format("\n\tPi approximation: \t\t%s\n\tCalculation time: \t%s",  approximation.getPi(), approximation.getDuration()));
				getContext().system().shutdown();
			} else {
				unhandled(message);
			}
		}
		
	}
	
	private void calculate(final int nrOfWorkers, final int nrOfElements, final int nrOfMessage) {
		ActorSystem system = ActorSystem.create("PiSystem");
		
		final ActorRef listener = system.actorOf(new Props(Listener.class),"listener");
		
		ActorRef master = system.actorOf(new Props(new UntypedActorFactory() {
			
			@Override
			 public UntypedActor create() {
		        return new Master(nrOfWorkers, nrOfMessage, nrOfElements, listener);
		      }
		}));
		
		master.tell(new Calculate());
	}
}
