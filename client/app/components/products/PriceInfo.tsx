import React from "react";
import { InStock } from "./InStock";
import { Button } from "@nextui-org/react";
import { Product } from "@/app/types/Types";
type Props = {
  product_price: number;
  product_quantity: number;
  product: Product;
  setCartProducts: Function;
};
export const PriceInfo = ({
  product_price,
  product_quantity,
  product,
  setCartProducts,
}: Props) => {
  const handleOnClick = () => {
    setCartProducts((curr: Product[]) => [...curr, product]);
  };
  return (
    <div className="shadow-lg rounded-md p-5 md:w-1/2 md:mx-auto">
      <p className="text-2xl">{product_price}$</p>
      <InStock product_quantity={product_quantity} />
      <Button
        onClick={handleOnClick}
        className="bg-slate-600 text-white p-2 rounded-md mt-2 -ml-1"
      >
        Add to cart
      </Button>
    </div>
  );
};
