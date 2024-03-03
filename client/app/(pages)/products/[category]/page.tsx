"use client";
import { NavBar } from "@/app/components/navbar/NavBar";
import { ProductGallery } from "@/app/components/products/ProductGallery";

export default function ProductCategory({
  params,
}: {
  params: { category: string };
}) {
  return (
    <div className="">
      <NavBar />
      <ProductGallery category={params.category} guitarType={""} />
    </div>
  );
}
