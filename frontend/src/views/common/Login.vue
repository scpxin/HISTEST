<template>
  <div class="login-container">
    <div class="login-box">
      <h2>🏥 HIS系统</h2>
      <p>医院信息系统</p>
      <el-form :model="loginForm" :rules="rules" ref="formRef">
        <el-form-item prop="username">
          <el-input v-model="loginForm.username" placeholder="用户名" prefix-icon="User" />
        </el-form-item>
        <el-form-item prop="password">
          <el-input v-model="loginForm.password" type="password" placeholder="密码" prefix-icon="Lock" show-password />
        </el-form-item>
        <el-button type="primary" @click="handleLogin" :loading="loading" style="width: 100%">登录</el-button>
      </el-form>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, reactive } from 'vue'
import { useRouter } from 'vue-router'
import { ElMessage } from 'element-plus'

const router = useRouter()
const formRef = ref()
const loading = ref(false)
const loginForm = reactive({ username: 'admin', password: '123456' })
const rules = {
  username: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
  password: [{ required: true, message: '请输入密码', trigger: 'blur' }]
}

const handleLogin = async () => {
  await formRef.value.validate()
  loading.value = true
  setTimeout(() => {
    localStorage.setItem('token', 'demo-token')
    localStorage.setItem('userName', loginForm.username)
    ElMessage.success('登录成功')
    router.push('/dashboard')
    loading.value = false
  }, 1000)
}
</script>

<style scoped>
.login-container { height: 100vh; display: flex; justify-content: center; align-items: center; background: linear-gradient(135deg, #667eea, #764ba2); }
.login-box { width: 400px; padding: 40px; background: white; border-radius: 8px; text-align: center; }
.login-box h2 { margin: 0; color: #303133; }
.login-box p { margin: 10px 0 30px; color: #909399; }
</style>
