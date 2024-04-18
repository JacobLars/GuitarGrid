import { Product } from "@/app/types/Types";
import React, { useEffect } from "react";

export const CartItems = () => {
  let cart: { product: Product; quantity: number }[] = [];

  cart = JSON.parse(localStorage.getItem("cart") as string);

  return (
    <div>
      <ul className="border border-t-sky-400 z-10">
        {cart?.map((item, index) => (
          <li key={index}>
            <h1>{item.product.name}</h1>
          </li>
        ))}
      </ul>
    </div>
  );
};
