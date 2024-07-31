package leviticus.master.dto.predictRequest;

public class PredictMiniVGGRequestDto extends PredictRequestDto {
    public PredictMiniVGGRequestDto() {
        super();
    }

    public PredictMiniVGGRequestDto(Long trainId) {
        super(trainId);
    }

    public PredictMiniVGGRequestDto(Long trainId, String trainDataset, String predictDataset, String weightsFile) {
        super(trainId, trainDataset, predictDataset, weightsFile);
    }
}
