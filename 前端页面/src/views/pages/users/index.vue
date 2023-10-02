<template>
  <div class="app-container">
      <!-- 条件查询 一个表单 -->
      <el-form :inline="true" :model="usersQuery" class="demo-ruleForm">
        <el-form-item label="用户名">
          <el-input v-model="usersQuery.username"></el-input>
        </el-form-item>
        <el-form-item label="姓名">
          <el-input v-model="usersQuery.name"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" size='medium' @click='getUsersQuery()'>查询</el-button>
          <el-button type="warning" icon="el-icon-refresh" size='medium' @click='refreshUsersQuery()'>重置</el-button>
        </el-form-item>
      </el-form>
      <!-- 添加 -->
      <div>
        <el-button type="success" size='medium' icon='el-icon-plus' @click='add()'>添加</el-button>
      </div>
      <!-- 表格 -->
      <el-table
          :data="usersList" style="width: 100%">
          <el-table-column
            type="index"
            width="50">
          </el-table-column>
          <el-table-column
            prop="username"
            label="用户名"
            width="120">
          </el-table-column>
          <el-table-column
            prop="name"
            label="姓名"
            width="120">
          </el-table-column>
          <el-table-column
            prop="family.familyName"
            label="家庭"
            width="120">
          </el-table-column>
          <el-table-column
            prop="sex"
            label="性别"
            width="120">
            <!-- 使用标签根据数字转换为文字 -->
            <template slot-scope='scope'>
              <span v-if="scope.row.sex===0">
                <el-tag type="warning">男</el-tag>
              </span>
              <span v-if="scope.row.sex===1">
                <el-tag type="success">女</el-tag>
              </span>
            </template>
          </el-table-column>
          <!-- :formatter="formatSex" -->
          <!-- 性别过滤器 -->
          <!-- :filters="sexFilters"
            :filter-method="filterSex" -->

          <el-table-column
            prop="education.educationName"
            label="学历"
            width="120">
          </el-table-column>
          <el-table-column
            prop="occupation"
            label="职业"
            width="120">
          </el-table-column>
          <el-table-column
            prop="description"
            label="描述"
            width="120">
          </el-table-column>
          <el-table-column
            prop="remark"
            label="备注"
            width="120">
          </el-table-column>
          <el-table-column
            label="操作">
              <template slot-scope='scope'>
                <el-button type="primary" size='mini' icon='el-icon-edit' @click='update(scope.row)'>修改</el-button>
                <el-button type="danger" size='mini' icon='el-icon-delete' @click='del(scope.row.uid)'>删除</el-button>
                <span v-if="scope.row.isAccount===0">
                  <el-button type="success" size='mini' icon='el-icon-circle-plus-outline' @click='createAccount(scope.row)'>开通账户</el-button>
                </span>
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
    title="添加用户信息"
    :visible.sync="usersVisible"
    width="70%"
    >
    <!-- 添加信息表单 -->
    <el-form :model="usersForm" status-icon :rules="rules"  class="demo-ruleForm" ref="usersForm" label-width="80px">
          <el-form-item label="用户名"  :label-width="formLabelWidth">
            <el-input v-model="usersForm.username"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password" :label-width="formLabelWidth">
            <el-input v-model="usersForm.password" placeholder="请输入密码" type="password" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="确认密码" prop="password2"  :label-width="formLabelWidth">
            <el-input v-model="usersForm.password2" placeholder="请确认密码" type="password" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="姓名" :label-width="formLabelWidth">
            <el-input v-model="usersForm.name"></el-input>
          </el-form-item>
          <el-form-item label="性别"  :label-width="formLabelWidth">
            <el-radio-group v-model="usersForm.sex"  size='small'>
              <el-radio label= 0>男</el-radio>
              <el-radio label= 1>女</el-radio>
            </el-radio-group>
          </el-form-item>

          <el-form-item label="选择家庭" :label-width="formLabelWidth">
                  <el-select v-model="usersForm.fid" placeholder="请选择" size="small">
                    <el-option
                      v-for="family in familyList"
                      :key="family.familyName"
                      :label="family.familyName"
                      :value="family.fid">
                    </el-option>
                  </el-select>
                </el-form-item>
                <!-- 选项中的key值代表唯一性 -->
                <!-- v -for是一个遍历 -->
          <el-form-item label="选择学历" :label-width="formLabelWidth">
                  <el-select v-model="usersForm.eid" placeholder="请选择" size="small">
                    <el-option
                      v-for="education in educationList"
                      :key="education.educationName"
                      :label="education.educationName"
                      :value="education.eid">
                    </el-option>
                  </el-select>
                </el-form-item>

          <el-form-item label="职业" :label-width="formLabelWidth">
            <el-input v-model="usersForm.occupation"></el-input>
          </el-form-item>
          <el-form-item label="描述" :label-width="formLabelWidth">
            <el-input type="textarea" v-model="usersForm.description"></el-input>
          </el-form-item>
          <el-form-item label="备注" :label-width="formLabelWidth">
            <el-input type="textarea" v-model="usersForm.remark"></el-input>
          </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="usersVisible = false">取 消</el-button>
      <el-button type="primary" @click="saveOrUpdate()">确 定</el-button>
    </span>
  </el-dialog>
  <!-- 修改user信息弹窗 -->
  <el-dialog
    title="修改用户信息"
    :visible.sync="updateVisble"
    width="70%"
    >
  <el-form :model="usersForm" status-icon ref="usersForm" label-width="80px">
          <el-form-item label="用户名"  :label-width="formLabelWidth">
            <el-input v-model="usersForm.username"></el-input>
          </el-form-item>
          <el-form-item label="姓名" :label-width="formLabelWidth">
            <el-input v-model="usersForm.name"></el-input>
          </el-form-item>
          <el-form-item label="性别"  :label-width="formLabelWidth">
            <el-radio-group v-model="usersForm.sex"  size='small'>
              <el-radio label= 0>男</el-radio>
              <el-radio label= 1>女</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="选择家庭" :label-width="formLabelWidth">
            <el-select v-model="usersForm.fid" placeholder="请选择" size="small">
              <el-option
                v-for="family in familyList"
                :key="family.familyName"
                :label="family.familyName"
                :value="family.fid">
              </el-option>
            </el-select>
          </el-form-item>
                <!-- 选项中的key值代表唯一性 -->
                <!-- v -for是一个遍历 -->
          <el-form-item label="选择学历" :label-width="formLabelWidth">
            <el-select v-model="usersForm.eid" placeholder="请选择" size="small">
              <el-option
                v-for="education in educationList"
                :key="education.educationName"
                :label="education.educationName"
                :value="education.eid">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="职业" :label-width="formLabelWidth">
            <el-input v-model="usersForm.occupation"></el-input>
          </el-form-item>
          <el-form-item label="描述" :label-width="formLabelWidth">
            <el-input type="textarea" v-model="usersForm.description"></el-input>
          </el-form-item>
          <el-form-item label="备注" :label-width="formLabelWidth">
            <el-input type="textarea" v-model="usersForm.remark"></el-input>
          </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="updateVisble = false">取 消</el-button>
      <el-button type="primary" @click="updateUsers()">确 定</el-button>
    </span>
  </el-dialog>
  <!-- 开通账户弹窗 -->
  <el-dialog
    title="开通账户"
    :visible.sync="accountVisible"
    width="70%"
    >
    <!-- 添加信息表单 -->
    <el-form :model="accountForm" label-width="80px">
          <el-form-item label="用户名"  :label-width="formLabelWidth">
            <el-input v-model="accountForm.accountDes"></el-input>
          </el-form-item>
          <el-form-item label="账户金额"  :label-width="formLabelWidth">
            <el-input v-model="accountForm.accountMoney"></el-input>
          </el-form-item>
          <el-form-item label="备注" :label-width="formLabelWidth">
            <el-input type="textarea" v-model="accountForm.remark"></el-input>
          </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="accountVisible = false">取 消</el-button>
      <el-button type="primary" @click="saveAccount()">确 定</el-button>
    </span>
  </el-dialog>
  </div>
