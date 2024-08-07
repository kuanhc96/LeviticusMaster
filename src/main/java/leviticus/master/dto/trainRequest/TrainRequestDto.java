package leviticus.master.dto.trainRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TrainRequestDto {
    private Long taskId;
    private Boolean trainOnly;
    private String dataset;

    public TrainRequestDto() {}

    public TrainRequestDto(Long taskId, Boolean trainOnly, String dataset) {
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

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }

    }
}
