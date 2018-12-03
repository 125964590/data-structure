package base.tree;

import java.util.List;

/**
 * @author zhengyi
 * @date 2018/10/16 11:28 AM
 **/
public class Area {
    private Long id;
    private Long pId;
    private String name;

    public Area() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", pId=" + pId +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getSecondArea(List<Area> areas, Long id) {

        return -1L;
    }

    public Area getEntity(List<Area> areas, Long id) {
        return null;
    }

}