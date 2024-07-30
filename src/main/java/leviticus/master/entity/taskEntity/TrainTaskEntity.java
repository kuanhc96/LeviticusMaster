package leviticus.master.entity.taskEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import leviticus.master.entity.AbstractTaskEntity;
import leviticus.master.enums.ClassificationModelType;
import leviticus.master.enums.OptimizerType;

import java.sql.Timestamp;

@Entity
public class TrainTaskEntity extends AbstractTaskEntity {

    private OptimizerType optimizerType;

    private String weightsFile;

    private Boolean isTrainOnly;

    private String dataset;

    private Double accuracy;

    @Column(length=1024)
    private String classificationReport;

    // default: everything
    // manually fill in needed parameters later with setters
    public TrainTaskEntity() {
        super();
        optimizerType = OptimizerType.DEFAULT;
    }

    // default: optimizerType
    // manually fill in model type at instantiation
    public TrainTaskEntity(ClassificationModelType modelType) {
        super(modelType);
        optimizerType = OptimizerType.DEFAULT;
    }

    // default: lchgTime
    // default: isComplete
    // default: timeElapsed
    // manually fill in all other parameters at instantiation
    public TrainTaskEntity(
            ClassificationModelType modelType,
            OptimizerType optimizerType,
            String weightsFile,
            Boolean isTrainOnly,
            String dataset,
            Double accuracy,
            String classificationReport
    ) {
        super(modelType);
        this.optimizerType = optimizerType;
        this.weightsFile = weightsFile;
        this.isTrainOnly = isTrainOnly;
        this.dataset = dataset;
        this.accuracy = accuracy;
        this.classificationReport = classificationReport;
    }

    // default: lchgTime
    // default: isComplete
    // default: timeElapsed
    // manually fill in all other parameters at instantiation
    public TrainTaskEntity(
            ClassificationModelType modelType,
            Timestamp lchgTime,
            Boolean isComplete,
            Double timeElapsed,
            OptimizerType optimizerType,
            String weightsFile,
            Boolean isTrainOnly,
            String dataset,
            Double accuracy,
            String classificationReport
    ) {
        super(modelType, lchgTime, timeElapsed, isComplete);
        this.optimizerType = optimizerType;
        this.weightsFile = weightsFile;
        this.isTrainOnly = isTrainOnly;
        this.dataset = dataset;
        this.accuracy = accuracy;
        this.classificationReport = classificationReport;
    }


    public String getWeightsFile() {
        return weightsFile;
    }

    public void setWeightsFile(String weightsFile) {
        this.weightsFile = weightsFile;
    }

    public Boolean isTrainOnly() {
        return isTrainOnly;
    }

    /** @noinspection checkstyle:HiddenField*/
    public void setTrainOnly(Boolean isTrainOnly) {
        this.isTrainOnly = isTrainOnly;
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
}
