import { Brand } from "@/app/types/Types";
import React from "react";
type Props = {
  brand: Brand;
};
export const BrandCard = ({ brand }: Props) => {
  return (
    <div className="flex flex-col border border-slate-600 items-center rounded-md p-2">
      <img className="w-40" src={brand.logo} />
      <p>{brand.name}</p>
    </div>
  );
};
