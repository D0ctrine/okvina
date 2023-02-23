<template>
    <v-container style="height: 100vh">
      <v-row style="height: 100vh;">
        <v-col sm="3" md="4">
          <category ref="tree"/>
        </v-col>
        <v-divider inset vertical></v-divider>
        <v-col sm="7" md="8">
          <div v-if="!getCategorySelectedFlag" class="title grey--text text--darken-1 font-weight-light text-center">
            <h2>Select a Company
              <v-icon left size="45">
                mdi-office-building
              </v-icon>
            </h2>
          </div>
          <v-container v-if="getCategorySelectedFlag">
            <configFile v-bind:getClickedMenu='getClickedMenu' v-if="getClickedMenu.file_type === 'COG'"/>
            <settingTabs v-bind:getClickedMenu='getClickedMenu' v-if="getClickedMenu.file_type === 'TXT'" @callCategory="this.$refs.refreshCategory"/>
            <inFile v-bind:getClickedMenu='getClickedMenu' v-if="getClickedMenu.file_type === 'TXT_IN'" @callCategory="this.$refs.refreshCategory"/>
          </v-container>
        </v-col>
        </v-row>
  </v-container>
</template>
<script>
import category from '@/views/mainpanel/settings/component/SettingsCategory'
import settingTabs from '@/views/mainpanel/settings/settingType/settingTabs'
import configFile from '@/views/mainpanel/settings/config/configFile'
import inFile from '@/views/mainpanel/settings/inConfig/inconfig'

export default {
  data: () => ({
  }),
  components: {
    category, settingTabs, configFile, inFile
  },
  computed: {
    getClickedMenu () {
      return this.$store.getters.clickedCategory
    },
    getCategorySelectedFlag () {
      return this.$store.getters.categoryClickFlag
    }
  }
}
</script>
