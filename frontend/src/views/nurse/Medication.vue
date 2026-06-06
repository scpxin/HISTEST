<template>
  <div>
    <h2>用药管理</h2>
    <el-tabs v-model="activeTab" style="margin-top: 20px">
      <el-tab-pane label="待执行医嘱" name="pending">
        <el-card>
          <el-table :data="pendingList" stripe border>
            <el-table-column prop="patientName" label="患者" width="100" />
            <el-table-column prop="drugName" label="药品" width="150" />
            <el-table-column prop="dosage" label="剂量" width="100" />
            <el-table-column prop="scheduledTime" label="执行时间" width="120" />
            <el-table-column label="操作" width="100">
              <template #default="{ row }">
                <el-button type="success" link @click="executeMed(row)">执行</el-button>
              </template>
            </el-table-column>
          </el-table>
        </el-card>
      </el-tab-pane>
      <el-tab-pane label="药品库存" name="inventory">
        <el-card>
          <el-table :data="inventoryList" stripe border>
            <el-table-column prop="drugName" label="药品名称" width="200" />
            <el-table-column prop="specification" label="规格" width="120" />
            <el-table-column prop="stock" label="库存" width="100" />
            <el-table-column prop="unit" label="单位" width="80" />
            <el-table-column prop="expiryDate" label="有效期" width="120" />
          </el-table>
        </el-card>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { ElMessage } from 'element-plus'

const activeTab = ref('pending')
const pendingList = ref<any[]>([])
const inventoryList = ref<any[]>([])

onMounted(() => {
  pendingList.value = [
    { id: 1, patientName: '陈大明', drugName: '阿莫西林胶囊', dosage: '0.5g', scheduledTime: '08:00' },
    { id: 2, patientName: '林小红', drugName: '头孢拉定胶囊', dosage: '0.25g', scheduledTime: '10:00' }
  ]
  inventoryList.value = [
    { id: 1, drugName: '阿莫西林胶囊', specification: '0.25g*24粒', stock: 156, unit: '盒', expiryDate: '2025-12-31' },
    { id: 2, drugName: '布洛芬缓释胶囊', specification: '0.3g*20粒', stock: 23, unit: '盒', expiryDate: '2025-10-15' }
  ]
})

const executeMed = (row: any) => {
  ElMessage.success('医嘱执行成功：' + row.drugName)
}
</script>
