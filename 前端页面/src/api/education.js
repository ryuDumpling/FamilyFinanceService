import request from '@/utils/request'

export default {
  //条件查询带分页
  dataList(pageIndex,pageSize,education){
    return request({
      url: `/education/listData/${pageIndex}/${pageSize}`,
      method: 'post',
      data: education
    })
  },
  // 查询所有education不分页
  list() {
    return request({
      url: '/education/list',
      method: 'get'
    })
  },
  //添加education信息
  add(educationData) {
    return request({
      url: '/education/add',
      method: 'post',
      data: educationData
    })
  },

  //修改education信息
  update(educationData) {
      return request({
        url: '/education/update',
        method: 'put',
        data: educationData
      })
  },

  //删除education信息
  del(eid) {
      return request({
        url: '/education/del/' + eid,
        method: 'delete'
      })
  }
}
