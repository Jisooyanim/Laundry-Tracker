const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/screensLogin.vue') },
      { path: 'signUp', component: () => import('pages/screensSignUp.vue') },
      { path: 'forgotPassword', component: () => import('src/pages/screensForgotPassword.vue') },
      { path: 'home', component: () => import('src/pages/screensDashboard.vue') },
      { path: 'dropoff', component: () => import('src/pages/screensDropOff.vue') },
      { path: 'pickup', component: () => import('src/pages/screensPickupTracking.vue') },
      { path: 'queue', component: () => import('src/pages/screensQueueManagement..vue') },
    ]
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/ErrorNotFound.vue')
  }
]

export default routes
