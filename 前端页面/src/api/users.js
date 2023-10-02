import request from '@/utils/request'

export default {
  //条件查询带分页
  dataList(pageIndex,pageSize,users){
    return request({
      url: `/users/listData/${pageIndex}/${pageSize}`,
      method: 'post',
      data: users
    })
  },
  // 查询所有users不分页
  list() {
    return request({
      url: '/users/list',
      method: 'get'
    })
  },

  //添加users信息
  add(usersData) {
    return request({
      url: '/users/add',
      method: 'post',
      data: usersData
    })
  },

  //修改users信息
  update(usersData) {
      return request({
        url: '/users/update',
        method: 'put',
        data: usersData
      })
  },

  //删除users信息
  del(uid) {
      return request({
        url: '/users/del/' + uid,
        method: 'delete'
      })
  }
}
