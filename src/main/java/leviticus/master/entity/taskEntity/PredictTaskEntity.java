package leviticus.master.entity.taskEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import leviticus.master.entity.AbstractBaseEntity;

import java.sql.Timestamp;

@Entity
public class PredictTaskEntity extends AbstractBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long trainId;

    private Double accuracy;

    private String classificationReport;

    private String results;

    private Boolean isComplete;

    private String dataset;

    private Double predictTime;

    public PredictTaskEntity() {
        super();
    }

    public PredictTaskEntity(
            Long trainId,
            Double accuracy,
            String classificationReport,
            String results,
            Boolean isComplete,
            String dataset,
            Double predictTime
    ) {
        super();
        this.trainId = trainId;
        this.accuracy = accuracy;
        this.classificationReport = classificationReport;
        this.results = results;
        this.isComplete = isComplete;
        this.dataset = dataset;
        this.predictTime = predictTime;
    }


    public PredictTaskEntity(
            Long trainId,
            Double accuracy,
            String classificationReport,
            String results,
            Boolean isComplete,
            String dataset,
            Double predictTime,
            Timestamp lchgTime
    ) {
        super(lchgTime);
        this.trainId = trainId;
        this.accuracy = accuracy;
        this.classificationReport = classificationReport;
        this.results = results;
        this.isComplete = isComplete;
        this.dataset = dataset;
        this.predictTime = predictTime;
    }

    public Long getId() {
        return id;
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

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public Boolean isComplete() {
        return isComplete;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }

    public String getDataset() {
        return dataset;
    }

    public void setDataset(String dataset) {
        this.dataset = dataset;
    }

    public Double getPredictTime() {
        return predictTime;
    }

    public void setPredictTime(Double predictTime) {
        this.predictTime = predictTime;
    }

}

