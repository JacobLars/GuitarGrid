"use client";
import { Header } from "@/app/components/header/Header";
import { NavBar } from "@/app/components/navbar/NavBar";
import { ProductGallery } from "@/app/components/products/ProductGallery";
import { Product } from "@/app/types/Types";
import { useEffect, useState } from "react";

export default function BrandProducts({
  params,
}: {
  params: { brandId: string };
}) {
  const [products, setProducts] = useState<Product[]>([]);
  const [isLoading, setIsloading] = useState<boolean>(true);

  useEffect(() => {
    const fetchProducts = async () => {
      const response = await fetch(
        `http://localhost:8080/api/v1/products/brand/${params.brandId}`
      );
      const jsonResponse = await response.json();
      setProducts(jsonResponse.products);
      setIsloading(false);
    };
    fetchProducts();
  }, []);
  const brandName = products.map((p) => p.brandName)[0];

  return (
    <div className="">
      <Header />
      <NavBar />
      {isLoading ? (
        <img className="h-20 mx-auto my-40" src="/loading.gif" />
      ) : (
        <ProductGallery
          products={products}
          isLoading={isLoading}
          category={"Products"}
          brandName={brandName}
        />
      )}
    </div>
  );
}
