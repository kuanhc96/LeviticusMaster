package leviticus.master.entity.taskEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import leviticus.master.entity.AbstractBaseEntity;
import leviticus.master.enums.ClassificationModelType;
import leviticus.master.enums.OptimizerType;

import java.sql.Timestamp;

@Entity
public class TrainTaskEntity extends AbstractBaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

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

    public TrainTaskEntity(
            ClassificationModelType modelType,
            OptimizerType optimizerType,
            String weightsFile,
            String dataset,
            Boolean isComplete,
            Boolean isCrossValidated,
            Boolean isTrainOnly
    ) {
        super();
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
            String dataset,
            Boolean isComplete,
            Boolean isCrossValidated,
            Boolean isTrainOnly,
            Timestamp lchgTime
    ) {
        super(lchgTime);
        this.modelType = modelType;
        this.optimizerType = optimizerType;
        this.weightsFile = weightsFile;
        this.dataset = dataset;
        this.isComplete = isComplete;
        this.isCrossValidated = isCrossValidated;
        this.isTrainOnly = isTrainOnly;
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
