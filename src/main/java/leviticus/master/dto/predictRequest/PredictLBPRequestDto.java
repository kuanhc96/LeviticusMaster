package leviticus.master.dto.predictRequest;

public class PredictLBPRequestDto extends PredictRequestDto {
    private Integer numPoints;
    private Integer radius;

    public PredictLBPRequestDto() {
        super();
    }

    public PredictLBPRequestDto(Long trainId) {
        super(trainId);
    }

    public PredictLBPRequestDto(Long trainId, String trainDataset, String predictDataset) {
        super(trainId, trainDataset, predictDataset);

    }

    public PredictLBPRequestDto(
            Long trainId,
            String trainDataset,
            String predictDataset,
            Integer numPoints,
            Integer radius
    ) {
        super(trainId, trainDataset, predictDataset);
        this.numPoints = numPoints;
        this.radius = radius;
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
