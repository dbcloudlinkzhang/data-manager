package com.boot.security.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.dao.CollectManageDao;
import com.boot.security.server.model.CollectManage;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/collectManages")
public class CollectManageController {

    @Autowired
    private CollectManageDao collectManageDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public CollectManage save(@RequestBody CollectManage collectManage) {
        collectManageDao.save(collectManage);

        return collectManage;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public CollectManage get(@PathVariable Long id) {
        return collectManageDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public CollectManage update(@RequestBody CollectManage collectManage) {
        collectManageDao.update(collectManage);

        return collectManage;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return collectManageDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<CollectManage> list(PageTableRequest request) {
                return collectManageDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        collectManageDao.delete(id);
    }
}
