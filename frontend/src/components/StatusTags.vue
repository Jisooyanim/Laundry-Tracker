<template>
    <div 
        class="q-pa-md bg-white row items-center justify-between"
        style="
            box-shadow: rgba(0, 0, 0, 0.1) 0px 1px 2px 0px;
            border-radius: 12px;
            min-width: 14rem;
        "
    >
        <div class="column q-pa-xs">
            <div class="text-body2 text-grey-7">
                <slot name="title">Default Title</slot>
            </div>
            <div class="text-h6 text-weight-bold text-black">
                <slot name="value">0</slot>
            </div>
        </div>

        <div
            class="flex flex-center"
            :style="{
                backgroundColor: bgColor,
                borderRadius: '50%',
                width: '48px',
                height: '48px'
            }"
        >
            <slot name="icon">
                <q-icon name="code" color="primary" size="1.8rem" />
            </slot>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'StatusTags',
        props: {
            bgColor: {
            type: String,
            default: '#e9f1ff'
            }
        }
    }
</script>