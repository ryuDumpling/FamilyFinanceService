<template>
<div class="app-container">
  <!-- 条件查询 一个表单 -->
  <el-form :inline="true" :model="typeQuery" class="demo-ruleForm">
    <el-form-item label="账户类型编码">
      <el-input v-model="typeQuery.typeCode"></el-input>
    </el-form-item>
    <el-form-item label="账户类型名称">
      <el-input v-model="typeQuery.typeName"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" icon="el-icon-search" size='medium' @click='getTypeQuery()'>查询</el-button>
      <el-button type="warning" icon="el-icon-refresh" size='medium' @click='refreshTypeQuery()'>重置</el-button>
    </el-form-item>
  </el-form>
  <!-- 添加 -->
  <div>
    <el-button type="success" size='medium' icon='el-icon-plus' @click='add()'>添加</el-button>
  </div>
  <!-- 表格 -->
  <el-table
      :data="typeList" style="width: 100%">
      <el-table-column
        type="index"
        width="50">
      </el-table-column>
      <el-table-column
        prop="typeCode"
        label="账户类型编码"
        width="180">
      </el-table-column>
      <el-table-column
        prop="typeName"
        label="账户类型名称"
        width="180">
      </el-table-column>
      <el-table-column
        prop="createTime"
        label="创建时间"
        width="180">
      </el-table-column>
      <el-table-column
        prop="updateTime"
        label="修改时间"
        width="180">
      </el-table-column>
      <el-table-column
        prop="remark"
        label="备注"
        width="180">
      </el-table-column>
      <el-table-column
        label="操作">
          <template slot-scope='scope'>
            <el-button type="primary" size='mini' icon='el-icon-edit' @click='update(scope.row)'>修改</el-button>
            <el-button type="danger" size='mini' icon='el-icon-delete' @click='del(scope.row.tid)'>删除</el-button>
          </template>
       </el-table-column>
    </el-table>
    <!-- 分页 -->
    <el-pagination
          @current-change="listDatas"
          :current-page.sync="pageIndex"
          :page-size="pageSzie"
          layout="total, prev, pager, next, jumper"
          style="padding: 30px 0; text-align: center;"
          :total="total">
        </el-pagination>
    <!-- 弹出的添加信息页面 -->
    <el-dialog
      title="添加or修改账户类型信息"
      :visible.sync="typeVisible"
      width="70%"
      >
      <!-- 添加信息表单 -->
      <el-form :model="typeForm" label-width="80px">
            <el-form-item label="账户类型编码"  >
              <el-input v-model="typeForm.typeCode"></el-input>
            </el-form-item>
            <el-form-item label="账户类型名称" >
              <el-input v-model="typeForm.typeName"></el-input>
            </el-form-item>
            <el-form-item label="备注" :label-width="formLabelWidth">
              <el-input type="textarea" v-model="typeForm.remark"></el-input>
            </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="typeVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveOrUpdate()">确 定</el-button>
      </span>
    </el-dialog>
</div>
</template>

<script>
  import type from '@/api/type'
  export default {
     data(){
       return{
         //分页-当前页面
         pageIndex: 1,
         //一页多少条数据
         pageSzie: 5,
         //总共有多少条数据
         total: 0,
         //添加表单对话框显示初始值
         typeVisible:false,
         //添加/修改 表单数据
         typeForm:{
           tid:0,
           typeCode:'',
           typeName:'',
           remark:''
         },
          //接收type表格数据
           typeList:[],
           //条件查询
           typeQuery:{
             typeCode:'',
             typeName:''
           }
       }
     },
     created() {
       //this.listType()
       this.listDatas()
     },
     methods:{
      //查询表单方法
      listType(){
        type.list().then(response =>{
          this.typeList = response.data
        })
      },
      //查询分页
      listDatas(pageIndex=1){
        this.pageIndex = pageIndex
        console.log(`当前页: ${pageIndex}`);
        type.dataList(this.pageIndex,this.pageSzie,this.typeQuery).then(response =>{
          this.typeList = response.data.records
          this.total = response.data.total
        })
      },
      //添加方法
      add(){
        this.typeForm = {}
        this.typeVisible = true
      },
      //提交表单方法
      saveOrUpdate(){
        if(this.typeForm.tid == 0 || this.typeForm.tid==null){
          type.add(this.typeForm).then(response =>{
           this.$message({
             message: response.message,
             type: 'success'
             })
             this.typeForm = {} //清空对象
             this.typeVisible = false//关闭添加弹窗
             this.listDatas()//刷新表单数据
           })
        } else {
          type.update(this.typeForm).then(response =>{
           this.$message({
             message: response.message,
             type: 'success'
             })
             this.typeForm = {} //清空对象
             this.typeVisible = false//关闭添加弹窗
             this.listDatas()//刷新表单数据
           })
       }
      },
      //条件查询方法
      getTypeQuery(){
        this.listDatas()
      },
      //重置方法
      refreshTypeQuery(){
        this.typeQuery.typeCode = ''
        this.typeQuery.typeName = ''
        this.listDatas()
      },

     //修改type信息方法
     update(row){
       this.typeForm.tid = row.tid
       this.typeForm.typeCode = row.typeCode
       this.typeForm.typeName = row.typeName
       this.typeForm.remark = row.remark
       this.typeVisible = true
     },
     //删除type信息方法
     del(tid){
       this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
           confirmButtonText: '确定',
           cancelButtonText: '取消',
           type: 'warning'
       })
       .then(() => {
         return type.del(tid)
       })
       .then(response => {
         this.$message({
           message: response.message,
           type: 'success'
         })
         this.listDatas() // 查询方法。
       })
       //捕获删除异常
       .catch(error => {
         console.log('catch的error', error)
         if (error === 'cancel') {
           this.$message({
             type: 'info',
             message: '已取消删除'
           })
         }
       })
      }
    }
  }
</script>

<style>
</style>
