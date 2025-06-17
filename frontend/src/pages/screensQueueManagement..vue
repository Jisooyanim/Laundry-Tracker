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
    </q-page>
</template>

<script>
import PageHeader from 'src/components/PageHeader.vue';

export default {
    components: {
        PageHeader
    }
}
</script>