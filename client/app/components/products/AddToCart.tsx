import { useCart } from "@/app/contexts/CartContext";
import { Product } from "@/app/types/Types";
import { addToCart } from "@/app/utils/Utils";
import React, { useState } from "react";
type Props = {
  product: Product;
};
export const AddToCart = ({ product }: Props) => {
  const { addToCart } = useCart();
  const [showAlert, setShowAlert] = useState<boolean>(false);
  const handleOnClick = (event: any) => {
    event.stopPropagation();
    addToCart(product);
    setShowAlert(true);
    setTimeout(() => {
      setShowAlert(false);
    }, 1000);
  };
  return (
    <div>
      <button
        onClick={handleOnClick}
        className="mt-14 bg-slate-600 text-white p-2 rounded-md hover:bg-slate-800 z-10"
      >
        Add to Cart
      </button>
      {showAlert && (
        <div className="bg-green-700 text-white ">
          {product.name} added to cart
        </div>
      )}
    </div>
  );
};
