import { Image, Product } from "@/app/types/Types";
import Rating from "@mui/material/Rating";
import { Card, Link } from "@nextui-org/react";
import React from "react";
import { InStock } from "./InStock";
import { AddToCart } from "./AddToCart";
type Props = {
  product: Product;
};
export const ProductCard = ({ product }: Props) => {
  return (
    <div>
      <Card className="flex items-center shadow-lg m-5 border border-[#c5c5c5] md:h-44">
        <div className="w-1/2 h-44 self-start jusitfy-center">
          <img
            className="w-44 h-44 self-start p-5 object-contain"
            src={product.images.filter((img) => img.isMain === true)[0].url}
          />
        </div>
        <div className="ml-10 -mt-36 self-end w-1/2 md:self-start md:ml-40">
          <div className="flex">
            <p className="mr-2 font-bold">{product.brandName}</p>
            <p className="w-auto">{product.name}</p>
          </div>
          <Rating
            className="mt-2"
            name="read-only"
            value={product.rating}
            readOnly
          />
          <p className="mt-2 text-lg md:hidden">{product.price}$</p>
          <InStock product_quantity={product.product_quantity} />
        </div>
        <div className="hidden md:flex md:flex-col md:items-center md:self-end mr-5">
          <p className="font-bold -mt-24 text-2xl">{product.price}$</p>
        </div>
      </Card>
    </div>
  );
};
