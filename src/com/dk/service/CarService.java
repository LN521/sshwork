package com.dk.service;

import com.dk.pojo.Car;
import com.dk.utils.PageBean;

public interface CarService {

    PageBean<Car> findinfo(Car car, Integer pageNumber);

    void addcar(Car car);

    Car findone(Integer id);

    void deletebyids(String ids);

    void deleteone(Integer id);

    void updatecar(Car car);
}
