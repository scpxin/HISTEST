# HIS医院信息系统 - 项目结构

```
his-system/
├── 📁 frontend/                     # 前端项目 (Vue 3 + Element Plus)
│   ├── 📄 package.json              # 前端依赖配置
│   ├── 📄 vite.config.ts            # Vite构建配置
│   ├── 📄 tsconfig.json             # TypeScript配置
│   ├── 📄 index.html                # 入口HTML
│   ├── 📁 src/
│   │   ├── 📄 main.ts               # 应用入口
│   │   ├── 📄 App.vue               # 根组件
│   │   ├── 📁 api/                  # API接口
│   │   │   ├── 📄 request.ts        # Axios封装
│   │   │   ├── 📄 user.ts           # 用户API
│   │   │   ├── 📄 patient.ts        # 患者API
│   │   │   ├── 📄 doctor.ts         # 医生API
│   │   │   └── 📄 nurse.ts          # 护士API
│   │   ├── 📁 assets/               # 静态资源
│   │   ├── 📁 components/           # 公共组件
│   │   │   └── 📄 Layout.vue        # 布局组件
│   │   ├── 📁 router/               # 路由配置
│   │   │   └── 📄 index.ts          # 路由文件
│   │   ├── 📁 store/                # 状态管理 (Pinia)
│   │   ├── 📁 styles/               # 样式文件
│   │   ├── 📁 utils/                # 工具函数
│   │   └── 📁 views/                # 页面组件
│   │       ├── 📁 common/           # 公共页面
│   │       │   ├── 📄 Login.vue     # 登录页
│   │       │   └── 📄 Dashboard.vue # 首页仪表板
│   │       ├── 📁 doctor/           # 医生站
│   │       │   ├── 📄 PatientList.vue    # 患者列表
│   │       │   ├── 📄 Diagnosis.vue      # 诊断开方
│   │       │   └── 📄 Prescriptions.vue   # 处方管理
│   │       └── 📁 nurse/            # 护士站
│   │           ├── 📄 Schedule.vue       # 排班管理
│   │           ├── 📄 PatientCare.vue    # 护理记录
│   │           └── 📄 Medication.vue     # 用药管理
│   └── 📁 public/                   # 公共资源
│
├── 📁 backend/                      # 后端项目 (Spring Boot)
│   ├── 📄 pom.xml                   # Maven配置
│   ├── 📁 src/main/java/com/his/
│   │   ├── 📄 HisApplication.java   # 启动类
│   │   ├── 📁 config/               # 配置类
│   │   │   ├── 📄 CorsConfig.java   # 跨域配置
│   │   │   └── 📄 MyBatisPlusConfig.java
│   │   ├── 📁 controller/           # 控制器
│   │   │   ├── 📄 UserController.java
│   │   │   ├── 📄 PatientController.java
│   │   │   ├── 📄 DoctorController.java
│   │   │   └── 📄 NurseController.java
│   │   ├── 📁 entity/               # 实体类
│   │   │   ├── 📄 User.java
│   │   │   ├── 📄 Patient.java
│   │   │   ├── 📄 Doctor.java
│   │   │   ├── 📄 Nurse.java
│   │   │   ├── 📄 Appointment.java
│   │   │   ├── 📄 NursingRecord.java
│   │   │   └── 📄 Schedule.java
│   │   ├── 📁 mapper/               # 数据访问层
│   │   │   ├── 📄 UserMapper.java
│   │   │   └── 📄 PatientMapper.java
│   │   ├── 📁 service/              # 业务逻辑层
│   │   │   ├── 📄 UserService.java
│   │   │   ├── 📄 PatientService.java
│   │   │   ├── 📄 DoctorService.java
│   │   │   ├── 📄 NurseService.java
│   │   │   └── 📁 impl/            # 服务实现
│   │   │       ├── 📄 UserServiceImpl.java
│   │   │       ├── 📄 PatientServiceImpl.java
│   │   │       └── 📄 NurseServiceImpl.java
│   │   ├── 📁 vo/                   # 视图对象
│   │   └── 📁 common/               # 公共类
│   │       └── 📄 Result.java       # 统一响应结果
│   └── 📁 src/main/resources/
│       ├── 📄 application.yml        # 应用配置
│       ├── 📁 mapper/               # MyBatis映射文件
│       └── 📁 sql/                  # SQL脚本
│           └── 📄 init.sql          # 数据库初始化脚本
│
├── 📁 docs/                         # 文档
│   ├── 📄 deployment.md             # 部署指南
│   └── 📄 api.md                    # API文档
│
├── 📄 README.md                     # 项目说明
├── 📄 PROJECT_STRUCTURE.md          # 本文件
└── 📄 .gitignore                    # Git忽略配置
```

