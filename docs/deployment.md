# HIS医院信息系统 - 部署指南

## 📋 项目概述

HIS（医院信息系统）采用前后端分离架构，包含医生站、护士站等核心功能模块。

### 技术栈
- **前端**: Vue 3 + Element Plus + TypeScript
- **后端**: Java Spring Boot + MyBatis Plus
- **数据库**: MySQL 8.0

---

## 🚀 免费部署平台推荐

### 前端部署 - Vercel (推荐)
**免费额度**: 100GB带宽/月，无限项目

**优点**:
- 自动CI/CD
- 全球CDN加速
- 支持自定义域名
- 自动HTTPS

**部署步骤**:
1. 注册Vercel账号 (https://vercel.com)
2. 将前端代码推送到GitHub/GitLab
3. 在Vercel导入项目
4. 配置构建命令
5. 一键部署

### 后端部署 - Railway (推荐)
**免费额度**: $5信用额度/月，约500小时运行时间

**优点**:
- 支持Docker部署
- 自动扩缩容
- 内置数据库支持
- 简单易用

**部署步骤**:
1. 注册Railway账号 (https://railway.app)
2. 创建新项目
3. 连接GitHub仓库
4. 配置环境变量
5. 自动部署

### 数据库 - PlanetScale (推荐)
**免费额度**: 10GB存储，100万行读取/月

**优点**:
- 兼容MySQL
- 自动备份
- 分支管理
- 零停机迁移

**部署步骤**:
1. 注册PlanetScale账号 (https://planetscale.com)
2. 创建数据库
3. 获取连接字符串
4. 导入初始数据

---

## 🔧 本地开发环境搭建

### 1. 环境要求
- Node.js >= 16.0.0
- JDK >= 17
- MySQL >= 8.0
- Maven >= 3.6

### 2. 前端项目启动

```bash
# 进入前端目录
cd frontend

# 安装依赖
npm install

# 启动开发服务器
npm run dev

# 访问 http://localhost:3000
```

### 3. 后端项目启动

```bash
# 进入后端目录
cd backend

# 使用Maven打包
mvn clean package -DskipTests

# 启动项目
java -jar target/his-backend-1.0.0.jar

# 访问 http://localhost:8080/api
# API文档 http://localhost:8080/api/doc.html
```

### 4. 数据库初始化

```bash
# 登录MySQL
mysql -u root -p

# 执行初始化脚本
source backend/src/main/resources/sql/init.sql
```

---

## 📦 生产环境部署

### 前端部署 (Vercel)

1. **创建 `vercel.json` 配置**:
```json
{
  "rewrites": [
    { "source": "/(.*)", "destination": "/index.html" }
  ]
}
```

2. **环境变量配置**:
```
VITE_API_URL=https://your-backend.railway.app/api
```

3. **部署命令**:
```bash
npm install -g vercel
vercel --prod
```

### 后端部署 (Railway)

1. **创建 `Dockerfile`**:
```dockerfile
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY target/his-backend-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

2. **环境变量配置**:
```
SPRING_PROFILES_ACTIVE=prod
MYSQL_HOST=your-mysql-host
MYSQL_PORT=3306
MYSQL_DATABASE=his_db
MYSQL_USERNAME=your-username
MYSQL_PASSWORD=your-password
```

3. **部署到Railway**:
```bash
# 安装Railway CLI
npm install -g @railway/cli

# 登录
railway login

# 初始化项目
railway init

# 部署
railway up
```

---

## 🔐 配置说明

### 后端配置文件

**application.yml**:
```yaml
server:
  port: 8080

spring:
  datasource:
    url: ${MYSQL_HOST:jdbc:mysql://localhost:3306/his_db}
    username: ${MYSQL_USERNAME:root}
    password: ${MYSQL_PASSWORD:root}

mybatis-plus:
  mapper-locations: classpath:mapper/*.xml
```

### 前端环境变量

**.env.production**:
```
VITE_API_URL=https://your-backend.railway.app/api
VITE_APP_TITLE=HIS医院信息系统
```

---

## 📊 功能模块

### 医生站
- ✅ 患者列表管理
- ✅ 诊断开方
- ✅ 处方管理
- 🔄 预约挂号 (开发中)
- 🔄 检验检查 (待开发)

### 护士站
- ✅ 排班管理
- ✅ 护理记录
- ✅ 用药管理
- 🔄 床位管理 (开发中)
- 🔄 护理评估 (待开发)

### 系统管理
- ✅ 用户管理
- ✅ 科室管理
- 🔄 权限管理 (开发中)
- 🔄 日志管理 (待开发)

---

## 🐛 常见问题

### 1. 跨域问题
已配置CorsConfig，确保前端请求可以正常访问后端API。

### 2. 数据库连接失败
检查数据库配置是否正确，确保MySQL服务已启动。

### 3. 端口冲突
- 前端默认端口: 3000
- 后端默认端口: 8080
- 可在配置文件中修改

### 4. 内存不足
Railway免费版内存有限，建议优化JVM参数：
```
JAVA_OPTS=-Xmx256m -Xms128m
```

---

## 📞 技术支持

如有问题，请联系：
- 邮箱: support@his.com
- 文档: https://docs.his.com
- GitHub: https://github.com/your-repo/his-system

---

## 📄 许可证

本项目采用 MIT 许可证，详情请参阅 LICENSE 文件。
