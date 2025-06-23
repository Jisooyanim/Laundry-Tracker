<template>
    <div 
        class="q-pa-md bg-white flex items-center" 
        style="
            font-size: 18px; 
            box-shadow: rgba(0, 0, 0, 0.1) 0px 1px 2px 0px;
            margin-bottom: 2rem;
            ">
        <div class="q-mr-sm q-ml-lg">
            <slot name="icon">
                <q-icon name="local_laundry_service" color="blue" size="1.5rem"/>
            </slot>
        </div>
        <div style="font-size: 18px; font-weight: 700;">
            <slot name="title">Default Title</slot>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'PageHeader',
    }
</script>