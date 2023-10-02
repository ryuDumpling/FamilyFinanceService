<template>
  <div class="app-container">
      <!-- 条件查询 一个表单 -->
      <el-form :inline="true" :model="familyQuery" class="demo-ruleForm">
        <el-form-item label="家庭编码">
          <el-input v-model="familyQuery.familyCode"></el-input>
        </el-form-item>
        <el-form-item label="家庭名称">
          <el-input v-model="familyQuery.familyName"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" size='medium' @click='getFamilyQuery()'>查询</el-button>
          <el-button type="warning" icon="el-icon-refresh" size='medium' @click='refreshFamilyQuery()'>重置</el-button>
        </el-form-item>
      </el-form>
      <!-- 添加 -->
      <div>
        <el-button type="success" size='medium' icon='el-icon-plus' @click='add()'>添加</el-button>
      </div>
      <!-- 表格 -->
      <el-table
          :data="familyList" style="width: 100%">
          <el-table-column
            type="index"
            width="50">
          </el-table-column>
          <el-table-column
            prop="familyCode"
            label="家庭编码"
            width="180">
          </el-table-column>
          <el-table-column
            prop="familyName"
            label="家庭名称"
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
                <el-button type="danger" size='mini' icon='el-icon-delete' @click='del(scope.row.fid)'>删除</el-button>
              </template>
           </el-table-column>
        </el-table>
      <!-- 分页 -->
     <!-- <el-pagination
          :current-page="pageIndex"
          :page-size="pageSize"
          :total="total"
          style="padding: 30px 0; text-align: center;"
          layout="total, prev, pager, next, jumper"
          @current-change="listDatas"
        /> -->
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
    title="添加or修改家庭信息"
    :visible.sync="familyVisible"
    width="70%"
    >
    <!-- 添加信息表单 -->
    <el-form :model="familyForm" label-width="80px">
          <el-form-item label="家庭编码"  >
            <el-input v-model="familyForm.familyCode"></el-input>
          </el-form-item>
          <el-form-item label="家庭名称" >
            <el-input v-model="familyForm.familyName"></el-input>
          </el-form-item>
          <el-form-item label="备注" :label-width="formLabelWidth">
            <el-input type="textarea" v-model="familyForm.remark"></el-input>
          </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="familyVisible = false">取 消</el-button>
      <el-button type="primary" @click="saveOrUpdate()">确 定</el-button>
    </span>
  </el-dialog>
  </div>
</template>

<script>
  import family from '@/api/family'
  export default {
     data(){
       return{
         //分页-当前页面
         pageIndex: 1,
         //一页多少条数据
         pageSzie: 4,
         //总共有多少条数据
         total: 0,
         //添加表单对话框显示初始值
         familyVisible:false,
         //添加/修改 表单数据
         familyForm:{
           fid:0,
           familyCode:'',
           familyName:'',
           remark:''
         },
         //接收family表格数据
          familyList:[],
          //条件查询
          familyQuery:{
            familyCode:'',
            familyName:''
          }
       }
     },
     created() {
       // 初始函数
       //this.listFamily()
       this.listDatas()
     },
     methods:{
       //查询分页
       listDatas(pageIndex=1){
         this.pageIndex = pageIndex
         console.log(`当前页: ${pageIndex}`);
         family.dataList(this.pageIndex,this.pageSzie,this.familyQuery).then(response =>{
           this.familyList = response.data.records
           this.total = response.data.total
         })
       },
       //添加方法
       add(){
         this.familyForm = {}
         this.familyVisible = true
       },
       //提交表单方法
       saveOrUpdate(){
         if(this.familyForm.fid == 0 || this.familyForm.fid==null){
           family.add(this.familyForm).then(response =>{
            this.$message({
              message: response.message,
              type: 'success'
              })
              this.familyForm = {} //清空对象
              this.familyVisible = false//关闭添加弹窗
              this.listDatas()//刷新表单数据
            })
         } else {
           family.update(this.familyForm).then(response =>{
            this.$message({
              message: response.message,
              type: 'success'
              })
              this.familyForm = {} //清空对象
              this.familyVisible = false//关闭添加弹窗
              this.listDatas()//刷新表单数据
            })
        }
       },
       //条件查询方法
      getFamilyQuery(){
        this.listDatas()
      },
      //重置方法
      refreshFamilyQuery(){
        this.familyQuery.familyCode = ''
        this.familyQuery.familyName = ''
        this.listDatas()
      },
      //修改family信息方法
      update(row){
        this.familyForm.fid = row.fid
        this.familyForm.familyCode = row.familyCode
        this.familyForm.familyName = row.familyName
        this.familyForm.remark = row.remark
        this.familyVisible = true
      },
      //删除family信息方法
      del(fid){
        this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
        })
        .then(() => {
          return family.del(fid)
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
      },
       //查询family表单方法
      listFamily(){
        // this.list = response.data
        family.list().then(response =>{
          this.familyList = response.data
        })
      }
     }
  }

</script>

<style>
</style>
