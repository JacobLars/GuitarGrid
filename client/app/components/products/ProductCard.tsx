import { Image, Product } from "@/app/types/Types";
import Rating from "@mui/material/Rating";
import { Card, Link } from "@nextui-org/react";
import React from "react";
import { InStock } from "./InStock";
type Props = {
  product: Product;
};
export const ProductCard = ({ product }: Props) => {
  return (
    <div>
      <Card className="flex items-center shadow-lg m-5 border border-[#c5c5c5]">
        <div className="w-1/2 h-44 self-start jusitfy-center">
          <img
            className="w-44 h-44 self-start p-5 object-contain"
            src={product.images.filter((img) => img.isMain === true)[0].url}
          />
        </div>
        <div className="ml-10 -mt-36 self-end w-1/2">
          <div className="flex">
            <p className="mr-2 font-bold">{product.brandName}</p>
            <p className="w-32">{product.name}</p>
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
