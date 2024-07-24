package leviticus.master.dto.trainResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TrainResponseDto {
    private Long taskId;
    private String modelPath;
    private Double accuracy;
    private String classificationReport;

    public TrainResponseDto() {}

    public TrainResponseDto(Long taskId, String modelPath, Double accuracy, String classificationReport) {
        this.taskId = taskId;
        this.modelPath = modelPath;
        this.accuracy = accuracy;
        this.classificationReport = classificationReport;
    }


    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getModelPath() {
        return modelPath;
    }

    public void setModelPath(String modelPath) {
        this.modelPath = modelPath;
    }

    public Double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }

    public String getClassificationReport() {
        return classificationReport;
    }

    public void setClassificationReport(String classificationReport) {
        this.classificationReport = classificationReport;
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
