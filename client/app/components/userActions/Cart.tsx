import { useCart } from "@/app/contexts/CartContext";
import { Product } from "@/app/types/Types";
import React, { useState } from "react";
import { CartItems } from "../cart/CartItems";
type Props = {
  cartProducts: Product[];
};
export const Cart = () => {
  const { cart } = useCart();
  const [isClicked, setIsClicked] = useState<boolean>(false);
  const cartItemCount = cart.reduce((acc, item) => acc + item.quantity, 0);
  const handleCartOnClick = () => {
    setIsClicked(!isClicked);
  };
  return (
    <div>
      <img
        onClick={handleCartOnClick}
        className="h-8 hover:cursor-pointer"
        src="/cart.png"
      />
      <p className="rounded-full text-center w-5 h-5 bg-red-300 -mt-10 ml-5 absolute">
        {cartItemCount}
      </p>
      {isClicked && <CartItems />}
    </div>
  );
};
