package eapli.base.warehousemanagement.mappers.dtos;


public class DockDTO {

    public String id;

    public float begin_lenght;

    public float begin_width;

    public float end_lenght;

    public float end_width;

    public float depth_lenght;

    public float depth_width;

    public String accessibility;

    public String status;


    public DockDTO(String id, float begin_lenght, float begin_width, float end_lenght,float end_width, float depth_lenght, float depth_width, String accessibility, String status) {
        this.id = id;
        this.begin_lenght = begin_lenght;
        this.begin_width = begin_width;
        this.end_lenght = end_lenght;
        this.end_width = end_width;
        this.depth_lenght = depth_lenght;
        this.depth_width = depth_width;
        this.accessibility = accessibility;
        this.status = status;
    }

    @Override
    public String toString() {
        return "DockDTO{" +
                "id='" + id + '\'' +
                ", begin_lenght='" + begin_lenght + '\'' +
                ", begin_width='" + begin_width + '\'' +
                ", end_lenght='" + end_lenght + '\'' +
                ", end_width='" + end_width + '\'' +
                ", depth_lenght='" + depth_lenght + '\'' +
                ", depth_width='" + depth_width + '\'' +
                ", accessibility='" + accessibility + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}