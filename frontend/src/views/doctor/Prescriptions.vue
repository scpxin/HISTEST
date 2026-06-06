<template>
  <div>
    <h2>处方管理</h2>
    <el-card style="margin-top: 20px">
      <el-table :data="prescriptionList" stripe border>
        <el-table-column prop="prescriptionNo" label="处方编号" width="140" />
        <el-table-column prop="patientName" label="患者" width="100" />
        <el-table-column prop="doctorName" label="医生" width="100" />
        <el-table-column prop="diagnosis" label="诊断" />
        <el-table-column prop="totalAmount" label="金额" width="100" />
        <el-table-column prop="status" label="状态" width="100">
          <template #default="{ row }">
            <el-tag :type="row.status === 0 ? 'warning' : 'success'">{{ row.status === 0 ? '未取药' : '已取药' }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="createTime" label="开具时间" width="160" />
      </el-table>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
const prescriptionList = ref<any[]>([])
onMounted(() => {
  prescriptionList.value = [
    { id: 1, prescriptionNo: 'RX20240606001', patientName: '陈大明', doctorName: '张医生', diagnosis: '上呼吸道感染', totalAmount: 156.50, status: 0, createTime: '2024-06-06 09:30:00' },
    { id: 2, prescriptionNo: 'RX20240606002', patientName: '林小红', doctorName: '张医生', diagnosis: '急性支气管炎', totalAmount: 238.00, status: 1, createTime: '2024-06-06 10:15:00' }
  ]
})
</script>
