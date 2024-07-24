package leviticus.master.dto;

public class TrainMiniVGGDto extends TrainDto {
    private Long taskId;
    private Boolean trainOnly;
    private String dataset;

    public TrainMiniVGGDto() {}

    public TrainMiniVGGDto(Long taskId, Boolean trainOnly, String dataset) {
        super(taskId, trainOnly, dataset);
    }
}
