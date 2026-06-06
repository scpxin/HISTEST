import request from './request'

// 获取患者列表
export const getPatientList = (params: any) => {
  return request.get('/patient/list', { params })
}

// 获取患者详情
export const getPatientById = (id: number) => {
  return request.get(`/patient/${id}`)
}

// 新增患者
export const createPatient = (data: any) => {
  return request.post('/patient', data)
}

// 更新患者信息
export const updatePatient = (id: number, data: any) => {
  return request.put(`/patient/${id}`, data)
}

// 删除患者
export const deletePatient = (id: number) => {
  return request.delete(`/patient/${id}`)
}

// 获取在院患者
export const getInpatients = () => {
  return request.get('/patient/inpatients')
}
