<template>
    <div class="q-mt-lg">
        <q-card 
            style="
                width: 100%;
                box-shadow: rgba(0, 0, 0, 0.1) 0px 1px 2px 0px;
        ">
            <q-card-section class="row justify-between">
                <div class="text-weight-bold">
                    <slot name="title">Default Title</slot>
                </div>
                <q-avatar
                    size="sm"
                    :style="{
                        backgroundColor: bgColor,
                        color: textColor
                }"
                >
                    <slot name="counter">n</slot>
                </q-avatar>
            </q-card-section>

            <q-separator />

            <q-card-section lass="scrollable-section" style="min-height: 30rem; max-height: 30rem; overflow-y: auto;">
                <slot name="itemCard">No items</slot>
            </q-card-section>
        </q-card>
    </div>
</template>

<script>
    export default {
        name: 'CardContainer',
        props: {
            bgColor: {
                type: String,
                default: '#F3F5F7'
            },
            textColor: {
                type: String,
                default: '#4E5160'
            }
        }
    }
</script>