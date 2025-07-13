<template>
    <div 
        class="q-pa-md row items-center justify-between"
        :style="{
            backgroundColor: fillColor,
            borderRadius: '12px',
            minWidth: '14rem',
            border: '2px solid' + borderColor,
        }"
    >
        <div class="column q-pa-xs" :style="{ color: textColor }">
            <div class="text-body2">
                <slot name="title">Default Title</slot>
            </div>
            <div class="text-h6 text-weight-bold">
                <slot name="value">0</slot>
            </div>
        </div>

        <div class="flex flex-center">
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
            fillColor: {
                type: String,
                default: '#F1FDF5'
            },
            borderColor: {
                type: String,
                default: '#CEF9DD'
            },
            textColor: {
                type: String,
                default: '#000'
            }
        }
    }
</script>