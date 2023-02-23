<template>
<v-container>
<v-sheet class="pa-3 primary darken-1">
    <v-text-field
      v-model="search"
      label="Search Company"
      dark
      flat
      solo-inverted
      hide-details
      clearable
      clear-icon="mdi-close-circle-outline"
    ></v-text-field>
    <v-checkbox
      v-model="caseSensitive"
      dark
      hide-details
      label="Case sensitive search"
    ></v-checkbox>
  </v-sheet>
    <v-progress-linear indeterminate v-if="this.lineProcess" color="yellow darken-1"></v-progress-linear>
<v-btn color="blue-grey" class="ma-2 white--text" @click="addNode" width="90%">
    Add Folder
    <v-icon right>
      mdi-folder-plus
    </v-icon>
  </v-btn>
  <vue-tree-list
    @click="onClick"
    @change-name="onChangeName"
    @delete-node="onDel"
    @add-node="onAddNode"
    :model="data"
    :search="search"
    default-tree-node-name="new folder"
    default-leaf-node-name="new file"
    v-bind:default-expanded="false"
  >
    <template v-slot:leafNameDisplay="slotProps">
      <span class="pointer">
        {{ slotProps.model.name }}
      </span>
    </template>
    <span class="pointer icon" slot="addTreeNodeIcon">📂</span>
    <span class="pointer icon" slot="addLeafNodeIcon"><v-icon>mdi-plus</v-icon></span>
    <span class="pointer icon" slot="editNodeIcon">📃</span>
    <span class="pointer icon" slot="delNodeIcon">✂️</span>
    <span class="pointer icon" slot="leafNodeIcon"><v-icon>mdi-file-document-outline</v-icon></span>
    <span class="pointer icon" slot="treeNodeIcon"><v-icon>mdi-folder</v-icon></span>
  </vue-tree-list>
</v-container>
</template>
<script>
import { VueTreeList, Tree, TreeNode } from 'vue-tree-list'
import categoryService from '@/services/category'

export default {
  data: () => ({
    active: [],
    tabs: null,
    data: new Tree([{ name: 'No Data', id: '0', disabled: true, depth: '2', file_type: 'file' }]),
    open: [],
    search: null,
    lineProcess: false,
    caseSensitive: false
  }),
  created () {
    this.searchTree()
    this.$store.dispatch('noneClickCategory')
  },
  components: {
    VueTreeList
  },
  methods: {
    searchTree () {
      this.lineProcess = true
      categoryService.categories().then(data => {
        const list = data.categories
        if (list && list.length > 0) {
          const oneDepth = []
          const twoDepth = []
          const threeDepth = []

          for (let i = 0; i < list.length; i++) {
            list[i].pid = list[i].parent
            list[i].dragDisabled = true
            if (list[i].file_type === 'folder') list[i].isLeaf = false
            else list[i].isLeaf = true

            if (list[i].depth === '1') {
              list[i].children = []
              oneDepth.push(list[i])
            } else if (list[i].depth === '2') {
              list[i].children = []
              twoDepth.push(list[i])
            } else if (list[i].depth === '3') {
              list[i].addTreeNodeDisabled = true
              list[i].addLeafNodeDisabled = true
              threeDepth.push(list[i])
            }
          }
          for (let i = 0; i < twoDepth.length; i++) {
            for (let j = 0; j < threeDepth.length; j++) {
              if (String(twoDepth[i].id) === threeDepth[j].parent) {
                twoDepth[i].children.push(threeDepth[j])
              }
            }
          }
          for (let i = 0; i < oneDepth.length; i++) {
            for (let j = 0; j < twoDepth.length; j++) {
              if (String(oneDepth[i].id) === twoDepth[j].parent) {
                oneDepth[i].children.push(twoDepth[j])
              }
            }
          }
          this.data = new Tree(oneDepth)
        }
        this.lineProcess = false
      })
    },
    onDel (node) {
      const category = JSON.parse(node)
      if (confirm('삭제하시겠습니까?(복원 가능)')) {
        categoryService.delete(category).then((deletedCategory) => {
          console.log(deletedCategory)
          node.remove()
          this.searchTree()
          this.close()
        }).catch(error => {
          this.errorMessage = error.message
          console.log(error)
        })
      }
    },
    onChangeName (category) {
      if (category.eventType === 'blur') {
        categoryService.update(category).then((updatedCategory) => {
          console.log(updatedCategory)
          this.searchTree()
          this.close()
        }).catch(error => {
          this.errorMessage = error.message
        })
      }
      console.log(category)
    },
    onAddNode (category) {
      if (category.isLeaf) {
        category.file_type = 'file'
      } else {
        category.file_type = 'folder'
      }

      if (category.parent.depth) {
        if (category.parent.depth === '1') category.depth = '2'
        else if (category.parent.depth === '2') category.depth = '3'
      } else category.depth = '1'

      console.log(category)
      category.parent = category.parent.id
      categoryService.create(category).then((createdCategory) => {
        category.id = createdCategory.id
        console.log(category)
        this.$store.dispatch('addCategory', createdCategory)
        this.close()
      }).catch(error => {
        this.errorMessage = error.message
        console.log(this.errorMessage)
      })
    },
    onClick (params) {
      console.log('--------------------active & params-------------------')
      this.active = []
      if (params.file_type && params.file_type === 'file') {
        if (params.depth === '2') params.file_type = 'COG'
        else if (params.depth === '3' && params.parent.name === 'OUT') params.file_type = 'TXT'
        else if (params.depth === '3' && params.parent.name === 'IN') params.file_type = 'TXT_IN'
        // OUT 로직
        if (params.file_type === 'COG' || params.file_type === 'TXT' || params.file_type === 'TXT_IN') {
          this.$nextTick(function () {
            this.active.push(params)
            this.$store.dispatch('clickCategory', params)
          })
        }
        console.log(params.parent.name)
      }
    },
    addNode () {
      console.log('Folder added')
      if (!this.data.children) this.data.children = []
      var nodedata = { name: 'new folder', isLeaf: false, file_type: 'folder', depth: '1', parent: 'root' }
      categoryService.create(nodedata).then((createdCategory) => {
        nodedata.id = createdCategory.id
        var node = new TreeNode(nodedata)
        this.data.addChildren(node)
        this.close()
      }).catch(error => {
        this.errorMessage = error.message
      })
    },
    refreshCategory () {
      console.log('searchTree!@')
      this.searchTree()
    }
  },
  computed: {
    filter () {
      return this.caseSensitive
        ? (item, search, textKey) => item[textKey].indexOf(search) > -1
        : undefined
    }
  }
}
</script>

<style>
html{
overflow-y: hidden;
}
.treeScroll{
  height: 700px;
  overflow-y:auto;
  overflow-x:auto;
}
.pointer{
  cursor: pointer;
}
</style>
