<template>
    <q-page style="background-color: #E8F1FF;">
        <div class="fullscreen flex flex-center">
            <div class="login-card">
                <div class="flex column items-center text-center" style="width: 100%;">
                    <q-avatar size="50px" class="laundry-avatar">
                        <q-icon name="local_laundry_service" style="color: #2463EA"/>
                    </q-avatar>
                </div>

                <h5 class="q-mt-sm q-mb-none">Forgot your password?</h5>
                <p class="q-mt-md q-mb-none" style="text-align: justify">If you can't remember your password, please enter your username 
                below and click the "Request password reset" button.</p>
                <p class="q-mt-sm" style="text-align: justify">An email with reset instructions will be sent to your registered email address.</p>

                <div class="text-subtitle2 text-black q-mb-none">
                    Email address<span style="color: red;">*</span>
                </div>
                <q-input
                    filled
                    dense
                    v-model="text"
                    class="no-focus q-mb-md"
                    input-class="text-black"
                    color="accent"
                />

                <q-btn 
                    unelevated 
                    no-caps 
                    label="Request password reset" 
                    class="q-mt-md q-mb-lg text-white" 
                    style="background-color: #2463EA" 
                />

                <router-link to="/" class="q-mb-sm text-primary cursor-pointer block text-right" style="text-decoration: none;">
                    Back to log in
                </router-link>
            </div>
        </div>
    </q-page>
</template>

<script>

</script>