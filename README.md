# FamilyFinanceService
家庭财务管理系统（Vue+SpringBoot）
一、项目介绍
1.1项目概述
项目名称：家庭财务管理系统
项目目的：家庭财务管理系统可以帮助家庭实现家庭成员信息化管理、家庭成员财务情况的总体管理、收入支出和转账的全方面管理、财务信息化管理等方面的工作，实现家庭财务信息化管理的全面覆盖。通过家庭财务管理系统，家庭成员可以更快捷、更准确地获取目前的家庭财务情况、添加修改账目的支出收入和转账，提供更加精细化、个性化的财务管理服务。同时，家庭财务管理系统还可以实现家庭经济资源的优化配置，提高家庭财务支出的效率和质量，降低家庭财务管理的盲目性和错误率，更好地服务于家庭本身。
意义：家庭财务管理系统的背景是由于家庭财务管理需求的增加和个人消费习惯的改变，以及对理财和数据安全的重视。这样的背景使得家庭财务管理系统成为了现代家庭不可或缺的工具，为家庭提供了更好的财务管理和规划支持。
1.2 需求分析
家庭财务信息管理系统是现代家庭生活必备的管理工具之一，旨在提高家庭财务管理效率，改善家庭开销的盲目性。本项目的需求分析旨在明确系统的功能和特性，为后续的系统设计和开发提供清晰的指导和基础。随着家庭成员与个人资金账户的增加，总览家庭财务情况的难度也随之提高，为了缓解这一情况的发生，使用家庭财务管理系统是一个很好的选择。由于本系统可以添加家庭与家庭成员，还能对家庭成员个人的所有资金账户提供管理支持，使得家庭财务管理的难度降低，而且明晰了家庭财务的脉络，极大程度上满足了一般家庭的财务管理需求，有利于应用的推广和铺展。
1.3设计思路
(1)模块化设计：模块化设计是一种将软件系统分解为可重复使用的模块的设计方法。模块化设计有助于提高代码的可维护性和重用性，同时降低代码的耦合性。模块化设计可以使得软件系统更加灵活，易于扩展和维护。
(2)数据库设计：设计合适的数据库结构，包括关系型数据库和非关系型数据库的选择，数据库表的设计，以及索引和关联的建立，以确保数据的高效存储和快速查询。
(3)	安全性设计：
登录家庭财务管理系统需要进行账户名以及密码输入，输入密码时可选择对输入内容进行加密，也可以选择显示原内容，对密码的安全性进行了进一步提升。
在家庭列表页面，对用户信息进行删除，点击删除按键，会跳出提示“是否对该信息进行删除，删除后不可恢复。”，避免因为认为误操作对其进行删除。
(4)	高可用性设计：
家庭财务系统需要保证系统的稳定性和可靠性，对各种交易记录以及个人信息进行保存，保证信息的长效保存。
(5)	可扩展性和灵活性：系统设计具备良好的可扩展性，能够根据家庭财务需求的发展需求进行灵活调整和扩展。同时，也要考虑到技术的变化和未来的发展方向，以便系统能够持续演进和适应新的需求。
1.4 运行环境
软件环境：
•	操作系统：Windows 10 Windows 11 Linux
•	数据库：MySQL
•	后端开发框架：Lombok+MyBatis+Spring-Boot 2.7.9 
•	前端开发框架：Vue.js
•	开发工具：IntelliJ IDEA、HBuilder X 等
硬件环境：
•	CPU：Intel i5
•	内存：16GB
•	存储：固态硬盘（SSD）512GB 

二、概要设计
本系统包含以下模块：
1.家庭列表：可以通过家庭编码或者家庭名称来查询对应的家庭信息以进行基本的信息编辑操作。
2.学历列表：基本操作同家庭列表，可以对相应的学历列表进行基本的信息编辑操作。
3.账户类型列表：基本操作同家庭列表，可以对相应的账户类型进行增删改查操作。
4.用户列表：用户可以自行添加或删除用户，可以对用户进行开通账户的操作，以及对用户的基本信息进行编辑操作。
5.总账户列表：可以对账户名称进行搜索操作，并且可以对指定的账户进行基本信息的修改或删除操作，还可以在此基础上添加总账户对应的资金账户。
6.资金账户：可以通过账户编码、账户名称以及账户类型筛选资金账户，在每个资金账户条目后可以对其进行修改删除操作，还可以生成该资金账户的收入支出账目。
7.收入支出：可以通过交易发生的资金账户或收入支出类型筛选账单，选择资金账户提供下拉列表进行选择。可以对账目进行修改与删除操作。
8.转账账目：可以通过转出账户或转入账户对转账账目进行查找，两者均提供下拉列表选择。可以对转账账目进行修改与删除操作。
 
