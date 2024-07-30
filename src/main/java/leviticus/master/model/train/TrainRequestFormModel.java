package leviticus.master.model.train;

import leviticus.master.enums.ClassificationModelType;

public class TrainRequestFormModel {
    private ClassificationModelType modelType;
    private String dataset;
    private Boolean isTrainOnly;

    public TrainRequestFormModel() {
    }

    public TrainRequestFormModel(ClassificationModelType modelType) {
        this.modelType = modelType;
    }

    public TrainRequestFormModel(
            ClassificationModelType modelType,
            String dataset,
            Boolean isTrainOnly
    ) {
        this.modelType = modelType;
        this.dataset = dataset;
        this.isTrainOnly = isTrainOnly;
    }

    public ClassificationModelType getModelType() {
        return modelType;
    }

    public void setModelType(ClassificationModelType modelType) {
        this.modelType = modelType;
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
}

