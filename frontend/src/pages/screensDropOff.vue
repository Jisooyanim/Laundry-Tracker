<template>
    <q-page style="background-color: #F8FBFB;">
        <PageHeader>
            <template #icon>
                <q-icon name="checkroom" color="blue" size="1.5rem"/>
            </template>
            <template #title>
                New Drop-off
            </template>
        </PageHeader>

        <div class="flex flex-center q-mt-lg">
            <div class="row q-col-gutter-md">
                <div class="q-col-12 q-md-6">
                    <!-- Customer Info -->
                    <div class="form-card">
                        <div class="text-subtitle1 text-weight-bold">Customer Information</div>
                        <div class="row q-col-gutter-md ">
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

                        <div class="row q-col-gutter-md ">
                            <div class="q-col-6" style="width: 50%;">
                                <div class="text-subtitle2 text-black q-mb-sm q-mt-md">
                                    Phone Number<span style="color: red;">*</span>
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

                            <div class="q-col-6 q-mb-md" style="width: 50%;">
                                <div class="text-subtitle2 text-black q-mb-sm q-mt-md">
                                    Email (Optional)
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
                    </div>

                    <!-- Service Selection -->
                    <div class="form-card q-mt-lg">
                        <div class="text-subtitle1 text-weight-bold">Service Selection</div>
                        <div class="row q-col-gutter-md" style="width: 100%;">
                            <div class="col-xs-12 col-sm-6">
                                <q-btn
                                    flat
                                    class="q-pa-md full-height full-width"
                                    style="border: 1px solid #ccc; border-radius: 8px"
                                >
                                <template v-slot:default>
                                    <div class="column full-width" style="text-align: left;">
                                        <div>
                                            <div class="text-subtitle2 text-weight-bold text-uppercase q-mb-sm">
                                                Wash & Fold
                                            </div>
                                            <div class="text-subtitle2 text-primary text-weight-bold q-mt-xs">
                                                $4.50/lb
                                            </div>
                                        </div>
                                    </div>
                                </template>
                                </q-btn>
                            </div>

                            <div class="col-xs-12 col-sm-6">
                                <q-btn
                                    flat
                                    class="q-pa-md full-height full-width"
                                    style="border: 1px solid #ccc; border-radius: 8px"
                                >
                                <template v-slot:default>
                                    <div class="column full-width" style="text-align: left;">
                                        <div>
                                            <div class="text-subtitle2 text-weight-bold text-uppercase q-mb-sm">
                                                Dry Cleaning
                                            </div>
                                            <div class="text-subtitle2 text-primary text-weight-bold q-mt-xs">
                                                $12.00/item
                                            </div>
                                        </div>
                                    </div>
                                </template>
                                </q-btn>
                            </div>
                        </div>

                        <div class="row q-col-gutter-md q-mb-md" style="width: 100%;">
                            <div class="col-xs-12 col-sm-6">
                                <q-btn
                                    flat
                                    class="q-pa-md full-height full-width"
                                    style="border: 1px solid #ccc; border-radius: 8px"
                                >
                                <template v-slot:default>
                                    <div class="column full-width" style="text-align: left;">
                                        <div>
                                            <div class="text-subtitle2 text-weight-bold text-uppercase q-mb-sm">
                                                Wash Only
                                            </div>
                                            <div class="text-subtitle2 text-primary text-weight-bold q-mt-xs">
                                                $2.50/lb
                                            </div>
                                        </div>
                                    </div>
                                </template>
                                </q-btn>
                            </div>

                            <div class="col-xs-12 col-sm-6">
                                <q-btn
                                    flat
                                    class="q-pa-md full-height full-width"
                                    style="border: 1px solid #ccc; border-radius: 8px"
                                >
                                <template v-slot:default>
                                    <div class="column full-width" style="text-align: left;">
                                        <div>
                                            <div class="text-subtitle2 text-weight-bold text-uppercase q-mb-sm">
                                                Dry Only
                                            </div>
                                            <div class="text-subtitle2 text-primary text-weight-bold q-mt-xs">
                                                $2.00/lb
                                            </div>
                                        </div>
                                    </div>
                                </template>
                                </q-btn>
                            </div>
                        </div>
                    </div>

                    <!-- Item Details -->
                    <div class="form-card q-mt-lg">
                        <div class="text-subtitle1 text-weight-bold">Item Details</div>
                        <div class="row q-col-gutter-md">
                            <div class="q-col-6" style="width: 50%;">
                                <div class="text-subtitle2 text-black q-mb-sm q-mt-md">
                                    Weight (lbs)<span style="color: red;">*</span>
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
                                    Number of Items<span style="color: red;">*</span>
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

                        <div class="text-subtitle2 text-black q-mb-sm q-mt-md">Special Instructions</div>
                        <q-input
                            filled
                            dense
                            v-model="text"
                            type="textarea"
                            class="no-focus"
                            input-class="text-black"
                            color="accent"
                            autogrow
                        />

                        <div class="text-subtitle2 text-black q-mb-sm q-mt-md">Priority Level</div>
                        <q-select
                            filled
                            dense
                            v-model="priorityLevel"
                            :options="options"
                            placeholder="Please select"
                            class="text-white no-focus q-mb-md"
                        />
                    </div>

                    <!-- Additional Services -->
                    <div class="form-card q-mt-lg q-mb-lg"> 
                        <div class="text-subtitle1 text-weight-bold">Additional Services</div>
                        <div class="row items-center justify-between">
                            <q-checkbox size="xs" v-model="shape" val="xs" label="Stain Treatment" />
                            <p class="q-mb-none">+$3.00</p>
                        </div>
                        <div class="row items-center justify-between">
                            <q-checkbox size="xs" v-model="shape" val="xs" label="Fabric Softener" />
                            <p class="q-mb-none">+$2.00</p>
                        </div>
                        <div class="row items-center justify-between">
                            <q-checkbox size="xs" v-model="shape" val="xs" label="Eco-Friendly Detergent" />
                            <p class="q-mb-none">+$4.00</p>
                        </div>
                        <div class="row items-center justify-between q-mb-sm">
                            <q-checkbox size="xs" v-model="shape" val="xs" label="Pickup & Delivery" />
                            <p class="q-mb-none">+$8.00</p>
                        </div>
                    </div>
                </div>

                <!-- Order Summary -->
                <div class="q-col-12 q-md-6">
                    <div class="status-card q-ml-md">
                        <div class="text-subtitle1 text-weight-bold">Order Summary</div>
                        <div class="row items-center justify-between">
                            <p class="q-mb-none">Service:</p>
                            <p class="q-mb-none">SERVICE</p>
                        </div>
                        <div class="row items-center justify-between">
                            <p class="q-mb-none">Weight:</p>
                            <p class="q-mb-none">WEIGHT</p>
                        </div>
                        <div class="row items-center justify-between">
                            <p class="q-mb-none">Items:</p>
                            <p class="q-mb-none">NUMBER</p>
                        </div>
                        <div class="q-mt-md q-mb-md" style="height: 1px; background-color: #ccc;"></div>

                        <div class="row items-center justify-between">
                            <p class="q-mb-none">Base Service:</p>
                            <p class="q-mb-none">200</p>
                        </div>
                        <div class="row items-center justify-between">
                            <p class="q-mb-none">Stain Treatment:</p>
                            <p class="q-mb-none">100</p>
                        </div>
                        <div class="row items-center justify-between">
                            <p class="q-mb-none">Tax:</p>
                            <p class="q-mb-none">TAX</p>
                        </div>
                        <div class="q-mt-md q-mb-md" style="height: 1px; background-color: #ccc;"></div>

                        <div class="row items-center justify-between">
                            <p class="q-mb-none">Total:</p>
                            <p class="q-mb-none">1000</p>
                        </div>

                        <div class="text-subtitle2 text-black q-mb-sm q-mt-md">Payment Method</div>
                        <q-select
                            filled
                            dense
                            v-model="priorityLevel"
                            :options="options"
                            placeholder="Please select"
                            class="text-white no-focus q-mb-xs"
                        />

                        <q-btn unelevated no-caps label="Create Order" class="q-mt-md text-white" style="background-color: #2463EA" />
                        <q-btn unelevated no-caps label="Cancel" class="q-mt-none text-black" style="background-color: #F2F5F6" />

                        <p class="q-mb-none text-center text-caption">Queue Position: #25</p>
                    </div>
                </div>
            </div>
        </div>
    </q-page>
</template>

<script>
import PageHeader from 'src/components/PageHeader.vue';

export default {
    components: {
        PageHeader
    },
}
</script>