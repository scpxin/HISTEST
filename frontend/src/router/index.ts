import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/login',
    component: () => import('@/views/common/Login.vue')
  },
  {
    path: '/',
    component: () => import('@/components/Layout.vue'),
    redirect: '/dashboard',
    children: [
      {
        path: 'dashboard',
        component: () => import('@/views/common/Dashboard.vue')
      },
      {
        path: 'doctor/patients',
        component: () => import('@/views/doctor/PatientList.vue')
      },
      {
        path: 'doctor/diagnosis',
        component: () => import('@/views/doctor/Diagnosis.vue')
      },
      {
        path: 'doctor/prescriptions',
        component: () => import('@/views/doctor/Prescriptions.vue')
      },
      {
        path: 'nurse/schedule',
        component: () => import('@/views/nurse/Schedule.vue')
      },
      {
        path: 'nurse/care',
        component: () => import('@/views/nurse/PatientCare.vue')
      },
      {
        path: 'nurse/medication',
        component: () => import('@/views/nurse/Medication.vue')
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach((to, from, next) => {
  const token = localStorage.getItem('token')
  if (to.path !== '/login' && !token) {
    next('/login')
  } else {
    next()
  }
})

export default router
