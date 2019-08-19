package de.viadee.ki.sparkimporter.processing;

import de.viadee.ki.sparkimporter.processing.steps.PipelineStep;
import de.viadee.ki.sparkimporter.runner.config.SparkRunnerConfig;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PreprocessingRunner {

    private final List<PipelineStep> pipelineSteps = new ArrayList<>();

    public final static String DATASET_INITIAL = "initial";

    public final static Map<String, Dataset<Row>> helper_datasets = new HashMap<>();

    public PreprocessingRunner(){}

    public Dataset<Row> run(Dataset<Row> dataset, String dataLevel, SparkRunnerConfig config) {
        helper_datasets.clear();
        helper_datasets.put(DATASET_INITIAL + "_" + dataLevel, dataset);

        for(PipelineStep ps : this.pipelineSteps) {
            if(ps.getPreprocessingStep() != null)
            dataset = ps.getPreprocessingStep().runPreprocessingStep(dataset, config.isWriteStepResultsIntoFile(), dataLevel, ps.getStepParameters(), config);
        }
        return dataset;
    }

    public void addPreprocessorStep(PipelineStep step) {
        this.pipelineSteps.add(step);
    }
}
