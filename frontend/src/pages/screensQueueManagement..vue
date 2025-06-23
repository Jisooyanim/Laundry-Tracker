<template>
    <q-page style="background-color: #F8FBFB;">
        <PageHeader>
            <template #icon>
                <q-icon name="checkroom" color="blue" size="1.5rem"/>
            </template>
            <template #title>
                Queue Management
            </template>
        </PageHeader>

        <div class="q-mt-md" style="max-width: 100rem; margin: 0 auto;">
            <div class="row q-col-gutter-md">
                <div class="col-xs-12 col-sm-6 col-md-3">
                    <StatusTags>
                        <template #title>Total in Queue</template>
                        <template #value>24</template>
                        <template #icon>
                            <q-icon name="format_list_bulleted" color="primary" size="1.8rem" />
                        </template>
                    </StatusTags>
                </div>
                    
                <div class="col-xs-12 col-sm-6 col-md-3">
                    <StatusTags bg-color="#FEF9C3">
                        <template #title>Processing</template>
                        <template #value>8</template>
                        <template #icon>
                            <q-icon name="settings" :style="{ color: '#CA8B05' }" size="1.8rem" />
                        </template>
                    </StatusTags>
                </div>

                <div class="col-xs-12 col-sm-6 col-md-3">
                    <StatusTags bg-color="#DCFCE7">
                        <template #title>Ready for Pickup</template>
                        <template #value>12</template>
                        <template #icon>
                            <q-icon name="check" :style="{ color: '#25A855' }" size="1.8rem" />
                        </template>
                    </StatusTags>
                </div>

                <div class="col-xs-12 col-sm-6 col-md-3">   
                    <StatusTags bg-color="#F2E9FF">
                        <template #title>Avg. Wait Time</template>
                        <template #value>2.5h</template>
                        <template #icon>
                            <q-icon name="access_time_filled" :style="{ color: '#9232EA' }" size="1.8rem" />
                        </template>
                    </StatusTags>
                </div>
            </div>

            <div class="filter-container q-mt-md">
                <div class="row q-col-gutter-sm items-center">
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
                            label="All services" 
                            no-caps
                        >
                            <q-item clickable v-close-popup @click="onItemClick">
                                <q-item-section>
                                    <q-item-label>Option1</q-item-label>
                                </q-item-section>
                            </q-item>
                        </q-btn-dropdown>
                    </div>
                </div>
            </div>
        </div>

        <div class="q-mt-md" style="max-width: 100rem; margin: 0 auto;">
            <div class="row q-col-gutter-md">
                <div class="col-xs-12 col-sm-6 col-md-3">
                    <CardContainer>
                        <template #title>Pending</template>
                        <template #counter>4</template>
                        <template #itemCard>
                            <ItemCard>
                                <template #id>#LQ-001</template>
                                <template #time>10:30 AM</template>
                                <template #name>John Smith</template>
                                <template #service>Wash & Fold - 3 items</template>
                                <template #amount>$18.50</template>
                                <template #icon>
                                    <q-btn
                                        unelevated
                                        label="Start"
                                        no-caps
                                        color="primary"
                                        size="sm"
                                        class="text-weight-bold"
                                    />
                                </template>
                            </ItemCard>

                            <ItemCard>
                                <template #id>#LQ-001</template>
                                <template #time>10:30 AM</template>
                                <template #name>John Smith</template>
                                <template #service>Wash & Fold - 3 items</template>
                                <template #amount>$18.50</template>
                                <template #icon>
                                    <q-btn
                                        unelevated
                                        label="Start"
                                        no-caps
                                        color="primary"
                                        size="sm"
                                        class="text-weight-bold"
                                    />
                                </template>
                            </ItemCard>
                        </template>
                    </CardContainer>
                </div>

                <div class="col-xs-12 col-sm-6 col-md-3">
                    <CardContainer bgColor="#FEF9C3" textColor="#CA8B05">
                        <template #title>Processing</template>
                        <template #counter>6</template>
                        <template #itemCard>
                            <ItemCard bgColor="#FFFDE8" borderColor="#FACD14">
                                <template #id>#LQ-001</template>
                                <template #time>Started 1h ago</template>
                                <template #name>John Smith</template>
                                <template #service>Wash & Fold - 3 items</template>
                                <template #amount>$18.50</template>
                                <template #icon>
                                    <q-linear-progress 
                                        rounded
                                        :value="progress"
                                        size="8px"
                                        color="warning"
                                    />
                                </template>
                                <template #button>
                                    <q-btn
                                        unelevated
                                        label="Complete"
                                        no-caps
                                        color="positive"
                                        size="sm"
                                        class="full-width text-weight-bold"
                                    />
                                </template>
                            </ItemCard>
                        </template>
                    </CardContainer>
                </div>

                <div class="col-xs-12 col-sm-6 col-md-3">
                    <CardContainer bgColor="#DCFCE7" textColor="#25A855">
                        <template #title>Ready</template>
                        <template #counter>8</template>
                        <template #itemCard>
                            <ItemCard bgColor="#F1FDF5" borderColor="#4BDE81">
                                <template #id>#LQ-001</template>
                                <template #time>Ready 2h ago</template>
                                <template #name>John Smith</template>
                                <template #service>Wash & Fold - 3 items</template>
                                <template #amount>$18.50</template>
                                <template #icon>
                                    <q-btn
                                        flat
                                        round
                                        dense
                                        icon="call"
                                        color="primary"
                                        @click="handleCall"
                                    />
                                </template>
                                <template #button>
                                    <q-btn
                                        unelevated
                                        label="Mark Picked Up"
                                        no-caps
                                        color="primary"
                                        size="sm"
                                        class="full-width text-weight-bold"
                                    />
                                </template>
                            </ItemCard>
                        </template>
                    </CardContainer>
                </div>

                <div class="col-xs-12 col-sm-6 col-md-3">
                    <CardContainer bgColor="#e9f1ff" textColor="#1976D2">
                        <template #title>Completed</template>
                        <template #counter>6</template>
                        <template #itemCard>
                            <ItemCard bgColor="#EFF7FE" borderColor="#60A5FA">
                                <template #id>#LQ-001</template>
                                <template #time>Picked up</template>
                                <template #name>John Smith</template>
                                <template #service>Wash & Fold - 3 items</template>
                                <template #amount>$18.50</template>
                                <template #icon>
                                    <q-avatar color="green" text-color="white" size="sm">
                                        <q-icon name="check" size="xs" />
                                    </q-avatar>
                                </template>
                            </ItemCard>
                        </template>
                    </CardContainer>
                </div>
            </div>
        </div>
    </q-page>
</template>

<script>
import PageHeader from 'src/components/PageHeader.vue';
import StatusTags from 'src/components/StatusTags.vue';
import CardContainer from 'src/components/CardContainer.vue';
import ItemCard from 'src/components/ItemCard.vue';

export default {
    components: {
        PageHeader,
        StatusTags,
        CardContainer,
        ItemCard,
    },

    setup () {
        return {
            progress: 0.4
        }
    }
}
</script>