import { Brand } from "@/app/types/Types";
import React from "react";
type Props = {
  brand: Brand;
};
export const BrandCard = ({ brand }: Props) => {
  return (
    <div className="flex flex-col">
      <img src={brand.logo} />
      <p>{brand.name}</p>
    </div>
  );
};
