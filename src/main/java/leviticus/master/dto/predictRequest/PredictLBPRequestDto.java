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

    public PredictLBPRequestDto(Long trainId, String trainDataset, String predictDataset, String weightsFile) {
        super(trainId, trainDataset, predictDataset, weightsFile);

    }

    public PredictLBPRequestDto(
            Long trainId,
            String trainDataset,
            String predictDataset,
            String weightsFile,
            Integer numPoints,
            Integer radius
    ) {
        super(trainId, trainDataset, predictDataset, weightsFile);
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
