<template>
<v-container class="" fluid>
  <v-tabs v-model="tabs" style="" fixed-tabs>
          <v-tabs-slider></v-tabs-slider>
          <v-tab href="#mobile-tabs-5-1" style="text-decoration: none;">
            <v-icon>mdi-cog</v-icon> 설정
          </v-tab>
          <v-tab href="#mobile-tabs-5-2" style="text-decoration: none;" @click="getDataToDBcomponent">
            <v-icon>mdi-database-cog</v-icon> DB
          </v-tab>
        </v-tabs>
        <v-divider class="mb-0 mt-0"></v-divider>
    <v-tabs-items v-model="tabs">
      <v-tab-item v-for="i in 2" :key="i" :value="'mobile-tabs-5-' + i">
          <v-scroll-y-transition mode="out-in">
          <v-card class="mt-6 mx-auto" flat>
              <SettingsForm v-if="i == 1" ref="settings" v-bind:selected='getClickedMenu' @refreshCategory="callCategory" />
            <v-card-text v-if="i == 2">
              <DBsForm v-bind:selected='getClickedMenu' v-bind:settingPropsList='settingList'/>
            </v-card-text>
          </v-card>
        </v-scroll-y-transition>
      </v-tab-item>
    </v-tabs-items>
    </v-container>
</template>
<script>
import SettingsForm from '@/views/mainpanel/settings/settingType/SettingsForm'
import DBsForm from '@/views/mainpanel/settings/settingType/DBsForm'

export default {
  data () {
    return {
      tabs: null,
      settingList: []
    }
  },
  props: ['selected'],
  components: {
    SettingsForm,
    DBsForm
  },
  computed: {
    getClickedMenu () {
      return this.$store.getters.clickedCategory
    }
  },
  methods: {
    getDataToDBcomponent: async function () {
      this.settingList = await this.$refs.settings[0].sendDataToDBcomponent()
      return this.settingList
    },
    callCategory: async function () {
      this.$emit('callCategory', true)
    }
  }
}
</script>
<style>
.tabStyle {
  height: 10px;
}
</style>
