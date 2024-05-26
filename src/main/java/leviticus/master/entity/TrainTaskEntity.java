package leviticus.master.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import leviticus.master.enums.ClassificationModelType;

import java.sql.Timestamp;

@Entity
public class TrainTaskEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private ClassificationModelType modelType;

    private String weightsFile;

    private String dataset;

    private Boolean isComplete;

    private Boolean trainOnly;

    private Timestamp lchgTime;

    public TrainTaskEntity() {}

    public TrainTaskEntity(
            ClassificationModelType modelType,
            String weightsFile,
            String dataset,
            Boolean isComplete,
            Boolean trainOnly,
            Timestamp lchgTime
    ) {
        this.modelType = modelType;
        this.weightsFile = weightsFile;
        this.dataset = dataset;
        this.isComplete = isComplete;
        this.trainOnly = trainOnly;
        this.lchgTime = lchgTime;
    }


    public Long getId() {
        return id;
    }

    public ClassificationModelType getModelType() {
        return modelType;
    }

    public void setModelType(ClassificationModelType modelType) {
        this.modelType = modelType;
    }

    public String getWeightsFile() {
        return weightsFile;
    }

    public void setWeightsFile(String weightsFile) {
        this.weightsFile = weightsFile;
    }

    public String getDataset() {
        return dataset;
    }

    public void setDataset(String dataset) {
        this.dataset = dataset;
    }

    public Boolean getComplete() {
        return isComplete;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }

    public Boolean getTrainOnly() {
        return trainOnly;
    }

    public void setTrainOnly(Boolean trainOnly) {
        this.trainOnly = trainOnly;
    }

    public Timestamp getLchgTime() {
        return lchgTime;
    }

    public void setLchgTime(Timestamp lchgTime) {
        this.lchgTime = lchgTime;
    }
}
