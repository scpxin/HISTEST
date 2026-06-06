import { defineStore } from 'pinia'
import { ref } from 'vue'
import { login as loginApi, getUserInfo } from '@/api/user'

export const useUserStore = defineStore('user', () => {
  const token = ref(localStorage.getItem('token') || '')
  const userInfo = ref(null)

  const loginFn = async (username, password) => {
    const res = await loginApi({ username, password })
    token.value = res.data
    localStorage.setItem('token', res.data)
    return res
  }

  const fetchUserInfo = async () => {
    const res = await getUserInfo()
    userInfo.value = res.data
    return res
  }

  const logout = () => {
    token.value = ''
    userInfo.value = null
    localStorage.clear()
  }

  return { token, userInfo, login: loginFn, fetchUserInfo, logout }
})
