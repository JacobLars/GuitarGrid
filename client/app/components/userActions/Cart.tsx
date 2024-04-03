import { useCart } from "@/app/contexts/CartContext";
import { Product } from "@/app/types/Types";
import React from "react";
type Props = {
  cartProducts: Product[];
};
export const Cart = () => {
  const { cart } = useCart();
  const cartItemCount = cart.reduce((acc, item) => acc + item.quantity, 0);
  return (
    <div>
      <img className="h-8" src="/cart.png" />
      <p className="rounded-full text-center w-5 h-5 bg-red-300 -mt-10 ml-5 absolute">
        {cartItemCount}
      </p>
    </div>
  );
};
