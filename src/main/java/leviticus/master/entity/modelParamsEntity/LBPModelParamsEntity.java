package leviticus.master.entity.modelParamsEntity;

import jakarta.persistence.Entity;
import leviticus.master.entity.AbstractModelParamsEntity;

import java.sql.Timestamp;

@Entity
public class LBPModelParamsEntity extends AbstractModelParamsEntity {
    private Double c;

    private Integer numPoints;

    private Integer radius;

    public LBPModelParamsEntity() {
        super();
    }

    public LBPModelParamsEntity(Timestamp lchgTime) {
        super(lchgTime);
    }

    public LBPModelParamsEntity(
            Double c,
            Integer numPoints,
            Integer radius,
            Long trainId
    ) {
        super(trainId);
        this.c = c;
        this.numPoints = numPoints;
        this.radius = radius;

    }

    public LBPModelParamsEntity(
            Double c,
            Integer numPoints,
            Integer radius,
            Long trainId,
            Timestamp lchgTime
    ) {
        super(trainId, lchgTime);
        this.c = c;
        this.numPoints = numPoints;
        this.radius = radius;
    }

    public Double getC() {
        return c;
    }

    public void setC(Double c) {
        this.c = c;
    }

    public Integer getNumPoints() {
        return numPoints;
    }

    public void setNumPoints(Integer numPoints) {
        this.numPoints = numPoints;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }
}
