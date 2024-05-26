package leviticus.master.model;

import leviticus.master.enums.ClassificationModelType;
import leviticus.master.enums.OptimizerType;

public class TrainRequestFormModel {
    private ClassificationModelType modelType;
    private OptimizerType optimizerType;
    private String dataset;
    private Boolean isTrainOnly;
    private Boolean isCrossValidated;

    public TrainRequestFormModel() {}

    public TrainRequestFormModel(
            ClassificationModelType modelType,
            OptimizerType optimizerType,
            String dataset,
            Boolean isTrainOnly,
            Boolean isCrossValidated
    ) {
        this.modelType = modelType;
        this.optimizerType = optimizerType;
        this.dataset = dataset;
        this.isTrainOnly = isTrainOnly;
        this.isCrossValidated = isCrossValidated;

    }

    public ClassificationModelType getModelType() {
        return modelType;
    }

    public void setModelType(ClassificationModelType modelType) {
        this.modelType = modelType;
    }

    public OptimizerType getOptimizerType() {
        return optimizerType;
    }

    public void setOptimizerType(OptimizerType optimizerType) {
        this.optimizerType = optimizerType;
    }

    public String getDataset() {
        return dataset;
    }

    public void setDataset(String dataset) {
        this.dataset = dataset;
    }

    public Boolean getIsTrainOnly() {
        return isTrainOnly;
    }

    public void setIsTrainOnly(Boolean trainOnly) {
        isTrainOnly = trainOnly;
    }

    public Boolean getIsCrossValidated() {
        return isCrossValidated;
    }

    public void setIsCrossValidated(Boolean crossValidated) {
        isCrossValidated = crossValidated;
    }
}
