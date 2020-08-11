package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;

@Service//chi ra day la service
@Transactional//chi ra hoat dong theo co che giao dich
public class ProductService {
    @Autowired//tiem interface vao service
    private ProductRepository repository;
    //chuc nang lay toan bo san pham
    public List<Product> listAll()
    {
        return repository.findAll();
    }
    //chuc nang them san pham
    public void save(Product product)
    {
        repository.save(product);
    }
    //chuc nang lay 1 san pham theo id
    public Product get(long id)
    {
        return repository.findById(id).get();
    }
    //chuc nang xoa san pham
    public void delete(long id)
    {
        repository.deleteById(id);
    }

}
