export function truncateWords(str:any, count:number) {
    if (!str) return str;
    return str.split(" ").slice(0, count).join(" ")
  }