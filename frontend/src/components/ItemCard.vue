<template>
    <div class="q-mb-md">
        <q-card 
            flat
            :style="{
                backgroundColor: bgColor,
                height: auto, 
                borderLeft: '5px solid' + borderColor,
            }"
        >
            <q-card-section>
                <div class="row justify-between items-center q-mb-sm">
                    <div>
                        <slot name="id">#ID</slot>
                    </div>
                    <div style="color: #374050">
                        <slot name="time">Time</slot>
                    </div>
                </div>

                <div class="q-mb-sm" style="color: #374050">
                    <slot name="name">Customer Name</slot>
                </div>

                <div class="q-mb-md" style="color: #374050">
                    <slot name="service">Service</slot>
                </div>

                <div class="row items-center justify-between q-mb-sm">
                    <div class="text-subtitle2 text-weight-bold">
                        <slot name="amount">Amount</slot>
                    </div>

                    <div style="min-width: 5.5rem; display: flex; justify-content: flex-end;">
                        <slot name="icon">
                        <q-btn
                            unelevated
                            label="Button"
                            no-caps
                            color="primary"
                            size="sm"
                            class="text-weight-bold"
                        />
                        </slot>
                    </div>
                </div>

                <div v-if="$slots.button" class="row items-center justify-center">
                    <slot name="button">
                        <q-btn
                            unelevated
                            label="Button"
                            no-caps
                            color="primary"
                            size="sm"
                            class="full-width text-weight-bold"
                        />
                    </slot>
                </div>
            </q-card-section>
        </q-card>
    </div>
</template>

<script>
    export default {
        name: 'ItemCard',
        props: {
            bgColor: {
                type: String,
                default: '#F9FAFB'
            },
            borderColor: {
                type: String,
                default: '#9CA3AF'
            }
        }
    }
</script>