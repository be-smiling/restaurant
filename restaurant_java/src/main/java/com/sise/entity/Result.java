package com.sise.entity;

/*
{
  "code": 0,
  "flag": true,
  "message": "string",
  "data": {
    "total": 0,
    "rows": [
      {
        "id": "string",
        "labelname": "string",
        "state": "string",
        "count": 0,
        "recommend": "string"
      }
    ]
  }
}
 */
public class Result {
   //结果状态码
   private Integer code;
   //成功标记
   private Boolean flag;
   //请求结果信息
   private String message;
   //如果是查询=>在该属性中表达
   private Object data;

   public Result(String message) {
      this.message = message;
   }

   public Result(String message, Object data) {
      this.message = message;
      this.data = data;
   }

   public Result() {
   }



   public Result(Integer code, Boolean flag, String message) {
      this.code = code;
      this.flag = flag;
      this.message = message;
   }

   public Result( Boolean flag, Integer code, String message) {
      this.code = code;
      this.flag = flag;
      this.message = message;
   }

   public Result(Integer code, Boolean flag, String message, Object data) {
      this.code = code;
      this.flag = flag;
      this.message = message;
      this.data = data;
   }
   public Result(Boolean flag, Integer code,  String message, Object data) {
      this.code = code;
      this.flag = flag;
      this.message = message;
      this.data = data;
   }

   public Integer getCode() {
      return code;
   }

   public void setCode(Integer code) {
      this.code = code;
   }

   public Boolean getFlag() {
      return flag;
   }

   public void setFlag(Boolean flag) {
      this.flag = flag;
   }

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   public Object getData() {
      return data;
   }

   public void setData(Object data) {
      this.data = data;
   }
}
