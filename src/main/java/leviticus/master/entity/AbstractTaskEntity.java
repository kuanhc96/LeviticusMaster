package leviticus.master.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.sql.Timestamp;

@MappedSuperclass
public abstract class AbstractTaskEntity extends AbstractEntity {

    private Double accuracy;

    @Column(length=1024)
    private String classificationReport;

    private Double timeElapsed;

    private Boolean isComplete;

    private String dataset;

    public AbstractTaskEntity() {
        super();
    }

    public AbstractTaskEntity(Timestamp lchgTime) {
        super(lchgTime);
    }

    public AbstractTaskEntity(
            Double accuracy,
            String classificationReport,
            Double timeElapsed,
            Boolean isComplete,
            String dataset
    ) {
        super();
        this.accuracy = accuracy;
        this.classificationReport = classificationReport;
        this.timeElapsed = timeElapsed;
        this.isComplete = isComplete;
        this.dataset = dataset;
    }

    public AbstractTaskEntity(
            Timestamp lchgTime,
            Double accuracy,
            String classificationReport,
            Double timeElapsed,
            Boolean isComplete,
            String dataset
    ) {
        super(lchgTime);
        this.accuracy = accuracy;
        this.classificationReport = classificationReport;
        this.timeElapsed = timeElapsed;
        this.isComplete = isComplete;
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

    public Double getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(Double timeElapsed) {
        this.timeElapsed = timeElapsed;
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
}

