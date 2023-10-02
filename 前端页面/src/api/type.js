import request from '@/utils/request'

export default {
  //条件查询带分页
  dataList(pageIndex,pageSize,type){
    return request({
      url: `/type/listData/${pageIndex}/${pageSize}`,
      method: 'post',
      data: type
    })
  },
  // 查询所有type不分页
  list() {
    return request({
      url: '/type/list',
      method: 'get'
    })
  },
  //添加type信息
  add(typeData) {
    return request({
      url: '/type/add',
      method: 'post',
      data: typeData
    })
  },

  //修改type信息
  update(typeData) {
      return request({
        url: '/type/update',
        method: 'put',
        data: typeData
      })
  },

  //删除type信息
  del(eid) {
      return request({
        url: '/type/del/' + eid,
        method: 'delete'
      })
  }
}
