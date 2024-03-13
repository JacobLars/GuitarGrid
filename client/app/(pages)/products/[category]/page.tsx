"use client";
import { Header } from "@/app/components/home/Header";
import { NavBar } from "@/app/components/navbar/NavBar";
import { ProductGallery } from "@/app/components/products/ProductGallery";

export default function ProductCategory({
  params,
}: {
  params: { category: string };
}) {
  return (
    <div className="">
      <Header />
      <NavBar />
      <ProductGallery category={params.category} guitarType={""} />
    </div>
  );
}
