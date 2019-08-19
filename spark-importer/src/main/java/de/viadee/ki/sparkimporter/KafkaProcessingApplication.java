package de.viadee.ki.sparkimporter;

import de.viadee.ki.sparkimporter.exceptions.FaultyConfigurationException;
import de.viadee.ki.sparkimporter.runner.impl.KafkaProcessingRunner;
import de.viadee.ki.sparkimporter.runner.SparkRunner;

public class KafkaProcessingApplication {

	public static void main(String[] arguments) {
		SparkRunner kafkaProcessingRunner = new KafkaProcessingRunner();
		try {
			kafkaProcessingRunner.run(arguments);
		} catch (FaultyConfigurationException e) {
			e.printStackTrace();
		}
	}

}
