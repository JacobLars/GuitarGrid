import { Rating } from "@mui/material";
import React from "react";
import { InStock } from "./InStock";
type Props = {
  productName: string;
  productRating: number;
  brandLogo: string;
  product_quantity: number;
};
export const ProductHeader = ({
  productName,
  productRating,
  brandLogo,
  product_quantity,
}: Props) => {
  return (
    <div className="p-5">
      <div className="flex flex-row">
        <h1 className="text-2xl">{productName}</h1>
        <img src={brandLogo} className="h-10 ml-10" />
      </div>
      <Rating name="read-only" value={productRating} readOnly />
      <InStock product_quantity={product_quantity} />
    </div>
  );
};
