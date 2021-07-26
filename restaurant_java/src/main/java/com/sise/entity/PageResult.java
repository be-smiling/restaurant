package com.sise.entity;

import java.util.List;

/**
 * 分页实体类
 * @param <T>
 */
public class PageResult<T> {
   //总记录数
   private Long total;

   // 每页显示的数据
   private List<T> rows;

   public PageResult() {
   }

   public PageResult(Long total, List<T> rows) {
      this.total = total;
      this.rows = rows;
   }

   public Long getTotal() {
      return total;
   }

   public void setTotal(Long total) {
      this.total = total;
   }

   public List<T> getRows() {
      return rows;
   }

   public void setRows(List<T> rows) {
      this.rows = rows;
   }
}
