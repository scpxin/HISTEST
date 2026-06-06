import request from './request'

// 用户登录
export const login = (data: { username: string; password: string }) => {
  return request.post('/user/login', data)
}

// 获取用户信息
export const getUserInfo = () => {
  return request.get('/user/info')
}

// 获取医生列表
export const getDoctors = () => {
  return request.get('/user/doctors')
}

// 获取护士列表
export const getNurses = () => {
  return request.get('/user/nurses')
}

// 退出登录
export const logout = () => {
  return request.post('/user/logout')
}
