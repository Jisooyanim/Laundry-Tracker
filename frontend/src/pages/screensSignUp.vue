<template>
    <q-page style="background-color: #E8F1FF;">
        <div class="flex column items-center text-center">
            <q-avatar rounded size="50px" class="q-mt-md" style="background-color: #2463EA">
                <q-icon name="local_laundry_service" style="color: white"/>
            </q-avatar>
            <p class="q-mt-md" style="margin-bottom: 10px; font-size: 20px; font-weight: 600;">Join LaundryQ</p>
            <p style="margin: 0; color: gray;">Create your account to get started</p>
        </div>

        <div class="flex flex-center q-mt-lg">
            <div class="login-card" style="margin-bottom: 3rem;">
                <div class="text-subtitle2 text-black">I am a:</div>
                <div class="row q-col-gutter-md">
                    <div class="q-col-6" style="width: 50%;">
                    <q-btn
                        flat
                        class="q-pa-md full-width"
                        style="border: 1px solid #ccc; border-radius: 8px;"
                    >
                        <template v-slot:default>
                        <div class="column items-center">
                            <q-icon name="person" size="32px" color="grey" />
                            <div class="text-caption text-weight-medium q-mt-sm" style="color: grey;">
                                Staff
                            </div>
                        </div>
                        </template>
                    </q-btn>
                    </div>

                    <div class="q-col-6" style="width: 50%;">
                    <q-btn
                        flat
                        class="q-pa-md full-width"
                        style="border: 1px solid #ccc; border-radius: 8px;"
                    >
                        <template v-slot:default>
                        <div class="column items-center">
                            <q-icon name="store" size="32px" color="grey" />
                            <div class="text-caption text-weight-medium q-mt-sm" style="color: grey;">
                                Admin/Owner
                            </div>
                        </div>
                        </template>
                    </q-btn>
                    </div>
                </div>

                <div class="row q-col-gutter-md">
                    <div class="q-col-6" style="width: 50%;">
                        <div class="text-subtitle2 text-black q-mb-sm q-mt-md">
                            First name<span style="color: red;">*</span>
                        </div>
                        <q-input
                            filled
                            dense
                            v-model="text"
                            class="no-focus"
                            input-class="text-black"
                            color="accent"
                        />
                    </div>

                    <div class="q-col-6" style="width: 50%;">
                        <div class="text-subtitle2 text-black q-mb-sm q-mt-md">
                            Last name<span style="color: red;">*</span>
                        </div>
                        <q-input
                            filled
                            dense
                            v-model="text"
                            class="no-focus"
                            input-class="text-black"
                            color="accent"
                        />
                    </div>
                </div>

                <div class="q-mt-md text-subtitle2 text-black">
                    Email address<span style="color: red;">*</span>
                </div>
                <q-input
                    filled
                    dense
                    v-model="text"
                    class="no-focus"
                    input-class="text-black"
                    color="accent"
                />

                <div class="q-mt-md text-subtitle2 text-black" style="margin-bottom: 0;">
                    Phone number<span style="color: red;">*</span>
                </div>
                <q-input
                    filled
                    dense
                    v-model="text"
                    class="no-focus"
                    input-class="text-black"
                    color="accent"
                />

                <div class="q-mt-md text-subtitle2 text-black" style="margin-bottom: 0;">
                    Password<span style="color: red;">*</span>
                </div>
                <q-input
                    filled
                    dense
                    v-model="text"
                    class="no-focus"
                    input-class="text-black"
                    color="accent"
                />

                <div class="q-mt-md text-subtitle2 text-black" style="margin-bottom: 0;">
                    Confirm password<span style="color: red;">*</span>
                </div>
                <q-input
                    filled
                    dense
                    v-model="text"
                    class="no-focus"
                    input-class="text-black"
                    color="accent"
                />

                <q-btn unelevated no-caps label="Create Account" class="q-mt-lg text-white" style="background-color: #2463EA" />

                <div class="q-mt-md q-mb-md flex items-center justify-center">
                    <div style="flex: 1; height: 1px; background-color: #ccc;"></div>
                    <div class="q-px-sm text-caption text-grey-7">OR</div>
                    <div style="flex: 1; height: 1px; background-color: #ccc;"></div>
                </div>

                <div class="flex column text-center" style="width: 100%;">
                    <p>
                    Already have an account?
                    <router-link to="/" class="text-primary cursor-pointer" style="text-decoration: none;">
                        Sign in
                    </router-link>
                    </p>
                </div>
            </div>
        </div>
    </q-page>
</template>

<script setup>

</script>