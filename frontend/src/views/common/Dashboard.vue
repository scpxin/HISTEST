<template>
  <div>
    <h2>系统首页</h2>
    <el-row :gutter="20" style="margin-top: 20px">
      <el-col :span="6" v-for="item in stats" :key="item.label">
        <el-card>
          <div style="text-align: center">
            <div style="font-size: 32px; font-weight: bold; color: #409EFF">{{ item.value }}</div>
            <div style="color: #909399; margin-top: 5px">{{ item.label }}</div>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
const stats = ref([
  { label: '今日就诊', value: 128 },
  { label: '在院患者', value: 45 },
  { label: '今日处方', value: 89 },
  { label: '今日收入', value: '52,680' }
])
</script>
