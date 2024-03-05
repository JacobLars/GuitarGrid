"use client";
import { Header } from "@/app/components/home/Header";
import { NavBar } from "@/app/components/navbar/NavBar";
import { ProductPage } from "@/app/components/products/ProductPage";

export default function ProductById({
  params,
}: {
  params: { category: string; id: string };
}) {
  return (
    <div className="">
      <Header />
      <NavBar />
      <ProductPage productId={params.id} />
    </div>
  );
}
