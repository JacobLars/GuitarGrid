import { Product } from "@/app/types/Types";
import React, { useEffect } from "react";

export const CartItems = () => {
  let cart: { product: Product; quantity: number }[] = [];

  const getCart = async () => {
    cart = JSON.parse(localStorage.getItem("cart") as string);
  };
  getCart();
  return (
    <div>
      <ul className="border border-slate-600 rounded-md z-10 p-2">
        {cart?.map((item, index) => (
          <li className="border-b border-b-slate-600" key={index}>
            <div className="flex flex-row items-center">
              <div className="p-2 -ml-2">
                <img
                  className="h-16 w-16"
                  src={
                    item.product.images.filter((img) => img.isMain === true)[0]
                      .url
                  }
                />
              </div>
              <div className="ml-2">
                <p>{item.product.name}</p>
                <p className="text-xl">{item.product.price}$</p>
              </div>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
};
