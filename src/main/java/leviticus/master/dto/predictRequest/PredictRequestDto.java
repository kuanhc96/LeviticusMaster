package leviticus.master.dto.predictRequest;

public class PredictRequestDto {

    private Long trainId;
    private String trainDataset;
    private String predictDataset;

    public PredictRequestDto() {}

    public PredictRequestDto(Long trainId) {
        this.trainId = trainId;
    }

    public PredictRequestDto(Long trainId, String trainDataset, String predictDataset) {
        this.trainId = trainId;
        this.trainDataset = trainDataset;
        this.predictDataset = predictDataset;
    }


    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public String getTrainDataset() {
        return trainDataset;
    }

    public void setTrainDataset(String trainDataset) {
        this.trainDataset = trainDataset;
    }

    public String getPredictDataset() {
        return predictDataset;
    }

    public void setPredictDataset(String predictDataset) {
        this.predictDataset = predictDataset;
    }
}
