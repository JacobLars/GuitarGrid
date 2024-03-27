import React from "react";
import { Cart } from "./Cart";

export const Menu = () => {
  return (
    <div className="flex flex-row p-3 justify-end">
      <img className="h-8 mr-3" src="account.png" />
      <Cart />
    </div>
  );
};
