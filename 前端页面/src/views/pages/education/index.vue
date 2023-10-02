<template>
<div class="app-container">
  <!-- 条件查询 一个表单 -->
  <el-form :inline="true" :model="educationQuery" class="demo-ruleForm">
    <el-form-item label="学历编码">
      <el-input v-model="educationQuery.educationCode"></el-input>
    </el-form-item>
    <el-form-item label="学历名称">
      <el-input v-model="educationQuery.educationName"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" icon="el-icon-search" size='medium' @click='getEducationQuery()'>查询</el-button>
      <el-button type="warning" icon="el-icon-refresh" size='medium' @click='refreshEducationQuery()'>重置</el-button>
    </el-form-item>
  </el-form>
  <!-- 添加 -->
  <div>
    <el-button type="success" size='medium' icon='el-icon-plus' @click='add()'>添加</el-button>
  </div>
  <!-- 表格 -->
  <el-table
      :data="educationList" style="width: 100%">
      <el-table-column
        type="index"
        width="50">
      </el-table-column>
      <el-table-column
        prop="educationCode"
        label="学历编码"
        width="180">
      </el-table-column>
      <el-table-column
        prop="educationName"
        label="学历名称"
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
            <el-button type="danger" size='mini' icon='el-icon-delete' @click='del(scope.row.eid)'>删除</el-button>
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
      title="添加or修改学历信息"
      :visible.sync="educationVisible"
      width="70%"
      >
      <!-- 添加信息表单 -->
      <el-form :model="educationForm" label-width="80px">
            <el-form-item label="学历编码"  >
              <el-input v-model="educationForm.educationCode"></el-input>
            </el-form-item>
            <el-form-item label="学历名称" >
              <el-input v-model="educationForm.educationName"></el-input>
            </el-form-item>
            <el-form-item label="备注" :label-width="formLabelWidth">
              <el-input type="textarea" v-model="educationForm.remark"></el-input>
            </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="educationVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveOrUpdate()">确 定</el-button>
      </span>
    </el-dialog>
</div>
</template>

<script>
  import education from '@/api/education'
  export default {
     data(){
       return{
         //分页-当前页面
         pageIndex: 1,
         //一页多少条数据
         pageSzie: 2,
         //总共有多少条数据
         total: 0,
         //添加表单对话框显示初始值
         educationVisible:false,
         //添加/修改 表单数据
         educationForm:{
           eid:0,
           educationCode:'',
           educationName:'',
           remark:''
         },
          //接收education表格数据
           educationList:[],
           //条件查询
           educationQuery:{
             educationCode:'',
             educationName:''
           }
       }
     },
     created() {
       //this.listEducation()
       this.listDatas()
     },
     methods:{
      //查询表单方法
      listEducation(){
        education.list().then(response =>{
          this.educationList = response.data
        })
      },
      //查询分页
      listDatas(pageIndex=1){
        this.pageIndex = pageIndex
        console.log(`当前页: ${pageIndex}`);
        education.dataList(this.pageIndex,this.pageSzie,this.educationQuery).then(response =>{
          this.educationList = response.data.records
          this.total = response.data.total
        })
      },
      //添加方法
      add(){
        this.educationForm = {}
        this.educationVisible = true
      },
      //提交表单方法
      saveOrUpdate(){
        if(this.educationForm.eid == 0 || this.educationForm.eid==null){
          education.add(this.educationForm).then(response =>{
           this.$message({
             message: response.message,
             type: 'success'
             })
             this.educationForm = {} //清空对象
             this.educationVisible = false//关闭添加弹窗
             this.listDatas()//刷新表单数据
           })
        } else {
          education.update(this.educationForm).then(response =>{
           this.$message({
             message: response.message,
             type: 'success'
             })
             this.educationForm = {} //清空对象
             this.educationVisible = false//关闭添加弹窗
             this.listDatas()//刷新表单数据
           })
       }
      },
      //条件查询方法
      getEducationQuery(){
        this.listDatas()
      },
      //重置方法
      refreshEducationQuery(){
        this.educationQuery.educationCode = ''
        this.educationQuery.educationName = ''
        this.listDatas()
      },

     //修改education信息方法
     update(row){
       this.educationForm.eid = row.eid
       this.educationForm.educationCode = row.educationCode
       this.educationForm.educationName = row.educationName
       this.educationForm.remark = row.remark
       this.educationVisible = true
     },
     //删除education信息方法
     del(eid){
       this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
           confirmButtonText: '确定',
           cancelButtonText: '取消',
           type: 'warning'
       })
       .then(() => {
         return education.del(eid)
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
