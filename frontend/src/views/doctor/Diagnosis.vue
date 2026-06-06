<template>
  <div>
    <h2>诊断开方</h2>
    <el-row :gutter="20" style="margin-top: 20px">
      <el-col :span="8">
        <el-card>
          <template #header>今日待诊</template>
          <el-table :data="waitingList" size="small" @row-click="selectPatient">
            <el-table-column prop="patientName" label="患者" />
            <el-table-column prop="symptoms" label="症状" />
          </el-table>
        </el-card>
      </el-col>
      <el-col :span="16">
        <el-card>
          <template #header>诊断信息</template>
          <el-form :model="form" label-width="80px" v-if="selectedPatient">
            <el-form-item label="患者姓名">
              <el-input v-model="selectedPatient.patientName" disabled />
            </el-form-item>
            <el-form-item label="症状描述">
              <el-input v-model="form.symptoms" type="textarea" :rows="3" />
            </el-form-item>
            <el-form-item label="诊断结果">
              <el-input v-model="form.diagnosis" type="textarea" :rows="2" />
            </el-form-item>
            <el-button type="primary" @click="savePrescription">保存处方</el-button>
          </el-form>
          <el-empty v-else description="请选择患者" />
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script setup lang="ts">
import { ref, reactive } from 'vue'
import { ElMessage } from 'element-plus'

const waitingList = ref([
  { id: 1, patientName: '陈大明', symptoms: '头痛、发热' },
  { id: 2, patientName: '林小红', symptoms: '咳嗽、胸闷' }
])
const selectedPatient = ref<any>(null)
const form = reactive({ symptoms: '', diagnosis: '' })

const selectPatient = (row: any) => {
  selectedPatient.value = row
  form.symptoms = row.symptoms
}
const savePrescription = () => {
  ElMessage.success('处方保存成功')
}
</script>
