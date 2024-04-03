import { useCart } from "@/app/contexts/CartContext";
import { Product } from "@/app/types/Types";
import { addToCart } from "@/app/utils/Utils";
import React from "react";
type Props = {
  product: Product;
};
export const AddToCart = ({ product }: Props) => {
  const { addToCart } = useCart();
  const handleOnClick = () => {
    addToCart(product);
  };
  return (
    <div>
      <button
        onClick={handleOnClick}
        className="mt-14 bg-slate-600 text-white p-2 rounded-md hover:bg-slate-800 z-10"
      >
        Add to Cart
      </button>
    </div>
  );
};
