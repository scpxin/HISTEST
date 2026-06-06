# 🏥 HIS医院信息系统

> 基于 Vue 3 + Spring Boot + MySQL 的现代化医院管理系统

## ✨ 功能特点

### 🩺 医生站
- 患者信息管理
- 在线诊断开方
- 处方管理
- 预约挂号
- 检验检查结果查询

### 👩‍⚕️ 护士站
- 排班管理
- 护理记录
- 用药管理
- 床位管理
- 生命体征监测

### ⚙️ 系统管理
- 用户权限管理
- 科室管理
- 数据统计分析

## 🛠️ 技术栈

### 前端
- Vue 3 + TypeScript
- Element Plus UI
- Vite 构建工具
- ECharts 图表库

### 后端
- Spring Boot 3.x
- MyBatis Plus
- MySQL 8.0
- Redis 缓存
- JWT 认证

## 🚀 快速开始

### 环境要求
- Node.js >= 16
- JDK >= 17
- MySQL >= 8.0

### 本地运行

1. **克隆项目**
```bash
git clone https://github.com/your-repo/his-system.git
cd his-system
```

2. **启动前端**
```bash
cd frontend
npm install
npm run dev
```

3. **启动后端**
```bash
cd backend
mvn clean package -DskipTests
java -jar target/his-backend-1.0.0.jar
```

4. **初始化数据库**
```bash
mysql -u root -p < backend/src/main/resources/sql/init.sql
```

## 🌐 在线部署

| 组件 | 平台 | 免费额度 |
|------|------|----------|
| 前端 | Vercel | 100GB带宽/月 |
| 后端 | Railway | $5/月 |
| 数据库 | PlanetScale | 10GB存储 |

详细部署文档请参考 [docs/deployment.md](docs/deployment.md)

## 📸 截图

### 登录页面
![登录](./screenshots/login.png)

### 系统首页
![首页](./screenshots/dashboard.png)

### 医生站
![医生站](./screenshots/doctor.png)

### 护士站
![护士站](./screenshots/nurse.png)

## 📁 项目结构

```
his-system/
├── frontend/           # 前端项目
│   ├── src/
│   │   ├── api/        # API接口
│   │   ├── assets/     # 静态资源
│   │   ├── components/ # 公共组件
│   │   ├── router/     # 路由配置
│   │   ├── store/      # 状态管理
│   │   ├── styles/     # 样式文件
│   │   ├── utils/      # 工具函数
│   │   └── views/      # 页面组件
│   │       ├── doctor/     # 医生站
│   │       ├── nurse/      # 护士站
│   │       └── common/     # 公共页面
│   └── package.json
├── backend/            # 后端项目
│   ├── src/main/java/com/his/
│   │   ├── config/     # 配置类
│   │   ├── controller/ # 控制器
│   │   ├── entity/     # 实体类
│   │   ├── mapper/     # 数据访问层
│   │   ├── service/    # 业务逻辑层
│   │   └── vo/         # 视图对象
│   └── src/main/resources/
│       ├── mapper/     # MyBatis映射文件
│       └── sql/        # SQL脚本
├── docs/               # 文档
└── README.md
```

## 🤝 贡献指南

1. Fork 本仓库
2. 创建功能分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送分支 (`git push origin feature/AmazingFeature`)
5. 提交 Pull Request

## 📄 许可证

本项目基于 [MIT](LICENSE) 许可证开源。

## 💬 联系我们

- 项目主页: https://github.com/your-repo/his-system
- 问题反馈: https://github.com/your-repo/his-system/issues
- 邮箱: support@his.com

---

**⭐ 如果觉得有用，请给个星标！**