</template>

<script>
  import family from '@/api/family'
  import education from '@/api/education'
  import users from '@/api/users'
  import account from '@/api/account'
  export default {
     data(){
       //二次密码校验
       var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.usersForm.password !== '') {
            this.$refs.usersForm.validateField('password2')
          }
          callback();
        }
      };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.usersForm.password) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
       return{
         //密码校验rules
         rules: {
          password: [
            { validator: validatePass, trigger: 'blur' }
          ],
          password2: [
            { validator: validatePass2, trigger: 'blur' }
          ]
        },
         //宽度
         formLabelWidth: '120px',
         //分页-当前页面
         pageIndex: 1,
         //一页多少条数据
         pageSzie: 5,
         //总共有多少条数据
         total: 0,
         //添加表单对话框显示初始值
         usersVisible:false,
         //修改users对话框显示初始值
         updateVisble:false,
         //开通账户对话框显示初始值
         accountVisible:false,
         //自定义过滤器将性别数字转换为文字
         sexFilters: [
                 { text: '男', value: 0 },
                 { text: '女', value: 1 },
         ],
         //自定义过滤器将性别数字转换为文字
         filters: {
             formatSex(value) {
               switch (value) {
                 case 0:
                   return '男';
                 case 1:
                   return '女';
                 default:
                   return '';
               }
             },
          },
         //添加/修改 表单数据
         usersForm:{
           uid:0,
           username:'',
           password:'',
           password2:'',
           occupation:'',
           description:'',
           sex:0,
           fid:null,
           eid:null,
           name:'',
           remark:''
         },
         //开通账户 表单数据
         accountForm:{
           aid:0,
           uid:0,
           accountDes:'',
           accountMoney:0,
           remark:''
         },
         //接收users表格数据
          usersList:[],
          //接收family查询信息
          familyList:[],
          //接受education查询信息
          educationList:[],
          //条件查询
          usersQuery:{
            username:'',
            name:''
          }
        }
       },
       //一个计算方法-将数字性别转为文字性别
       computed: {
        formatSex() {
          return (row) => {
            switch (row.sex) {
              case 0:
                return '男';
              case 1:
                return '女';
              default:
                return '';
            }
          };
        },
        // formatFamily(){
        //   return(row) => {
        //     family.findFamilyNameByFid(row.fid).then(response => {
        //       return response.data
        //     })
        //   }
        // }
     },
     created() {
       // 初始函数
       //this.listUsers()
       this.listFamilys()//提前获取family信息
       this.listEducation()
       this.listDatas()
     },
     methods:{
       //过滤性别函数
       filterSex(value, row) {
             return row.sex === value;
           },
       //下拉列表-family信息
       listFamilys() {
             family.list().then(response =>{
               this.familyList = response.data
               })
        },
        //下拉列表-education信息
        listEducation(){
          education.list().then(response =>{
            this.educationList = response.data
          })
        },
       //查询分页
       listDatas(pageIndex=1){
         this.pageIndex = pageIndex
         console.log(`当前页: ${pageIndex}`);
         users.dataList(this.pageIndex,this.pageSzie,this.usersQuery).then(response =>{
           this.usersList = response.data.records
           this.total = response.data.total
         })
       },
       //+users方法
       add(){
         this.usersForm = {}
         this.listFamilys()//提前获取family信息
         this.listEducation()
         this.usersVisible = true
       },
       //提交users表单方法
       saveOrUpdate(){
        users.add(this.usersForm).then(response =>{
        this.$message({
          message: response.message,
          type: 'success'
        })
        //以下三步必不可少
        this.usersForm = {} //清空对象
        this.usersVisible = false//关闭添加弹窗
        this.listDatas()//刷新表单数据
        })
       },
       //开通账户方法
       createAccount(row){
         this.accountVisible = true
         this.accountForm.uid = row.uid
       },
       //提交开通账户表单方法
       saveAccount(){
        account.add(this.accountForm).then(response =>{
        this.$message({
          message: response.message,
          type: 'success'
        })
        //以下三步必不可少
        this.accountForm = {} //清空对象
        this.accountVisible = false//关闭添加弹窗
        this.listDatas()//刷新表单数据
        })
       },
       //条件查询方法
      getUsersQuery(){
        this.listDatas()
      },
      //重置方法
      refreshUsersQuery(){
        this.usersQuery.username = ''
        this.usersQuery.name = ''
        this.listDatas()
      },
      //修改users信息方法
      update(row){
        this.listFamilys()//提前获取family信息
        this.listEducation()
        this.usersForm.uid= row.uid
        this.usersForm.username= row.username
        this.usersForm.password= row.password
        this.usersForm.occupation= row.occupation
        this.usersForm.description= row.description
        this.usersForm.sex= row.sex
        this.usersForm.fid= row.fid
        this.usersForm.eid= row.eid
        this.usersForm.name= row.name
        this.usersForm.remark= row.remark
        this.updateVisble = true
      },
      //保存users修改信息
      updateUsers(){
        users.update(this.usersForm).then(response =>{
         this.$message({
           message: response.message,
           type: 'success'
           })
           this.usersForm = {} //清空对象
           this.updateVisble = false//关闭添加弹窗
           this.listDatas()//刷新表单数据
         })
      },
      //删除users信息方法
      del(uid){
        this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
        })
        .then(() => {
          return users.del(uid)
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
       //查询users表单方法
      listUsers(){
        // this.list = response.data
        users.list().then(response =>{
          this.usersList = response.data
        })
      }
     },
}


</script>

<style>
</style>
