<template>
    <Splide
      aria-labelledby="autoplay-example-heading"
      :options="options"
      :has-track="false"
    >
      <div style="position: relative">
        <SplideTrack>
          <SplideSlide v-for="slide in slides" :key="slide.alt">
            <img :src="slide.src" :alt="slide.alt">
          </SplideSlide>
        </SplideTrack>
      </div>
    </Splide>
</template>

<script lang="ts">
// Default theme
import '@splidejs/vue-splide/css';
import { Splide, SplideSlide, SplideTrack, Options } from '@splidejs/vue-splide';
import { defineComponent } from 'vue';
import { generateSlides } from './utils/generateSlides';
export default defineComponent( {
  name: 'AutoplayExample',
  components: {
    Splide,
    SplideTrack,
    SplideSlide,
  },
  setup() {
    const slides = generateSlides();
    const options: Options = {
      rewind  : true,
      gap     : '1rem',
      autoplay: true,
      height  : '20rem',
    };
    return {
      slides,
      options,
    }
  },
} );
</script>