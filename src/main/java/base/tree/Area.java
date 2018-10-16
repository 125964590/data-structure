package base.tree;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
//
//    public Area getAreaEntity(List<Area> areas, Long id) {
//    }

    public static void main(String[] args) throws ParseException {
        String str = "2018-10-15T12:05:08.526Z";
        String[] ts = str.split("T", 10);
        String[] split = ts[1].split("\\.", ts[1].length());
        String s = ts[0] + split[0];
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        Date parse = format.parse(s);
        System.out.println(parse.getTime());
    }

}