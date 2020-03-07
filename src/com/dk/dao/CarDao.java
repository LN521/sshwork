package com.dk.dao;

import com.dk.pojo.Car;
import com.dk.utils.PageBean;

public interface CarDao {


    PageBean<Car> findinfo(PageBean<Car> page, Car car);

    void addcar(Car car);

    Car findone(Integer id);

    void deletebyids(String ids);

    void deleteone(Integer id);

    void updatecar(Car car);
}
