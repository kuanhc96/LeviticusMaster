package leviticus.master.entity;

import jakarta.persistence.Entity;
import leviticus.master.enums.OptimizerType;

@Entity
public abstract class AbstractOptimizerParamsEntity {
    private Long trainId;

    private OptimizerType optimizerType;

    public AbstractOptimizerParamsEntity() {}

    public AbstractOptimizerParamsEntity(Long trainId, OptimizerType optimizerType) {
        this.trainId = trainId;
        this.optimizerType = optimizerType;
    }

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public OptimizerType getOptimizerType() {
        return optimizerType;
    }

    public void setOptimizerType(OptimizerType optimizerType) {
        this.optimizerType = optimizerType;
    }
}
