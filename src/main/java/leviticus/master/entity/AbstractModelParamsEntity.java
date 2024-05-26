package leviticus.master.entity;

import jakarta.persistence.MappedSuperclass;

import java.sql.Timestamp;

@MappedSuperclass
public abstract class AbstractModelParamsEntity {
    private Long trainId;

    private Double accuracy;

    private String classificationReport;

    private Double trainTime;

    private Timestamp lchgTime;

    public AbstractModelParamsEntity() {}

    public AbstractModelParamsEntity(
            Long trainId,
            Double accuracy,
            String classificationReport,
            Double trainTime,
            Timestamp lchgTime
    ) {
        this.trainId = trainId;
        this.accuracy = accuracy;
        this.classificationReport = classificationReport;
        this.trainTime = trainTime;
        this.lchgTime = lchgTime;
    }

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
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
    public Double getTrainTime() {
        return trainTime;
    }

    public void setTrainTime(Double trainTime) {
        this.trainTime = trainTime;
    }

    public Timestamp getLchgTime() {
        return lchgTime;
    }

    public void setLchgTime(Timestamp lchgTime) {
        this.lchgTime = lchgTime;
    }
}
