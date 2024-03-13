import { Brand } from "@/app/types/Types";
import Link from "next/link";
import React from "react";
type Props = {
  brand: Brand;
};
export const BrandCard = ({ brand }: Props) => {
  return (
    <Link href={`/products/brand/${brand.id}`}>
      <div className="flex flex-col border border-slate-600 items-center justify-center rounded-md p-5 h-28">
        <img className="w-40" src={brand.logo} />
        <p>{brand.name}</p>
      </div>
    </Link>
  );
};
