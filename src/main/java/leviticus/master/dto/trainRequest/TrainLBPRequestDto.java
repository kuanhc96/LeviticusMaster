package leviticus.master.dto;

public class TrainLBPDto extends TrainDto {
    private Long taskId;
    private Boolean trainOnly;
    private String dataset;
    private Integer numPoints;
    private Integer radius;
    private Double C;

    public TrainLBPDto() {}

    public TrainLBPDto(Long taskId, Boolean trainOnly, String dataset, Integer numPoints, Integer radius, Double c) {
        super(taskId, trainOnly, dataset);
        this.numPoints = numPoints;
        this.radius = radius;
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

    public Double getC() {
        return C;
    }

    public void setC(Double c) {
        C = c;
    }

}
