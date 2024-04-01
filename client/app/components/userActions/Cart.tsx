import { Product } from "@/app/types/Types";
import React, { useState } from "react";
type Props = {
  cartProducts: Product[];
};
export const Cart = ({ cartProducts }: Props) => {
  const [count, setCount] = useState<number>(0);
  return (
    <div>
      <img className="h-8" src="/cart.png" />
      <p className="rounded-full text-center w-5 h-5 bg-red-300 -mt-10 ml-5 absolute">
        {count}
      </p>
    </div>
  );
};
