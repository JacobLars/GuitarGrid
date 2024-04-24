import { CartProduct, Product } from "@/app/types/Types";
import React, { useEffect } from "react";

export const CartItems = () => {
  let cart: { product: Product; quantity: number }[] = [];

  const getCart = async () => {
    cart = JSON.parse(localStorage.getItem("cart") as string);
  };
  getCart();

  const handleCheckoutClick = async () => {
    const cartProducts: CartProduct[] = cart.map((product) => ({
      name: product.product.name,
      quantity: product.quantity,
      price: product.product.price,
    }));
    console.log(cartProducts);
    const req = await fetch("http://localhost:8080/stripe/checkout", {
      headers: { "Content-type": "application/json" },
      method: "POST",
      body: JSON.stringify(cartProducts),
    });
    const response = await req.json();
    window.location.href = response.checkoutUrl;
  };

  const handleClearCartClick = async () => {
    localStorage.clear();
    window.location.reload();
  };

  return (
    <div>
      <ul className="border border-slate-600 rounded-md z-10 p-2">
        {cart?.map((item, index) => (
          <li className="border-b border-b-slate-600" key={index}>
            <div className="flex flex-row items-center justify-between">
              <div className="p-2 -ml-2">
                <img
                  className="h-16 w-16"
                  src={
                    item.product.images.filter((img) => img.isMain === true)[0]
                      .url
                  }
                />
              </div>
              <div className="flex-col flex-grow ml-2">
                <div>
                  <p>{item.product.name}</p>
                </div>
                <div>
                  <p className="text-xl">{item.product.price}$</p>
                </div>
              </div>
              <div className="self-end">
                <img src="./trashbin.png" className="h-8"></img>
              </div>
            </div>
          </li>
        ))}
      </ul>
      <section className="border-b border-b-slate-600 border-r border-r-slate-600 border-l border-l-slate-600 rounded-md p-2 flex justify-around">
        <button
          onClick={handleCheckoutClick}
          className="bg-green-500 border border-slate-600 p-2 shadow-md rounded-md text-white hover:bg-green-600"
        >
          To Checkout
        </button>
        <button
          onClick={handleClearCartClick}
          className="bg-red-500 border border-slate-600 p-2 shadow-md rounded-md text-white hover:bg-red-600"
        >
          Clear Cart
        </button>
      </section>
    </div>
  );
};
