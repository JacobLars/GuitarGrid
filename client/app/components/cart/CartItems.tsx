import { CartProduct, Product } from "@/app/types/Types";
import React, { useEffect, useState } from "react";

export const CartItems = () => {
  const [cart, setCart] = useState<{ product: Product; quantity: number }[]>(
    []
  );

  useEffect(() => {
    const storedCart = JSON.parse(localStorage.getItem("cart") || "[]");
    setCart(storedCart);
  }, []);

  const updateCartAndLocalStorage = (
    updatedCart: { product: Product; quantity: number }[]
  ) => {
    setCart(updatedCart);
    localStorage.setItem("cart", JSON.stringify(updatedCart));
  };

  const handleCheckoutClick = async () => {
    const cartProducts: CartProduct[] = cart.map((product) => ({
      name: product.product.name,
      quantity: product.quantity,
      price: product.product.price,
    }));
    const req = await fetch("http://localhost:8080/stripe/checkout", {
      headers: { "Content-type": "application/json" },
      method: "POST",
      body: JSON.stringify(cartProducts),
    });
    const response = await req.json();
    window.location.href = response.checkoutUrl;
  };

  const handleClearCartClick = async () => {
    localStorage.removeItem("cart");
    setCart([]);
  };

  const handleDeleteItemClick = (product: Product) => {
    const updatedCart = cart.filter((item) => item.product.id !== product.id);
    updateCartAndLocalStorage(updatedCart);
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
                <img
                  onClick={() => handleDeleteItemClick(item.product)}
                  src="./trashbin.png"
                  className="h-8 hover:cursor-pointer"
                ></img>
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
