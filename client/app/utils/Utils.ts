export function capitalizeFirstLetter(word: string | undefined): string {
  if (!word || word.length === 0) {
    return "";
  }
  return word.charAt(0).toUpperCase() + word.slice(1);
}
