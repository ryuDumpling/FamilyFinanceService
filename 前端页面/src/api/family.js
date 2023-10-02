import request from '@/utils/request'

export default {
  //条件查询带分页
  dataList(pageIndex,pageSize,family){
    return request({
      url: `/family/listData/${pageIndex}/${pageSize}`,
      method: 'post',
      data: family
    })
  },
  // 查询所有家庭不分页
  list() {
    return request({
      url: '/family/list',
      method: 'get'
    })
  },
  //以fid查询familyName
  findFamilyNameByFid(fid){
    return request({
      url: '/family/findFamilyNameByFid/'+fid,
      method: 'get'
    })
  },
  //添加家庭信息
  add(familyData) {
    return request({
      url: '/family/add',
      method: 'post',
      data: familyData
    })
  },

  //修改家庭信息
  update(familyData) {
      return request({
        url: '/family/update',
        method: 'put',
        data: familyData
      })
  },

  //删除家庭信息
  del(fid) {
      return request({
        url: '/family/del/' + fid,
        method: 'delete'
      })
  }
}
