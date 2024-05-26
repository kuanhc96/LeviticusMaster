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

    public LBPModelParamsEntity(
            Long trainId,
            Double accuracy,
            String classificationReport,
            Double trainTime,
            Timestamp lchgTime,
            Double c,
            Integer numPoints,
            Integer radius) {
        super(
                trainId,
                accuracy,
                classificationReport,
                trainTime,
                lchgTime
        );
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
