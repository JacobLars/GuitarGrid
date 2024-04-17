"use client";
import { Product } from "@/app/types/Types";
import React, { useEffect } from "react";

export const CartItems = () => {
  let cart: Product[];

  useEffect(() => {
    cart = JSON.parse(localStorage.getItem("cart") as string);
  }, []);

  return (
    <div>
      <ul className="border border-t-sky-400"></ul>
    </div>
  );
};
