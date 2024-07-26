package leviticus.master.dto.trainResponse;

public class TrainLBPResponseDto extends TrainResponseDto {
    private Double cValue;
    private Integer numPoints;
    private Integer radius;

    public TrainLBPResponseDto() {
        super();
    }

    public TrainLBPResponseDto(Long taskId, String modelPath, Double accuracy, String classificationReport, Double cValue, Integer numPoints, Integer radius) {
        super(taskId, modelPath, accuracy, classificationReport);
        this.cValue = cValue;
        this.numPoints = numPoints;
        this.radius = radius;
    }

    public Double getcValue() {
        return cValue;
    }

    public void setcValue(Double cValue) {
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
}
