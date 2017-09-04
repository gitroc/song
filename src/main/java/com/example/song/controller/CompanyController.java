package com.example.song.controller;

import com.example.song.base.BaseErrorInterfaceInfo;
import com.example.song.base.BaseException;
import com.example.song.base.BaseRspEntity;
import com.example.song.entity.CompanyEntity;
import com.example.song.service.CompanyService;
import com.example.song.utils.ViewFlipperUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @ApiOperation(value = "获取公司信息", notes = "根据公司id获取单个公司信息")
    @RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
    public Object findOne(@PathVariable("id") int id) throws BaseException {
        return new BaseRspEntity(companyService.findById(id));
    }

    @ApiOperation(value = "获取公司列表", notes = "根据请求的page和size获取公司列表")
    @RequestMapping(value = "/company/{page}/{size}", method = RequestMethod.GET)
    public Object findList(@PathVariable("page") int page, @PathVariable("size") int size) throws BaseException {
        return new BaseRspEntity(ViewFlipperUtil.getListByPageSize(page, size, companyService.findAll()));
    }

    @ApiOperation(value = "获取公司列表", notes = "根据请求的time获取公司列表")
    @RequestMapping(value = "company/{time}", method = RequestMethod.GET)
    public Object findList(@PathVariable("time") long time) throws BaseException {
        return new BaseRspEntity(ViewFlipperUtil.getListByTime(time, companyService.findAll()));
    }

    @ApiOperation(value = "获取公司列表", notes = "获取公司全部列表")
    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public Object findAll() throws BaseException {
        return new BaseRspEntity(companyService.findAll());
    }

    @ApiOperation(value = "创建公司", notes = "根据实体信息创建公司")
    @ApiImplicitParam(name = "company", value = "公司详细实体user", required = true, dataType = "CompanyEntity")
    @RequestMapping(value = "/company", method = RequestMethod.POST)
    public Object create(@RequestBody CompanyEntity companyEntity) throws BaseException {
        BaseRspEntity baseRspEntity = new BaseRspEntity(BaseErrorInterfaceInfo.CREAT_SUCC);
        baseRspEntity.setResult(companyService.save(companyEntity));
        return baseRspEntity;
    }

    @ApiOperation(value = "更新公司信息", notes = "根据实体信息更新公司信息")
    @RequestMapping(value = "/company", method = RequestMethod.PUT)
    public Object update(@RequestBody CompanyEntity companyEntity) throws BaseException {
        BaseRspEntity baseRspEntity = new BaseRspEntity(BaseErrorInterfaceInfo.UPDATE_SUCC);
        baseRspEntity.setResult(companyService.update(companyEntity));
        return baseRspEntity;
    }

    @ApiOperation(value = "删除公司", notes = "根据请求id删除公司")
    @RequestMapping(value = "/company/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable("id") int id) throws BaseException {
        companyService.delete(id);
        BaseRspEntity baseRspEntity = new BaseRspEntity(BaseErrorInterfaceInfo.DELETE_SUCC);
        return baseRspEntity;
    }
}
