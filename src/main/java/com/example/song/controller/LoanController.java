package com.example.song.controller;

import com.example.song.base.BaseErrorInterfaceInfo;
import com.example.song.base.BaseException;
import com.example.song.base.BaseRspEntity;
import com.example.song.entity.LoanEntity;
import com.example.song.service.LoanService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @ApiOperation(value = "获取金融产品信息", notes = "根据公司id获取单个金融产品信息")
    @RequestMapping(value = "/loan/{id}", method = RequestMethod.GET)
    public Object findOne(@PathVariable("id") long id) throws BaseException {
        return new BaseRspEntity(loanService.findById(id));
    }

    @ApiOperation(value = "获取公司列表", notes = "分页获取公司列表")
    @RequestMapping(value = "/loan", method = RequestMethod.GET)
    public Object findList(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                           @RequestParam(value = "size", required = false, defaultValue = "10") int size,
                           @RequestParam(value = "loanLimit", required = false, defaultValue = "0") long loanLimit) throws BaseException {
        Sort.Order[] orders = new Sort.Order[]{
                new Sort.Order(Sort.Direction.DESC, "updateTime")
        };

        if (0L == loanLimit) {
            return new BaseRspEntity(loanService.findListByPage(new PageRequest(page, size, new Sort(orders))));
        } else {
            return new BaseRspEntity(loanService.findListByLimit(loanLimit, new PageRequest(page, size, new Sort(orders))));
        }
    }

    @ApiOperation(value = "创建公司", notes = "根据实体信息创建公司")
    @ApiImplicitParam(name = "loan", value = "公司详细实体user", required = true, dataType = "LoanEntity")
    @RequestMapping(value = "/loan", method = RequestMethod.POST)
    public Object create(@RequestBody LoanEntity loanEntity) throws BaseException {
        BaseRspEntity baseRspEntity = new BaseRspEntity(BaseErrorInterfaceInfo.CREAT_SUCC);
        baseRspEntity.setResult(loanService.save(loanEntity));
        return baseRspEntity;
    }

    @ApiOperation(value = "更新公司信息", notes = "根据实体信息更新公司信息")
    @ApiImplicitParam(name = "loan", value = "公司详细实体user", required = true, dataType = "LoanEntity")
    @RequestMapping(value = "/loan", method = RequestMethod.PUT)
    public Object update(@RequestBody LoanEntity loanEntity) throws BaseException {
        BaseRspEntity baseRspEntity = new BaseRspEntity(BaseErrorInterfaceInfo.UPDATE_SUCC);
        baseRspEntity.setResult(loanService.update(loanEntity));
        return baseRspEntity;
    }

    @ApiOperation(value = "删除贷款产品信息", notes = "根据请求id删除单个贷款产品信息")
    @RequestMapping(value = "/loan/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable("id") long id) throws BaseException {
        loanService.delete(id);
        BaseRspEntity baseRspEntity = new BaseRspEntity(BaseErrorInterfaceInfo.DELETE_SUCC);
        return baseRspEntity;
    }
}
