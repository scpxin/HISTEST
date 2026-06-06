<template>
  <div>
    <h2>护理记录</h2>
    <el-row :gutter="20" style="margin-top: 20px">
      <el-col :span="6">
        <el-card>
          <template #header>患者列表</template>
          <el-table :data="patients" size="small" @row-click="selectPatient" highlight-current-row>
            <el-table-column prop="name" label="姓名" width="80" />
            <el-table-column prop="departmentName" label="科室" width="80" />
          </el-table>
        </el-card>
      </el-col>
      <el-col :span="18">
        <el-card>
          <template #header>护理记录</template>
          <div v-if="selectedPatient">
            <el-descriptions :column="3" border style="margin-bottom: 20px">
              <el-descriptions-item label="姓名">{{ selectedPatient.name }}</el-descriptions-item>
              <el-descriptions-item label="科室">{{ selectedPatient.departmentName }}</el-descriptions-item>
              <el-descriptions-item label="床号">101-1</el-descriptions-item>
            </el-descriptions>
            <el-form :model="careForm" label-width="80px">
              <el-form-item label="记录类型">
                <el-select v-model="careForm.type" style="width: 100%">
                  <el-option label="一般护理" value="一般护理" />
                  <el-option label="特殊护理" value="特殊护理" />
                </el-select>
              </el-form-item>
              <el-form-item label="记录内容">
                <el-input v-model="careForm.content" type="textarea" :rows="4" />
              </el-form-item>
              <el-button type="primary" @click="saveCare">保存记录</el-button>
            </el-form>
          </div>
          <el-empty v-else description="请选择患者" />
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script setup lang="ts">
import { ref, reactive } from 'vue'
import { ElMessage } from 'element-plus'

const patients = ref([
  { id: 1, name: '陈大明', departmentName: '内科' },
  { id: 2, name: '林小红', departmentName: '内科' }
])
const selectedPatient = ref<any>(null)
const careForm = reactive({ type: '一般护理', content: '' })

const selectPatient = (row: any) => { selectedPatient.value = row }
const saveCare = () => {
  if (!careForm.content) return ElMessage.warning('请输入记录内容')
  ElMessage.success('护理记录保存成功')
  careForm.content = ''
}
</script>
