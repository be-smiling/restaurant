/**
 * 员工相关请求模块
 */
import request from '@/utils/request'

export default {

  // 获取所有员工列表
  getAllEmployeeList: function () {
    return request({
      url: '/employee/getAllEmployeeList',
      method: 'get'
    })
  },

  // 根据id查询员工
  findById: function (id) {
    return request({
      url: `/employee/findById/${id}`,
      method: 'get'
    })
  },

  // 删除员工
  deleteEmployee: function (employeeId) {
    return request({
      method: 'DELETE',
      url: `/employee/${employeeId}`
    })
  },

  // 获取员工列表
  getEmployees: function (page, perPage, employee) {
    return request({
      method: 'POST',
      url: `/employee/findByPage/${page}/${perPage}`,
      data: employee
    })
  },

  // 员工录入
  save: function (employee) {
    return request({
      url: '/employee/save',
      method: 'post',
      data: employee
    })
  },

  // 员工录入
  update: function (id, employee) {
    return request({
      url: `/employee/update/${id}`,
      method: 'put',
      data: employee
    })
  },

  // 员工录入或更新
  saveOrUpdate: function (id, employee) {
    if (id === undefined || id === null || id === '') {
      return this.save(employee)
    } else {
      return this.update(id, employee)
    }
  }
}
