package leviticus.master.dto.trainResponse;

public class TrainLBPResponseDto extends TrainResponseDto {
    private Double C;
    private Integer numPoints;
    private Integer radius;

    public TrainLBPResponseDto() {
        super();
    }

    public TrainLBPResponseDto(Long taskId, String modelPath, Double accuracy, String classificationReport, Double C, Integer numPoints, Integer radius) {
        super(taskId, modelPath, accuracy, classificationReport);
        this.C = C;
        this.numPoints = numPoints;
        this.radius = radius;
    }

    public Double getC() {
        return C;
    }

    public void setC(Double c) {
        C = c;
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
