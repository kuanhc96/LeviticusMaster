package leviticus.master.entity;

import jakarta.persistence.MappedSuperclass;

import java.sql.Timestamp;

@MappedSuperclass
public abstract class AbstractOptimizerParamsEntity extends AbstractBaseEntity {
    private Long trainId;

    public AbstractOptimizerParamsEntity() {
        super();
    }

    public AbstractOptimizerParamsEntity(Long trainId) {
        super();
        this.trainId = trainId;
    }

    public AbstractOptimizerParamsEntity(
            Long trainId,
            Timestamp lchgTime
    ) {
        super(lchgTime);
        this.trainId = trainId;
    }

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

}
