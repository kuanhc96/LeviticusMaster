package leviticus.master.entity;

import jakarta.persistence.MappedSuperclass;
import leviticus.master.enums.OptimizerType;

import java.sql.Timestamp;

@MappedSuperclass
public abstract class AbstractOptimizerParamsEntity extends AbstractBaseEntity {
    private Long trainId;

    private OptimizerType optimizerType;

    public AbstractOptimizerParamsEntity() {
        super();
    }

    public AbstractOptimizerParamsEntity(Long trainId) {
        super();
        this.trainId = trainId;
    }

    public AbstractOptimizerParamsEntity(Long trainId, OptimizerType optimizerType) {
        super();
        this.trainId = trainId;
        this.optimizerType = optimizerType;
    }

    public AbstractOptimizerParamsEntity(
            Long trainId,
            OptimizerType optimizerType,
            Timestamp lchgTime
    ) {
        super(lchgTime);
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
