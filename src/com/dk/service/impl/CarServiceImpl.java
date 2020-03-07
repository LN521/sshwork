package com.dk.service.impl;

import com.dk.dao.CarDao;
import com.dk.pojo.Car;
import com.dk.service.CarService;
import com.dk.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;

    @Override
    public PageBean<Car> findinfo(Car car, Integer pageNumber) {
        PageBean<Car> page =new PageBean<>();
        page.setPageNumber(pageNumber);
        page.setPageSize(3);

        page=carDao.findinfo(page,car);

        return page;
    }

    @Override
    public void addcar(Car car) {
        carDao.addcar(car);
    }

    @Override
    public Car findone(Integer id) {
        Car car =carDao.findone(id);
        return car;
    }

    @Override
    public void deletebyids(String ids) {
        carDao.deletebyids(ids);
    }

    @Override
    public void deleteone(Integer id) {
        carDao.deleteone(id);
    }

    @Override
    public void updatecar(Car car) {

        carDao.updatecar(car);
    }
}
