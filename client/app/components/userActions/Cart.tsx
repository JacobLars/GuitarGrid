import React, { useState } from "react";

export const Cart = () => {
  const [count, setCount] = useState<number>(0);
  return (
    <div>
      <img className="h-8" src="cart.png" />
      <p className="rounded-full text-center w-5 h-5 bg-red-300 -mt-10 ml-5 absolute">
        {count}
      </p>
    </div>
  );
};
