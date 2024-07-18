package leviticus.master.dto;

public class TrainLBPDto {
    private Long taskId;
    private Boolean trainOnly;
    private String dataset;
    private Integer numPoints;
    private Integer radius;
    private Double C;

    public TrainLBPDto() {}

    public TrainLBPDto(Long taskId, Boolean trainOnly, String dataset, Integer numPoints, Integer radius, Double c) {
        this.taskId = taskId;
        this.trainOnly = trainOnly;
        this.dataset = dataset;
        this.numPoints = numPoints;
        this.radius = radius;
        C = c;
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

    @Override
    public String toString() {
        String jsonData = "" +
                "{" +
                "\"taskId\":" + taskId + "," +
                "\"trainOnly\":\"" + trainOnly + "\"," +
                "\"dataset\":\"" + dataset + "\"," +
                "\"numPoints\":" + numPoints + "," +
                "\"radius\":" + radius + "," +
                "\"C\":" + C +
                "}";
        return jsonData;
    }
}
