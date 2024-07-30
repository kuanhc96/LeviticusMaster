package leviticus.master.model.predict;

import leviticus.master.enums.ClassificationModelType;

public class PredictRequestFormModel {
    private ClassificationModelType modelType;
    private String dataset;
    private Long trainId;

    public PredictRequestFormModel() {}

    public PredictRequestFormModel(ClassificationModelType modelType) {
        this.modelType = modelType;
    }

    public PredictRequestFormModel(
            Long trainId,
            ClassificationModelType modelType,
            String dataset
    ) {
        this.trainId = trainId;
        this.modelType = modelType;
        this.dataset = dataset;
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

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }
}
