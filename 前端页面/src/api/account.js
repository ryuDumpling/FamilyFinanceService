import request from '@/utils/request'

export default {
  //条件查询带分页
  dataList(pageIndex,pageSize,account){
    return request({
      url: `/account/listData/${pageIndex}/${pageSize}`,
      method: 'post',
      data: account
    })
  },
  // 查询所有account不分页
  list() {
    return request({
      url: '/account/list',
      method: 'get'
    })
  },
  //添加account信息
  add(accountData) {
    return request({
      url: '/account/add',
      method: 'post',
      data: accountData
    })
  },

  //修改account信息
  update(accountData) {
      return request({
        url: '/account/update',
        method: 'put',
        data: accountData
      })
  },

  //删除account信息
  del(eid) {
      return request({
        url: '/account/del/' + eid,
        method: 'delete'
      })
  }
}
