"use client";
import { NavBar } from "@/app/components/navbar/NavBar";
import { ProductPage } from "@/app/components/products/ProductPage";

export default function ProductById({
  params,
}: {
  params: { category: string; id: string };
}) {
  console.log(params.category);
  console.log(params.id);
  return (
    <div className="">
      <NavBar />
      <ProductPage productId={params.id} />
    </div>
  );
}