图 1 家庭财务管理系统功能图
 
图 2 家庭财务管理系统er图
 
图 3 家庭财务管理系统数据库设计图
三、接口定义
家庭接口FamilyContrlloer:
表格 1 添加家庭请求
函数名	add
发送请求	post
类型	变量名	说明
Family	family	家庭类
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 2 更新family请求
函数名	update
发送请求	put
类型	变量名	说明
Family	family	家庭类	
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败


表格 3 删除family请求
函数名	del
发送请求	delete
类型	变量名	说明
Long	id	家庭id	
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 4 获取全部family列表请求
函数名	list
发送请求	get
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 5 分页显示family请求
函数名	listData
发送请求	post
类型	变量名	说明
Long	pageIndex	页数
Long	pageSize	每页显示数量
FamilyVo	familyVo	家庭查询变量
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

教育接口EducationController
表格 6 添加education请求
函数名	add
发送请求	post
类型	变量名	说明
		
Education	education	教育类
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 7 更新education请求
函数名	update
发送请求	put
类型	变量名	说明
Education	education	教育类
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 8 删除education请求
函数名	del
发送请求	delete
类型	变量名	说明
Long	id	教育id	
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 9 获取全部education请求
函数名	list
发送请求	get
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 10 分页获取education请求
函数名	listData
发送请求	post
类型	变量名	说明
Long	pageIndex	页数
Long	pageSize	每页显示数量
EducationVo	educationVo	教育查询变量
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

资金类别接口TypeController
表格 11 添加type请求
函数名	add
发送请求	post
类型	变量名	说明
Type	type	资金类别类
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 12 更新type请求
函数名	update
发送请求	put
类型	变量名	说明
Type	type	资金类别类
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 13 删除type请求
函数名	del
发送请求	delete
类型	变量名	说明
Long	id	资金类别id	
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 14 获取全部type列表请求
函数名	list
发送请求	get
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 15 分页获取type请求
函数名	listData
发送请求	post
类型	变量名	说明
Long	pageIndex	页数
Long	pageSize	每页显示数量
TypeVo	typeVo	账户类别查询变量
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

用户接口UsersController
表格 16 添加用户请求
函数名	add
发送请求	post
类型	变量名	说明
Users	users	用户类
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 17 更新用户请求
函数名	update
发送请求	put
类型	变量名	说明
Users	users	用户类
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 18 删除用户请求
函数名	del
发送请求	delete
类型	变量名	说明
Long	id	用户id	
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 19 获取全部用户列表请求
函数名	list
发送请求	get
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 20 分页获取用户请求
函数名	listData
发送请求	post
类型	变量名	说明
Long	pageIndex	页数
Long	pageSize	每页显示数量
UsersVo	usersVo	用户查询变量
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 21 自建多表查询mapper测试数据
函数名	ListFamilyEdu
发送请求	get
类型	变量名	说明
Long	uid	用户id
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

登录接口LoginController
表格 22 登录请求
函数名	login
发送请求	post
类型	变量名	说明
LoginVo	loginVo	登录查询变量
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败
 
表格 23 登录请求头token解密
函数名	info
发送请求	get
类型	变量名	说明
String	token	token密码
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败
 
总账户接口AccountController
表格 24 添加总账户请求
函数名	add
发送请求	post
类型	变量名	说明
Account	account	总账户类
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 25 更新总账户请求
函数名	update
发送请求	put
类型	变量名	说明
Account	account	总账户类
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 26 删除总账户请求
函数名	del
发送请求	delete
类型	变量名	说明
Long	id	总账户id	
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 27 获取全部总账户列表请求
函数名	list
发送请求	get
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 28 分页获取总账户请求
函数名	listData
发送请求	post
类型	变量名	说明
Long	pageIndex	页数
Long	pageSize	每页显示数量
AccountVo	accountVo	总账户查询变量
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 29 获取账户关联的用户信息请求
函数名	ListWhere
发送请求	get
类型	变量名	说明
Long	uid	总账户id
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

