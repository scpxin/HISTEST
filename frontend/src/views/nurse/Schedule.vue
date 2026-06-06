<template>
  <div>
    <h2>排班管理</h2>
    <el-card style="margin-top: 20px">
      <el-table :data="scheduleList" stripe border>
        <el-table-column prop="staffName" label="姓名" width="100" />
        <el-table-column prop="departmentName" label="科室" width="100" />
        <el-table-column prop="scheduleDate" label="日期" width="120" />
        <el-table-column prop="shiftType" label="班次" width="100">
          <template #default="{ row }">
            <el-tag :type="row.shiftType === 'MORNING' ? 'success' : 'warning'">
              {{ row.shiftType === 'MORNING' ? '早班' : '晚班' }}
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="startTime" label="开始时间" width="100" />
        <el-table-column prop="endTime" label="结束时间" width="100" />
      </el-table>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
const scheduleList = ref<any[]>([])
onMounted(() => {
  scheduleList.value = [
    { id: 1, staffName: '王护士', departmentName: '内科', scheduleDate: '2024-06-06', shiftType: 'MORNING', startTime: '08:00', endTime: '16:00' },
    { id: 2, staffName: '刘护士', departmentName: '外科', scheduleDate: '2024-06-06', shiftType: 'AFTERNOON', startTime: '16:00', endTime: '24:00' }
  ]
})
</script>
