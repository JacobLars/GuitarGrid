import React, { useEffect, useState } from "react";
type Props = {
  product_quantity: number;
};
export const InStock = ({ product_quantity }: Props) => {
  const [isAvailable, setIsAvailable] = useState<boolean>(true);
  useEffect(() => {
    if (product_quantity === 0) {
      setIsAvailable(false);
    }
  }, []);
  return (
    <div>
      {isAvailable ? (
        <p className="text-green-400 mt-2">In stock</p>
      ) : (
        <p className="text-red-600 mt-2">Out of stock</p>
      )}
    </div>
  );
};
