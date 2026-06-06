<template>
  <div>
    <h2>患者列表</h2>
    <el-card style="margin-top: 20px">
      <el-table :data="patientList" stripe border>
        <el-table-column prop="patientNo" label="编号" width="120" />
        <el-table-column prop="name" label="姓名" width="100" />
        <el-table-column prop="gender" label="性别" width="80">
          <template #default="{ row }">{{ row.gender === 'M' ? '男' : '女' }}</template>
        </el-table-column>
        <el-table-column prop="age" label="年龄" width="80" />
        <el-table-column prop="phone" label="手机号" width="130" />
        <el-table-column prop="departmentName" label="科室" width="100" />
        <el-table-column prop="status" label="状态" width="100">
          <template #default="{ row }">
            <el-tag :type="row.status === 1 ? 'success' : 'info'">{{ row.status === 1 ? '在院' : '出院' }}</el-tag>
          </template>
        </el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
const patientList = ref<any[]>([])
onMounted(() => {
  patientList.value = [
    { id: 1, patientNo: 'P20240001', name: '陈大明', gender: 'M', age: 45, phone: '13800138001', departmentName: '内科', status: 1 },
    { id: 2, patientNo: 'P20240002', name: '林小红', gender: 'F', age: 32, phone: '13800138002', departmentName: '内科', status: 1 },
    { id: 3, patientNo: 'P20240003', name: '黄志强', gender: 'M', age: 58, phone: '13800138003', departmentName: '外科', status: 1 },
    { id: 4, patientNo: 'P20240004', name: '吴美丽', gender: 'F', age: 28, phone: '13800138004', departmentName: '内科', status: 1 },
    { id: 5, patientNo: 'P20240005', name: '赵建国', gender: 'M', age: 65, phone: '13800138005', departmentName: '外科', status: 0 }
  ]
})
</script>
