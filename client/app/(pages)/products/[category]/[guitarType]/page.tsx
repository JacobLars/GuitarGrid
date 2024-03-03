"use client";
import { GuitarGallery } from "@/app/components/guitars/GuitarGallery";
import { NavBar } from "@/app/components/navbar/NavBar";
import { ProductGallery } from "@/app/components/products/ProductGallery";

export default function Guitars({
  params,
}: {
  params: { guitarType: string; category: string };
}) {
  return (
    <div className="">
      <NavBar />
      <ProductGallery
        category={"/" + params.category + "/"}
        guitarType={params.guitarType}
      />
    </div>
  );
}
