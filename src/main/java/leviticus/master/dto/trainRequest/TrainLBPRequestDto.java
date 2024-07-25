package leviticus.master.dto.trainRequest;

public class TrainLBPRequestDto extends TrainRequestDto {
    private Integer numPoints;
    private Integer radius;
    private Double cValue;

    public TrainLBPRequestDto() {
        super();
    }

    public TrainLBPRequestDto(Long taskId, Boolean trainOnly, String dataset, Integer numPoints, Integer radius, Double cValue) {
        super(taskId, trainOnly, dataset);
        this.numPoints = numPoints;
        this.radius = radius;
        this.cValue = cValue;
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

    public Double getcValue() {
        return cValue;
    }

    public void setcValue(Double cValue) {
        this.cValue = cValue;
    }

}
