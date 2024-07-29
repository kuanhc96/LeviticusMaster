package leviticus.master.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.sql.Timestamp;

@MappedSuperclass
public abstract class AbstractModelParamsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // foreign key
    private Long trainId;

    private Timestamp lchgTime;

    public AbstractModelParamsEntity() {
        this.lchgTime = new Timestamp(System.currentTimeMillis());
    }

    public AbstractModelParamsEntity(Long trainId) {
        this();
        this.trainId = trainId;
    }

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public Timestamp getLchgTime() {
        return lchgTime;
    }
}
