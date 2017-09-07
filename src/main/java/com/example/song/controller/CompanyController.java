package com.example.song.controller;

import com.example.song.base.BaseErrorInterfaceInfo;
import com.example.song.base.BaseException;
import com.example.song.base.BaseRspEntity;
import com.example.song.entity.CompanyEntity;
import com.example.song.service.CompanyService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

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

    @ApiOperation(value = "获取公司列表", notes = "分页获取公司列表")
    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public Object findList(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                           @RequestParam(value = "size", required = false, defaultValue = "10") int size,
                           @RequestParam(value = "updateTime", required = false, defaultValue = "") String updateTime) throws BaseException {
        Sort.Order[] orders = new Sort.Order[]{
                new Sort.Order(Sort.Direction.DESC, "updateTime")
        };

        if (updateTime.isEmpty()) {
            return new BaseRspEntity(companyService.findListByPage(new PageRequest(page, size, new Sort(orders))));
        } else {
            return new BaseRspEntity(companyService.findListByTime(new Timestamp(Long.parseLong(updateTime)), new PageRequest(page, size, new Sort(orders))));
        }
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
    @ApiImplicitParam(name = "company", value = "公司详细实体user", required = true, dataType = "CompanyEntity")
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
