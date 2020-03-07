package com.dk.dao.impl;

import com.dk.dao.CarDao;
import com.dk.pojo.Car;
import com.dk.service.CarService;
import com.dk.utils.PageBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public PageBean<Car> findinfo(PageBean<Car> page, Car car) {

        Session session =sessionFactory.getCurrentSession();
        List<Object> param =new ArrayList<>();

        String hql="from Car where 1=1";
        if (car.getName()!=null && !car.getName().equals("")){
            hql+="and name like ?";
            param.add(car.getName());
        }
        if (car.getType()!=null && !car.getType().equals("") && car.getType()!=-1){
            hql+="and type = ?";
            param.add(car.getType());
        }
        if (car.getStarttime()!=null && !car.getStarttime().equals("")){
            hql+="and date > ?";
            param.add(car.getStarttime());
        }
        if (car.getEndtime()!=null && !car.getEndtime().equals("")){
            hql+="and date < ?";
            param.add(car.getEndtime());
        }

        Query query =session.createQuery(hql);
        for (int i = 0; i < param.size(); i++) {
             query.setParameter(i,param.get(i));
        }

        query.setFirstResult(page.getStartIndex());
        query.setMaxResults(page.getPageSize());

        List<Car> list =query.list();
        page.setResult(list);


        param.clear();
        String hql1="select count(*) from Car  where 1=1";
        if (car.getName()!=null && !car.getName().equals("")){
            hql1+="and name like ?";
            param.add(car.getName());
        }
        if (car.getType()!=null && !car.getType().equals("") && car.getType()!=-1){
            hql1+="and type = ?";
            param.add(car.getType());
        }
        if (car.getStarttime()!=null && !car.getStarttime().equals("")){
            hql1+="and date > ?";
            param.add(car.getStarttime());
        }
        if (car.getEndtime()!=null && !car.getEndtime().equals("")){
            hql1+="and date < ?";
            param.add(car.getEndtime());
        }

        Query query1 =session.createQuery(hql1);
        for (int i = 0; i < param.size(); i++) {
            query1.setParameter(i,param.get(i));
        }


        Long totalcount = (Long)query1.uniqueResult();
        page.setTotalCount(totalcount.intValue());


        return page;
    }

    @Override
    public void addcar(Car car) {
        Session session =sessionFactory.getCurrentSession();

        session.save(car);

    }

    @Override
    public Car findone(Integer id) {
        Session session = sessionFactory.getCurrentSession();

        Car car = (Car) session.get(Car.class,id);

        return car;
    }

    @Override
    public void deletebyids(String ids) {
        Session session = sessionFactory.getCurrentSession();

        Query query =session.createQuery("delete from Car where id in ("+ ids +")");

        query.executeUpdate();


    }

    @Override
    public void deleteone(Integer id) {

        Session session = sessionFactory.getCurrentSession();

        Car car= (Car) session.get(Car.class,id);

        session.delete(car);

    }

    @Override
    public void updatecar(Car car) {

        Session session = sessionFactory.getCurrentSession();

//        session.update(car);
         Car car1 = (Car) session.get(Car.class,car.getId());
         session.clear();

         session.update(car1);
    }

}
