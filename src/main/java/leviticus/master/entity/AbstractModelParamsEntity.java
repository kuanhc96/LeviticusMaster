package leviticus.master.entity;

import jakarta.persistence.MappedSuperclass;

import java.sql.Timestamp;

@MappedSuperclass
public abstract class AbstractModelParamsEntity extends AbstractBaseEntity {
    private Long trainId;

    private Double accuracy;

    private String classificationReport;

    private Double trainTime;

    public AbstractModelParamsEntity() {
        super();
    }

    public AbstractModelParamsEntity(Long trainId) {
        super();
        this.trainId = trainId;
    }

    public AbstractModelParamsEntity(Long trainId, Timestamp lchgTime) {
        super(lchgTime);
        this.trainId = trainId;
    }

    public AbstractModelParamsEntity(
            Long trainId,
            Double accuracy,
            String classificationReport,
            Double trainTime
    ) {
        super();
        this.trainId = trainId;
        this.accuracy = accuracy;
        this.classificationReport = classificationReport;
        this.trainTime = trainTime;
    }

    public AbstractModelParamsEntity(
            Long trainId,
            Timestamp lchgTime,
            Double accuracy,
            String classificationReport,
            Double trainTime
    ) {
        super(lchgTime);
        this.trainId = trainId;
        this.accuracy = accuracy;
        this.classificationReport = classificationReport;
        this.trainTime = trainTime;
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

}
