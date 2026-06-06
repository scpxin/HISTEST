<template>
  <el-container style="height: 100vh">
    <el-header style="display: flex; justify-content: space-between; align-items: center; background: #fff; box-shadow: 0 1px 4px rgba(0,0,0,0.1);">
      <h1 style="font-size: 20px; color: #304156;">🏥 HIS系统</h1>
      <el-dropdown @command="handleCommand">
        <span>{{ userName }} ▼</span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item command="logout">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </el-header>
    <el-container>
      <el-aside width="230px" style="background: #304156">
        <el-menu :default-active="activeMenu" background-color="#304156" text-color="#bfcbd9" active-text-color="#409EFF" router>
          <el-menu-item index="/dashboard">首页</el-menu-item>
          <el-sub-menu index="doctor">
            <template #title>医生站</template>
            <el-menu-item index="/doctor/patients">患者列表</el-menu-item>
            <el-menu-item index="/doctor/diagnosis">诊断开方</el-menu-item>
            <el-menu-item index="/doctor/prescriptions">处方管理</el-menu-item>
          </el-sub-menu>
          <el-sub-menu index="nurse">
            <template #title>护士站</template>
            <el-menu-item index="/nurse/schedule">排班管理</el-menu-item>
            <el-menu-item index="/nurse/care">护理记录</el-menu-item>
            <el-menu-item index="/nurse/medication">用药管理</el-menu-item>
          </el-sub-menu>
        </el-menu>
      </el-aside>
      <el-main style="padding: 20px; background: #f0f2f5">
        <router-view />
      </el-main>
    </el-container>
  </el-container>
</template>

<script setup lang="ts">
import { computed } from 'vue'
import { useRoute, useRouter } from 'vue-router'
const route = useRoute()
const router = useRouter()
const userName = computed(() => localStorage.getItem('userName') || '用户')
const activeMenu = computed(() => route.path)

const handleCommand = (command: string) => {
  if (command === 'logout') {
    localStorage.clear()
    router.push('/login')
  }
}
</script>