## 📊 功能模块统计

### 已实现功能 ✅
- 用户登录/认证
- 患者信息管理 (CRUD)
- 医生站 (患者列表、诊断开方、处方管理)
- 护士站 (排班管理、护理记录、用药管理)
- 仪表板数据展示

### 开发中 🔄
- 预约挂号系统
- 检验检查模块
- 报表统计

### 待开发 📋
- 住院管理
- 药房库存管理
- 收费结算
- 权限管理
- 日志管理

## 🔗 API接口列表

### 用户模块
- POST   /api/user/login          # 用户登录
- GET    /api/user/info           # 获取用户信息
- GET    /api/user/doctors        # 获取医生列表
- GET    /api/user/nurses         # 获取护士列表
- POST   /api/user/logout         # 退出登录

### 患者模块
- GET    /api/patient/list         # 分页查询患者
- GET    /api/patient/{id}         # 获取患者详情
- POST   /api/patient             # 新增患者
- PUT    /api/patient/{id}         # 更新患者
- DELETE /api/patient/{id}         # 删除患者
- GET    /api/patient/inpatients   # 获取在院患者

### 医生站模块
- GET    /api/doctor/list          # 获取医生列表
- GET    /api/doctor/appointments/today  # 今日预约
- GET    /api/doctor/schedule      # 医生排班
- POST   /api/doctor/call-next     # 叫号
- POST   /api/doctor/complete/{id}  # 完成就诊

### 护士站模块
- GET    /api/nurse/list           # 获取护士列表
- GET    /api/nurse/schedule       # 获取排班
- POST   /api/nurse/schedule       # 添加排班
- GET    /api/nurse/care-records   # 获取护理记录
- POST   /api/nurse/care-records   # 添加护理记录
- GET    /api/nurse/medications/today  # 今日医嘱
- POST   /api/nurse/medications/{id}/execute  # 执行医嘱

## 🛠️ 技术栈详情

### 前端
| 技术 | 版本 | 说明 |
|------|------|------|
| Vue | 3.3.x | 渐进式JavaScript框架 |
| Vue Router | 4.x | 路由管理 |
| Pinia | 2.x | 状态管理 |
| Element Plus | 2.x | UI组件库 |
| TypeScript | 5.x | 类型安全 |
| Vite | 4.x | 构建工具 |
| Axios | 1.x | HTTP客户端 |
| ECharts | 5.x | 图表库 |

### 后端
| 技术 | 版本 | 说明 |
|------|------|------|
| Spring Boot | 3.1.x | Java框架 |
| MyBatis Plus | 3.5.x | ORM框架 |
| MySQL | 8.0 | 数据库 |
| Redis | 7.x | 缓存 |
| JWT | 0.9.x | 认证 |
| Maven | 3.6+ | 构建工具 |

## 📝 数据库表

- `sys_user` - 用户表
- `his_patient` - 患者表
- `his_doctor` - 医生表
- `his_nurse` - 护士表
- `his_appointment` - 预约挂号表
- `his_department` - 科室表
- `his_prescription` - 处方表
- `his_prescription_drug` - 处方药品表
- `his_nursing_record` - 护理记录表
- `his_schedule` - 排班表
