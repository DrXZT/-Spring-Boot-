package com.ptg.formwork.commons;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * className: PageBean
 * description: TODO
 *
 * @author hasee
 * @version 1.0
 * @date 2019/3/14 13:14
 */
@Data
public class PageBean<T> implements Serializable {
    private Integer currentPage = 1;
    private Integer pageSize = 10;
    private Integer totalNum;
    private Integer hasNextPage;
    private Integer totalPage;
    private Integer startIndex;
    private List<T> items;

    public PageBean(Integer currentPage, Integer pageSize, Integer totalNum) {
        super();
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        this.totalPage = (this.totalNum + this.pageSize - 1) / this.pageSize;
        this.startIndex = (this.currentPage - 1) * this.pageSize;
        this.hasNextPage = this.currentPage >= this.totalPage ? 0 : 1;
    }
}
