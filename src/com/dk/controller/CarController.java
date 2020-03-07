package com.dk.controller;

import com.dk.dao.CarDao;
import com.dk.pojo.Car;
import com.dk.service.CarService;
import com.dk.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("car")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping("findinfo")
    public  String findinfo(Model model, Car car, @RequestParam(value = "pageNumber",required = true,defaultValue = "1") Integer pageNumber){

        PageBean<Car> page =carService.findinfo(car,pageNumber);

        model.addAttribute("pb",page);
        model.addAttribute("car",car);

        return "list";

    }
    @RequestMapping("toadd")
    public  String toadd(){
        return "add";
    }

    @RequestMapping("addcar")
    public  String addcar(Car car, MultipartFile myFile,HttpServletRequest request){

        String filename=upload1(myFile,request);

        car.setImg("products/1/"+filename);

        carService.addcar(car);

        return "redirect:/car/findinfo";

    }

    private String upload1(MultipartFile myFile, HttpServletRequest request) {

         String filename=myFile.getOriginalFilename();

         String  path="E:\\upload\\" +filename;

         File file =new File(path);

        try {
            myFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
       return  filename;
    }

    @RequestMapping("findone")
    public  String findone(Model model,Integer id){

        Car car =carService.findone(id);
        model.addAttribute("c",car);

        return  "update";
    }


    @RequestMapping("updatecar")
    public  String updatecar(Car car,MultipartFile myFile,HttpServletRequest request){

        if (myFile.getOriginalFilename()!=null && !myFile.getOriginalFilename().equals("")){
            String filename=upload1(myFile,request);

            car.setImg("products/1/"+filename);
        }


        carService.updatecar(car);

        return "redirect:/car/findinfo";
    }

    @RequestMapping("deleteone")
    public  String deleteone(Integer id){

        carService.deleteone(id);

        return "redirect:/car/findinfo";
    }
    @RequestMapping("deletebyids")
    public  String deletebyids(String ids){

        carService.deletebyids(ids);

        return "redirect:/car/findinfo";
    }


    /**
     * 本地文件实现下载
     */
    @RequestMapping("upload")
    public  void upload(String filename, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name=new String(filename.getBytes("UTF-8"),"ISO-8859-1");

        String path="E:\\upload\\" +filename;

        File file =new File(path);

        FileInputStream fis =new FileInputStream(file);

        response.setHeader("Content-Disposition","attachment;filename="+name);
        ServletOutputStream os =response.getOutputStream();

        byte [] arr=new byte[1024];
        int b;
        while ((b=fis.read(arr))!=-1){
            os.write(arr);
        }
        os.close();
        fis.close();
    }
}
