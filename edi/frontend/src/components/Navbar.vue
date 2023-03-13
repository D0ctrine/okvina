<template>
  <header class="bg-white shadow h-16 flex justify-between items-stretch">
    <router-link
      :to="{ name: 'home' }"
      class="inline-flex items-center h-full px-5 text-orange-500 font-bold"
    >
      Home
    </router-link>
    <Search style="width: 60%;"/>
  </header>
  <div class="bg-white shadow h-12 flex justify-center">
  <div class="flex items-center gap-1">
      <router-link
        :to="{ name: 'dev' }"
        class="inline-grid text-center min-w-[100px] items-center px-2 h-full transition-colors hover:bg-orange-500 hover:text-white"
      >
        개발
      </router-link>
      <router-link
        :to="{ name: 'biz' }"
        class="inline-grid text-center min-w-[100px] items-center px-2 h-full transition-colors hover:bg-orange-500 hover:text-white"
      >
        비즈니스
      </router-link>
      <router-link
        :to="{ name: 'fin' }"
        class="inline-grid text-center min-w-[100px] items-center px-2 h-full transition-colors hover:bg-orange-500 hover:text-white"
      >
        재무 및 회계
      </router-link>
    </div>
  </div>
</template>

<script setup>
import Search from './Search.vue'
</script>