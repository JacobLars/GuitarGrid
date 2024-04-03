import { Product } from "../types/Types";

export function capitalizeFirstLetter(word: string | undefined): string {
  if (!word || word.length === 0) {
    return "";
  }
  return word.charAt(0).toUpperCase() + word.slice(1);
}

export const cartProducts: Product[] = [];

export function addToCart(product: Product) {
  cartProducts.push(product);
}

export function getCartProducts() {
  return cartProducts;
}
