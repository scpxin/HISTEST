import request from './request'

// 获取医生列表
export const getDoctorList = (params?: any) => {
  return request.get('/doctor/list', { params })
}

// 获取今日预约列表
export const getTodayAppointments = (doctorId: number) => {
  return request.get('/doctor/appointments/today', { params: { doctorId } })
}

// 获取医生排班
export const getDoctorSchedule = (params: any) => {
  return request.get('/doctor/schedule', { params })
}

// 叫号
export const callNextPatient = (doctorId: number) => {
  return request.post('/doctor/call-next', null, { params: { doctorId } })
}

// 完成就诊
export const completeAppointment = (appointmentId: number) => {
  return request.post(`/doctor/complete/${appointmentId}`)
}
