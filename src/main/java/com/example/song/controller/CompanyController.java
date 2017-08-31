package com.example.song.controller;

import com.example.song.base.BaseException;
import com.example.song.base.BaseRspEntity;
import com.example.song.entity.CompanyEntity;
import com.example.song.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
    public Object findOne(@PathVariable("id") int id) throws BaseException {
        return new BaseRspEntity(companyService.findById(id));
    }

    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public Object findAll() throws BaseException {
        return new BaseRspEntity(companyService.findAll());
    }

    @RequestMapping(value = "/company", method = RequestMethod.POST)
    public Object create(@RequestBody CompanyEntity companyEntity) throws BaseException {
        return new BaseRspEntity(companyService.save(companyEntity));
    }

    @RequestMapping(value = "/company", method = RequestMethod.PUT)
    public Object update(@RequestBody CompanyEntity companyEntity) throws BaseException {
        return new BaseRspEntity(companyService.update(companyEntity));
    }

    @RequestMapping(value = "/company/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) throws BaseException {
        companyService.delete(id);
    }
}
