package leviticus.master.entity.taskEntity;

import jakarta.persistence.Entity;
import leviticus.master.entity.AbstractTaskEntity;
import leviticus.master.enums.ClassificationModelType;
import leviticus.master.enums.OptimizerType;

import java.sql.Timestamp;

@Entity
public class TrainTaskEntity extends AbstractTaskEntity {

    private ClassificationModelType modelType;

    private OptimizerType optimizerType;

    private String weightsFile;

    private String dataset;

    private Boolean isComplete;

    private Boolean isCrossValidated;

    private Boolean isTrainOnly;

    public TrainTaskEntity() {
        super();
    }

    public TrainTaskEntity(Timestamp lchgTime) {
        super(lchgTime);
    }

    public TrainTaskEntity(
            ClassificationModelType modelType,
            OptimizerType optimizerType,
            String weightsFile,
            Boolean isCrossValidated,
            Boolean isTrainOnly,
            Double accuracy,
            String classificationReport,
            Double timeElapsed,
            Boolean isComplete,
            String dataset
    ) {
        super(accuracy, classificationReport, timeElapsed, isComplete, dataset);
        this.modelType = modelType;
        this.optimizerType = optimizerType;
        this.weightsFile = weightsFile;
        this.dataset = dataset;
        this.isComplete = isComplete;
        this.isCrossValidated = isCrossValidated;
        this.isTrainOnly = isTrainOnly;
    }

    public TrainTaskEntity(
            ClassificationModelType modelType,
            OptimizerType optimizerType,
            String weightsFile,
            Boolean isCrossValidated,
            Boolean isTrainOnly,
            Double accuracy,
            String classificationReport,
            Double timeElapsed,
            Boolean isComplete,
            String dataset,
            Timestamp lchgTime
    ) {
        super(lchgTime, accuracy, classificationReport, timeElapsed, isComplete, dataset);
        this.modelType = modelType;
        this.optimizerType = optimizerType;
        this.weightsFile = weightsFile;
        this.dataset = dataset;
        this.isComplete = isComplete;
        this.isCrossValidated = isCrossValidated;
        this.isTrainOnly = isTrainOnly;
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

    public Boolean isComplete() {
        return isComplete;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }

    public Boolean isTrainOnly() {
        return isTrainOnly;
    }

    /** @noinspection checkstyle:HiddenField*/
    public void setTrainOnly(Boolean isTrainOnly) {
        this.isTrainOnly = isTrainOnly;
    }

    public Boolean isCrossValidated() {
        return isCrossValidated;
    }

    public void setCrossValidated(Boolean crossValidated) {
        isCrossValidated = crossValidated;
    }

    public OptimizerType getOptimizerType() {
        return optimizerType;
    }

    public void setOptimizerType(OptimizerType optimizerType) {
        this.optimizerType = optimizerType;
    }
}
