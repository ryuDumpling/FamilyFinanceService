<template>
<div class="app-container">
  <!-- 条件查询 一个表单 -->
  <el-form :inline="true" :model="accountQuery" class="demo-ruleForm">
    <el-form-item label="账户名称">
      <el-input v-model="accountQuery.accountDes"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" icon="el-icon-search" size='medium' @click='getAccountQuery()'>查询</el-button>
      <el-button type="warning" icon="el-icon-refresh" size='medium' @click='refreshAccountQuery()'>重置</el-button>
    </el-form-item>
  </el-form>
  <!-- 表格 -->
  <el-table
      :data="accountList" style="width: 100%">
      <el-table-column
        type="index"
        width="50">
      </el-table-column>
      <el-table-column
        prop="accountDes"
        label="账户名称"
        width="180">
      </el-table-column>
      <!-- <el-table-column
        prop="uid"
        label="用户id"
        width="50">
      </el-table-column> -->
      <el-table-column
        prop="accountMoney"
        label="账户总金额"
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
            <el-button type="danger" size='mini' icon='el-icon-delete' @click='del(scope.row.aid)'>删除</el-button>
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
      title="修改账户信息"
      :visible.sync="accountVisible"
      width="70%"
      >
      <!-- 修改account表单 -->
      <el-form :model="accountForm" label-width="80px">
            <el-form-item label="账户名称"  >
              <el-input v-model="accountForm.accountDes"></el-input>
            </el-form-item>
            <el-form-item label="账户金额" >
              <el-input v-model="accountForm.accountMoney"></el-input>
            </el-form-item>
            <el-form-item label="备注" :label-width="formLabelWidth">
              <el-input type="textarea" v-model="accountForm.remark"></el-input>
            </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="accountVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveOrUpdate()">确 定</el-button>
      </span>
    </el-dialog>
</div>
</template>

<script>
  import account from '@/api/account'
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
         accountVisible:false,
         //修改 表单数据
         accountForm:{
           aid:0,
           uid:0,
           accountDes:'',
           accountMoney:0,
           remark:''
         },
          //接收account表格数据
           accountList:[],
           //条件查询
           accountQuery:{
             accountDes:''
           }
       }
     },
     created() {
       //this.listAccount()
       this.listDatas()
     },
     methods:{
      //查询表单方法
      listAccount(){
        account.list().then(response =>{
          this.accountList = response.data
        })
      },
      //查询分页
      listDatas(pageIndex=1){
        this.pageIndex = pageIndex
        console.log(`当前页: ${pageIndex}`);
        account.dataList(this.pageIndex,this.pageSzie,this.accountQuery).then(response =>{
          this.accountList = response.data.records
          this.total = response.data.total
        })
      },
      //添加方法
      add(){
        this.accountForm = {}
        this.accountVisible = true
      },
      //提交表单方法
      saveOrUpdate(){
        if(this.accountForm.aid == 0 || this.accountForm.aid==null){
          this.accountForm = {} //清空对象
          this.accountVisible = false//关闭添加弹窗
          this.listDatas()//刷新表单数据
        } else {
          account.update(this.accountForm).then(response =>{
           this.$message({
             message: response.message,
             type: 'success'
             })
             this.accountForm = {} //清空对象
             this.accountVisible = false//关闭添加弹窗
             this.listDatas()//刷新表单数据
           })
       }
      },
      //条件查询方法
      getAccountQuery(){
        this.listDatas()
      },
      //重置方法
      refreshAccountQuery(){
        this.accountQuery.accountDes = ''
        this.listDatas()
      },

     //修改account信息方法
     update(row){
       this.accountForm.aid = row.aid
       this.accountForm.uid = row.uid
       this.accountForm.accountDes = row.accountDes
       this.accountForm.accountMoney = row.accountMoney
       this.accountForm.remark = row.remark
       this.accountVisible = true
     },
     //删除account信息方法
     del(aid){
       this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
           confirmButtonText: '确定',
           cancelButtonText: '取消',
           type: 'warning'
       })
       .then(() => {
         return account.del(aid)
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
