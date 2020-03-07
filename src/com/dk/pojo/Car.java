package com.dk.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Administrator
 *  * @Entity :声明当前为实体类
 *  * @Table(name="table_book"):映射数据库表
 *  *          name ：表名
 *  *
 *  * @Id ：对应数据库表中的id
 *  * @Column(name="boo_id") :对应表中字段
 *  *    name:映射表中字段的名称，不写默认为当前属性名
 *  *    unique=true :是否唯一，true是 false 否，默认是false
 *  *    nullable：是否可以显示null  true是，false否 默认是true
 *  *    length=11：字段长度
 *  *  @GeneratedValue：定义主键策略
 *  *    strategy=GenerationType.AUTO:自动增长
 *  *    strategy=GenerationType.IDENTITY:采用数据库的自动增长，oracle不能用
 *  *    strategy=GenerationType.SEQUENCE:oracle专用，mysql不能用
 *  *    strategy=GenerationType.TABLE: 根据表产生主键
 *  *
 *  *  @Temporal(TemporaType.DATE):设置时间类型
 *  *     TemporalType.DATE :yyyy-MM-dd
 *  *     TemporalType.TIME :HH:mm:ss
 *  *     TemporalType.TIMESTAMP:yyyy-MM-dd HH:mm:ss
 *  *  @Transient :忽略当前映射
 *  *
 *  */

@Entity
@Table(name = "t_car")
public class Car {

    @Id
    @Column(name = "c_id",unique =true, nullable = false,length = 11)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "c_name")
    private  String name;

    @Column(name = "c_type")
    private  Integer type;

    @Column(name = "c_img")
    private  String img;

    @Temporal(TemporalType.DATE)
    @Column(name = "c_date")
    private Date date;

    @Temporal(TemporalType.DATE)
    @Transient
    private  Date starttime;

    @Temporal(TemporalType.DATE)
    @Transient
    private  Date endtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Car(String name, Integer type, String img, Date date, Date starttime, Date endtime) {
        this.name = name;
        this.type = type;
        this.img = img;
        this.date = date;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", img='" + img + '\'' +
                ", date=" + date +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                '}';
    }
}
