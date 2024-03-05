import { Image, Product } from "@/app/types/Types";
import Rating from "@mui/material/Rating";
import { Card, Link } from "@nextui-org/react";
import React, { useEffect, useState } from "react";
import { InStock } from "./InStock";
type Props = {
  product: Product;
};
export const ProductCard = ({ product }: Props) => {
  const [isAvailable, setIsAvailable] = useState<boolean>(true);
  useEffect(() => {
    if (product.product_quantity === 0) {
      setIsAvailable(false);
    }
  }, []);
  return (
    <div>
      <Card className="flex items-center shadow-lg m-5 border border-[#c5c5c5]">
        <img
          className="w-40 max-h-40 self-start p-5 object-contain -ml-10 overflow-hidden"
          src={product.images.filter((img) => img.isMain === true)[0].url}
        />
        <div className="ml-10 -mt-36">
          <div className="flex">
            <p className="mr-2 font-bold">{product.brandName}</p>
            <p>{product.name}</p>
          </div>
          <Rating
            className="mt-2"
            name="read-only"
            value={product.rating}
            readOnly
          />
          <p className="mt-2 text-lg">{product.price}$</p>
          <InStock product_quantity={product.product_quantity} />
        </div>
      </Card>
    </div>
  );
};
