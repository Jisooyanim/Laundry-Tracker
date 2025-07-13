<template>
    <q-page style="background-color: #F8FBFB;">
        <PageHeader>
            <template #icon>
                <q-icon name="checkroom" color="blue" size="1.5rem"/>
            </template>
            <template #title>
                Pickup Tracking
            </template>
        </PageHeader>

        <div class="q-mt-md" style="max-width: 100rem; margin: 0 auto;">
            <div class="row q-col-gutter-md">
                <div class="col-xs-12 col-sm-6 col-md-3">
                    <PickupTags fillColor="#FFFDE8" borderColor="#FFF39F" textColor="#713F12">
                        <template #title>In Processing</template>
                        <template #value>8</template>
                        <template #icon>
                            <q-icon name="access_time_filled" :style="{ color: '#CA8B05' }" size="1.8rem" />
                        </template>
                    </PickupTags>
                </div>

                <div class="col-xs-12 col-sm-6 col-md-3">
                    <PickupTags textColor="#14803C">
                        <template #title>Ready for Pickup</template>
                        <template #value>12</template>
                        <template #icon>
                            <q-icon name="check_circle" :style="{ color: '#16A24B' }" size="1.8rem" />
                        </template>
                    </PickupTags>
                </div>

                <div class="col-xs-12 col-sm-6 col-md-3">
                    <PickupTags fillColor="#FEF3F3" borderColor="#FDD7D6" textColor="#B83136">
                        <template #title>Overdue</template>
                        <template #value>12</template>
                        <template #icon>
                            <q-icon name="warning" :style="{ color: '#DD2726' }" size="1.8rem" />
                        </template>
                    </PickupTags>
                </div>

                <div class="col-xs-12 col-sm-6 col-md-3">
                    <PickupTags fillColor="#EFF7FE" borderColor="#C6DFFE" textColor="#1D68E2">
                        <template #title>Picked Up Today</template>
                        <template #value>15</template>
                        <template #icon>
                            <q-icon name="front_hand" :style="{ color: '#2463EA' }" size="1.8rem" />
                        </template>
                    </PickupTags>
                </div>
            </div>

            <div class="filter-container q-mt-md">
                <div class="row q-col-gutter-sm items-center justify-between">
                    <div class="col-xs-12 col-sm-5 col-md-3">
                        <q-input
                            outlined
                            dense
                            v-model="search"
                            class="no-focus q-mr-md"
                            input-class="text-black"
                            color="accent"
                            placeholder="Search orders"
                        >
                            <template v-slot:prepend>
                                <q-icon name="search" />
                            </template>
                        </q-input>
                    </div>
                    
                    <div class="col-auto">
                        <q-btn-dropdown 
                            unelevated 
                            class="filter-buttons q-mr-md" 
                            label="All status" 
                            no-caps
                        >
                            <q-item clickable v-close-popup @click="onItemClick">
                                <q-item-section>
                                    <q-item-label>Option1</q-item-label>
                                </q-item-section>
                            </q-item>
                        </q-btn-dropdown>
                    </div>

                    <div class="col-auto">
                        <q-btn-dropdown 
                            unelevated 
                            class="filter-buttons" 
                            label="All dates" 
                            no-caps
                        >
                            <q-item clickable v-close-popup @click="onItemClick">
                                <q-item-section>
                                    <q-item-label>Option1</q-item-label>
                                </q-item-section>
                            </q-item>
                        </q-btn-dropdown>
                    </div>

                    <q-space />

                    <div class="col-auto">
                        <q-btn 
                            unelevated 
                            color="primary" 
                            icon="notifications" 
                            label="Send Reminders" 
                            no-caps 
                            class="q-mr-sm text-white"
                            style="border-radius: 8px;"
                        />
                        <q-btn 
                            unelevated 
                            color="green" 
                            icon="print" 
                            label="Print Labels" 
                            no-caps 
                            class="text-white"
                            style="border-radius: 8px;"
                        />
                    </div>
                </div>
            </div>
        </div>

        <div class="q-mt-md" style="max-width: 100rem; margin: 0 auto;">
            <q-table 
                flat 
                bordered
                title="Pickup Orders"
                no-data-label="No orders"
                :rows="rows"
                class="q-mt-md"
            >

            </q-table>
        </div>
    </q-page>
</template>

<script>
import PageHeader from 'src/components/PageHeader.vue';
import PickupTags from 'src/components/PickupTags.vue';

export default {
    components: {
        PageHeader,
        PickupTags
    },

    data () {
        return {
            search: '',
            rows: []
        }
    }
}
</script>