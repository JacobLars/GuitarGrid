import React from "react";
import { Cart } from "../cart/Cart";
import { Product } from "@/app/types/Types";
type Props = {
  cartProducts: Product[];
};
export const Menu = () => {
  return (
    <div className="flex flex-row p-3 justify-end">
      <img className="h-8 mr-3" src="/account.png" />
      <Cart />
    </div>
  );
};
