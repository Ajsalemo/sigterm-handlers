package com.sigterm.azure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sun.misc.Signal;
import sun.misc.SignalHandler;

@SpringBootApplication
public class AzureApplication {

	private static void addSignalHandler() {
		SignalHandler signalHandler = new SignalHandlerImpl();
		Signal.handle(new Signal("TERM"), signalHandler);
		// you also can handle other signal such as SIGINT (ctrl + c) like below.
		Signal.handle(new Signal("INT"), signalHandler);
	}

	private static class SignalHandlerImpl implements SignalHandler {

		@Override
		public void handle(Signal signal) {
			System.out.println(signal.getName());

			switch (signal.getName()) {
				case "TERM":
					System.out.println("Caught signal SIGTERM, exiting application with exit(0)");
					System.exit(0);
					break;
				case "INT":
					System.out.println("Caught signal SIGINT, exiting application with exit(0)");
					System.exit(0);
					break;
				default:
					break;
			}
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(AzureApplication.class, args);
		addSignalHandler();
	}
}
