import React from "react";
import { InStock } from "./InStock";
import { Button } from "@nextui-org/react";
type Props = {
  product_price: number;
  product_quantity: number;
};
export const PriceInfo = ({ product_price, product_quantity }: Props) => {
  return (
    <div className="shadow-lg rounded-md p-5">
      <p className="text-2xl">{product_price}$</p>
      <InStock product_quantity={product_quantity} />
      <Button className="bg-slate-600 text-white p-2 rounded-md mt-2">
        Add to cart
      </Button>
    </div>
  );
};
