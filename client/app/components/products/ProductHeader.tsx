import { Rating } from "@mui/material";
import React from "react";
type Props = {
  productName: string;
  productRating: number;
  brandLogo: string;
};
export const ProductHeader = ({
  productName,
  productRating,
  brandLogo,
}: Props) => {
  return (
    <div className="p-5">
      <div className="flex flex-row">
        <h1 className="text-2xl">{productName}</h1>
        <img src={brandLogo} className="h-10 ml-10" />
      </div>
      <Rating name="read-only" value={productRating} readOnly />
    </div>
  );
};
