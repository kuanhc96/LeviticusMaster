package leviticus.master.dto;

public class TrainDto {
    private Long taskId;
    private Boolean trainOnly;
    private String dataset;

    public TrainDto() {}

    public TrainDto(Long taskId, Boolean trainOnly, String dataset) {
        this.taskId = taskId;
        this.trainOnly = trainOnly;
        this.dataset = dataset;

    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Boolean getTrainOnly() {
        return trainOnly;
    }

    public void setTrainOnly(Boolean trainOnly) {
        this.trainOnly = trainOnly;
    }

    public String getDataset() {
        return dataset;
    }

    public void setDataset(String dataset) {
        this.dataset = dataset;
    }
}
