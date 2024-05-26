package leviticus.master.entity.modelParamsEntity;

import jakarta.persistence.Entity;
import leviticus.master.entity.AbstractModelParamsEntity;

import java.sql.Timestamp;

@Entity
public class CNNModelParamsEntity extends AbstractModelParamsEntity {
    private Integer resizedX;
    private Integer resizedY;
    private Integer numClasses;
    private Integer batchSize;
    private Integer epochs;

    public CNNModelParamsEntity() {}

    public CNNModelParamsEntity(
            Long trainId,
            Double accuracy,
            String classificationReport,
            Double trainTime,
            Timestamp lchgTime,
            Integer resizedX,
            Integer resizedY,
            Integer numClasses,
            Integer batchSize,
            Integer epochs
    ) {
        super(
                trainId,
                accuracy,
                classificationReport,
                trainTime,
                lchgTime
        );
        this.resizedX = resizedX;
        this.resizedY = resizedY;
        this.numClasses = numClasses;
        this.batchSize = batchSize;
        this.epochs = epochs;
    }

    public Integer getResizedX() {
        return resizedX;
    }

    public void setResizedX(Integer resizedX) {
        this.resizedX = resizedX;
    }

    public Integer getResizedY() {
        return resizedY;
    }

    public void setResizedY(Integer resizedY) {
        this.resizedY = resizedY;
    }

    public Integer getNumClasses() {
        return numClasses;
    }

    public void setNumClasses(Integer numClasses) {
        this.numClasses = numClasses;
    }

    public Integer getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(Integer batchSize) {
        this.batchSize = batchSize;
    }

    public Integer getEpochs() {
        return epochs;
    }

    public void setEpochs(Integer epochs) {
        this.epochs = epochs;
    }
}
