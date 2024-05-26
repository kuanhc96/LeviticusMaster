package leviticus.master.entity;

import jakarta.persistence.MappedSuperclass;

import java.sql.Timestamp;

@MappedSuperclass
public abstract class AbstractModelParamsEntity extends AbstractEntity {

    private Long trainId;

    public AbstractModelParamsEntity() {
        super();
    }

    public AbstractModelParamsEntity(Timestamp lchgTime) {
        super(lchgTime);
    }

    public AbstractModelParamsEntity(Long trainId) {
        super();
        this.trainId = trainId;
    }

    public AbstractModelParamsEntity(Long trainId, Timestamp lchgTime) {
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
