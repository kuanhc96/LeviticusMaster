package leviticus.master.entity.taskEntity;

import jakarta.persistence.Entity;
import leviticus.master.entity.AbstractTaskEntity;
import leviticus.master.enums.ClassificationModelType;

import java.sql.Timestamp;

@Entity
public class PredictTaskEntity extends AbstractTaskEntity {

    // foreign key
    private Long trainId;

    private String dataset;

    private Double accuracy;

    public PredictTaskEntity() {
        super();
    }

    public PredictTaskEntity(Long trainId) {
        super();
        this.trainId = trainId;
    }

    public PredictTaskEntity(ClassificationModelType modelType) {
        super(modelType);
    }

    public PredictTaskEntity(ClassificationModelType modelType, Long trainId) {
        super(modelType);
        this.trainId = trainId;
    }

    public PredictTaskEntity(
            ClassificationModelType modelType,
            Timestamp lchgTime,
            Boolean isComplete,
            Double timeElapsed,
            Long trainId,
            Double accuracy,
            String dataset
    ) {
        super(modelType, lchgTime, timeElapsed, isComplete);
        this.trainId = trainId;
        this.dataset = dataset;
        this.accuracy = accuracy;
    }

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public String getDataset() {
        return dataset;
    }

    public void setDataset(String dataset) {
        this.dataset = dataset;
    }

    public Double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }
}

