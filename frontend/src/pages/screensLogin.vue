<template>
  <q-page style="background-color: #E8F1FF;">
    <div class="fullscreen flex flex-center">
      <div class="login-card">
        <!-- Title -->
        <div class="flex column items-center text-center" style="width: 100%;">
          <q-avatar size="50px" class="laundry-avatar">
            <q-icon name="local_laundry_service" style="color: #2463EA"/>
          </q-avatar>
          <p class="q-mt-md" style="margin-bottom: 10px; font-size: 20px; font-weight: 600;">LaundryQ</p>
          <p style="margin: 0; color: gray;">Welcome back to your laundry tracker</p>
        </div>

        <!-- Form -->
        <div class="flex column q-mt-md" style="width: 100%;">
          <div class="text-subtitle2 text-black q-mb-sm">
            Email<span style="color: red;">*</span>
          </div>
          <q-input
            filled
            dense
            v-model="email"
            placeholder="Enter your email"
            class="no-focus"
            input-class="text-black"
            color="accent"
          />
          <div class="text-subtitle2 text-black q-mb-sm q-mt-md">
            Password<span style="color: red;">*</span>
          </div>
          <q-input
            filled
            dense
            v-model="password"
            placeholder="Enter your password"
            class="no-focus"
            input-class="text-black"
            color="accent"
          />
          <div class="flex justify-between items-center q-mt-md" style="width: 100%;">
            <q-checkbox dense v-model="rememberMe" size="xs" label="Remember me"/>
            <router-link to="/forgotPassword" class="text-primary cursor-pointer" style="text-decoration: none;">
              Forgot Password?
            </router-link>
          </div>
          <q-btn unelevated no-caps label="Sign In" class="q-mt-lg text-white" style="background-color: #2463EA" />
          <div class="flex column text-center q-mt-lg" style="width: 100%;">
            <p>
              Don't have an account?
              <router-link to="/signup" class="text-primary cursor-pointer" style="text-decoration: none;">
                Sign up
              </router-link>
            </p>
          </div>
        </div>
      </div>
    </div>
  </q-page>
</template>

<script setup>

</script>
