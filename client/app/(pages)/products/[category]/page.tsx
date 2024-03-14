"use client";
import { Header } from "@/app/components/home/Header";
import { NavBar } from "@/app/components/navbar/NavBar";
import { ProductGallery } from "@/app/components/products/ProductGallery";
import { Product } from "@/app/types/Types";
import { useEffect, useState } from "react";

export default function ProductCategory({
  params,
}: {
  params: { category: string };
}) {
  const [products, setProducts] = useState<Product[]>([]);
  const [isLoading, setIsloading] = useState<boolean>(true);
  useEffect(() => {
    const fetchProducts = async () => {
      const response = await fetch(
        `http://localhost:8080/api/v1/products?category=${params.category}`
      );
      const jsonResponse = await response.json();
      setProducts(jsonResponse.products);
      setIsloading(false);
    };
    fetchProducts();
  }, []);
  return (
    <div className="">
      <Header />
      <NavBar />
      <ProductGallery products={products} isLoading={isLoading} />
    </div>
  );
}
