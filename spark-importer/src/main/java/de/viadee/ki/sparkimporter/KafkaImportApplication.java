package de.viadee.ki.sparkimporter;

import de.viadee.ki.sparkimporter.exceptions.FaultyConfigurationException;
import de.viadee.ki.sparkimporter.runner.impl.KafkaImportRunner;
import de.viadee.ki.sparkimporter.runner.SparkRunner;

public class KafkaImportApplication {

	public static void main(String[] arguments) {
		SparkRunner kafkaImportRunner = new KafkaImportRunner();
		try {
			kafkaImportRunner.run(arguments);
		} catch (FaultyConfigurationException e) {
			e.printStackTrace();
		}
	}

}
