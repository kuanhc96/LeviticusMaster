package leviticus.master.dto.predictResponse;

import java.util.Map;

public class PredictResponseDto {
    private Double accuracy;
    private String classificationReport;
    private Map<String, String> predictions;

    public PredictResponseDto(Double accuracy, String classificationReport, Map<String, String> predictions) {
        this.accuracy = accuracy;
        this.classificationReport = classificationReport;
        this.predictions = predictions;
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

    public Map<String, String> getPredictions() {
        return predictions;
    }

    public void setPredictions(Map<String, String> predictions) {
        this.predictions = predictions;
    }
}
