<template>
    <v-app>
      <v-container fluid style="height: 740px;overflow-y:auto;overflow-x: hidden;">
        <v-spacer style="height: 50px;"></v-spacer>
        <v-row>
          <p class="itemHeader text-left"><v-icon size="30">mdi-file-star-outline</v-icon>파일 저장 위치</p>
        </v-row>
        <v-row>
          <v-text-field label="절대 경로" v-model="fileFolderSave" @keyup="keypress()" placeholder="절대 경로"></v-text-field>
        </v-row>
        <v-row>
          <p class="itemHeader text-left"><v-icon size="30">mdi-file-star-outline</v-icon>작업 성공 위치</p>
        </v-row>
        <v-row>
            <v-text-field label="절대 경로" v-model="fileFolderComplete" placeholder="절대 경로"></v-text-field>
        </v-row>
        <v-row>
          <p class="itemHeader text-left"><v-icon size="30">mdi-file-star-outline</v-icon>작업 실패 위치</p>
        </v-row>
        <v-row>
            <v-text-field label="절대 경로" v-model="fileFolderFail" placeholder="절대 경로"></v-text-field>
        </v-row>
        <v-spacer style="height: 50px;"></v-spacer>
      </v-container>
    </v-app>
    </template>
<script>
export default {
  name: 'myGrid',
  props: ['selected'],
  components: {},
  data: () => ({
    fileFolderSave: 'D:/',
    fileFolderComplete: '',
    fileFolderFail: ''
  }),
  methods: {
    keypress () {
      this.fileFolderComplete = this.fileFolderSave
      this.fileFolderFail = this.fileFolderSave
    }
  }
}
</script>
<style>
    .v-label {
      font-size: 13px;
    }
    .itemHeader {
      font-weight: bold;
      width: 97%;
      font-size: 14px;
    }
</style>
