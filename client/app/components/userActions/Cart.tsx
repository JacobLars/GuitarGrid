import { Product } from "@/app/types/Types";
import React, { useState } from "react";
type Props = {
  cartProducts: Product[];
};
export const Cart = ({ cartProducts }: Props) => {
  return (
    <div>
      <img className="h-8" src="/cart.png" />
      <p className="rounded-full text-center w-5 h-5 bg-red-300 -mt-10 ml-5 absolute">
        {cartProducts ? cartProducts.length : 0}
      </p>
    </div>
  );
};
