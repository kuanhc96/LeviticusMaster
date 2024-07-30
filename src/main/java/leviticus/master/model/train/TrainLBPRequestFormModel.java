package leviticus.master.model.train;

import leviticus.master.enums.ClassificationModelType;

public class TrainLBPRequestFormModel extends TrainRequestFormModel{

    private Integer numPoints;

    private Integer radius;

    private Double C;

    public TrainLBPRequestFormModel() {
        super(ClassificationModelType.LBP);
    }

    public TrainLBPRequestFormModel(
            String dataset,
            Boolean isTrainOnly
    ) {
        super(ClassificationModelType.LBP, dataset, isTrainOnly);
    }

    public TrainLBPRequestFormModel(
            String dataset,
            Boolean isTrainOnly,
            Integer numPoints,
            Integer radius,
            Double C
    ) {
        super(ClassificationModelType.LBP, dataset, isTrainOnly);
        this.numPoints = numPoints;
        this.radius = radius;
        this.C = C;
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

    public Double getC() {
        return C;
    }

    public void setC(Double c) {
        C = c;
    }
}
