package leviticus.master.entity.taskEntity;

import jakarta.persistence.Entity;
import leviticus.master.entity.AbstractTaskEntity;
import leviticus.master.enums.ClassificationModelType;

import java.sql.Timestamp;
import java.util.Map;

@Entity
public class PredictTaskEntity extends AbstractTaskEntity {

    // foreign key
    private Long trainId;

    private String dataset;

    private Double accuracy;

    private String classificationReport;

    private Map<String, String> predictions;

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
            String dataset,
            String classificationReport,
            Map<String, String> predictions
    ) {
        super(modelType, lchgTime, timeElapsed, isComplete);
        this.trainId = trainId;
        this.dataset = dataset;
        this.accuracy = accuracy;
        this.classificationReport = classificationReport;
        this.predictions = predictions;
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

    public String getClassificationReport() {
        return classificationReport;
    }

    public void setClassificationReport(String classificationReport) {
        this.classificationReport = classificationReport;
    }

    public Map<String, String> getPredictions() {
        return predictions;
    }

    public void setPredictions(Map<String, String> predictions) {
        this.predictions = predictions;
    }
}

