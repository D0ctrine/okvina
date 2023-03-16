export function generateSlides( length = 10, sig = 0 ): Array<{ src: string, alt: string }> {
    return Array.from( { length } ).map( ( value, index ) => {
      index = sig || index;
  
      return {
        src: `https://source.unsplash.com/random/1200x450?sig=${ index }`,
        alt: `Image ${ index }`,
      };
    } );
  }