资金账户接口TypeAccountController
表格 30 添加资金账户方法
函数名	addTypeAccount
发送请求	post
类型	变量名	说明
TypeAccount	typeAccount	资金账户类
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 25 更新资金账户请求
函数名	update
发送请求	put
类型	变量名	说明
TypeAccount	typeAccount	资金账户类
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 26 删除资金账户请求
函数名	del
发送请求	delete
类型	变量名	说明
Long	id	资金账户id	
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 27 获取全部资金账户列表请求
函数名	list
发送请求	get
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 28 分页获取资金账户请求
函数名	listData
发送请求	post
类型	变量名	说明
Long	pageIndex	页数
Long	pageSize	每页显示数量
TypeAccountVo	typeAccountVo	资金账户查询变量
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

账单接口BillController
表格 30 添加账单方法
函数名	add
发送请求	post
类型	变量名	说明
Bill	bill	账单类
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 25 更新账单请求
函数名	update
发送请求	put
类型	变量名	说明
Bill	bill	账单类
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 26 删除账单请求
函数名	del
发送请求	delete
类型	变量名	说明
Long	id	账单id	
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 27 获取全部账单列表请求
函数名	list
发送请求	get
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败

表格 28 分页获取账单请求
函数名	listData
发送请求	post
类型	变量名	说明
Long	pageIndex	页数
Long	pageSize	每页显示数量
BillVo	billVo	账单查询变量
返回值	类型	Result	说明
	值	20000 data	发送成功
		Fail	发送失败


四、测试结果
测试结果：
No	测试分类	测试内容	测试方法	判定基准	执行結果	担当
实施日
							
1	登录	客户端登录界面是否稳定	打开登录界面	登录界面能打开且保持稳定	OK	　	
2		输入账号密码信息是否能发到服务端	打开client，输入账号密码，查看服务端是否接收到消息	服务端成功接到消息	OK	　	
4		登录信息是否能发到服务端	点击登录，查看服务端是否接收到消息	服务端成功接到消息	OK	　	
6		服务端能否返回登录错误信息	打开client，输入错误的登录信息，查看客户端能否接到登录错误的相关信息	客户端成功显示错误信息	OK	　	
8	界面	主界面是否稳定	登录完成后，是否出现主界面且主界面是否稳定	主界面在不操作的情况下可以出现且能稳定	OK	　	
9		家庭列表能否正常显示	登录完成后，切换至家庭列表界面，观察是否正常	家庭列表正常显示且没有错误	OK	　	
10		学历列表能否正常显示	登录完成后，切换到学历界面，观察是否正常	学历列表正常显示且没有错误	OK	　	
11		账户类型列表能否正常显示	切换到账户类型列表信息界面，观察是否正常	账户类型信息显示正常且没有错误	OK	　	
12		是否能对家庭列表正常的进行添加	进入家庭列表界面，进行对该表添加家庭类别	服务端成功接收信息，添加信息显示正常	OK	　	
13		是否能对家庭列表正常的进行查询	对该表的家庭编号和家庭名称进行查询功能	服务端成功接收信息，查询显示正常	OK	　	
14		是否能对家庭列表正常的进行编辑	对该表的家庭编号和家庭名称进行编辑功能	服务端成功接收信息，编辑显示正常	OK	　	
15		是否能对家庭列表正常的进行删除	对该表的家庭编号和家庭名称进行删除功能	服务端成功接收信息，删除显示正常	OK	　	
16		是否能对学历列表正常的进行添加	进入学历列表界面，进行对该表添加学历名称，学历编码	服务端成功接收消息，添加信息显示正常	OK	　	
17		是否能对学历列表正常的进行查询	进行对该表查询学历名称，学历编码	服务端成功接收信息，查询显示正常	OK	　	
18		是否能对学历列表正常的进行编辑	进行对该表编辑学历名称，学历编码	服务端成功接收信息，编辑显示正常	OK	　	
19		是否能对学历列表正常的进行删除	进行对该表删除学历名称，学历编码	服务端成功接收信息，删除显示正常	OK	　	
20		是否能对账户类型列表正常的进行添加	进入账户类型信息界面，进行对该表添加账户类型信息功能	服务端成功接收信息，添加信息显示正常	OK	　	
21		是否能对账户类型列表正常的进行查询，编辑，删除	进行对该表查询，编辑，删除账户类型信息功能	服务端成功接收信息，查询，编辑，删除显示正常	OK	　	
23	服务器	服务器可以对客户端发送的退出信息	点击退出按钮，观察是否正常	服务端成功接受信息	OK	　	
24		服务器端可以对客户端发送返回到登陆界面	返回到登录界面	该界面能打开且稳定	OK	　	
