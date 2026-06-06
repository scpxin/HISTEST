import request from './request'

// 获取护士列表
export const getNurseList = (params?: any) => {
  return request.get('/nurse/list', { params })
}

// 获取排班信息
export const getSchedule = (params: any) => {
  return request.get('/nurse/schedule', { params })
}

// 添加排班
export const addSchedule = (data: any) => {
  return request.post('/nurse/schedule', data)
}

// 获取护理记录
export const getCareRecords = (patientId: number) => {
  return request.get('/nurse/care-records', { params: { patientId } })
}

// 添加护理记录
export const addCareRecord = (data: any) => {
  return request.post('/nurse/care-records', data)
}

// 获取今日待执行医嘱
export const getTodayMedications = (nurseId?: number) => {
  return request.get('/nurse/medications/today', { params: { nurseId } })
}

// 执行医嘱
export const executeMedication = (id: number, nurseId: number, remark?: string) => {
  return request.post(`/nurse/medications/${id}/execute`, null, {
    params: { nurseId, remark }
  })
}
