import { Product } from "@/app/types/Types";
import React, { useEffect, useState } from "react";
import { ProductCard } from "../ProductCard";
import Link from "next/link";
type Props = {
  brandId: string;
};
export const BrandProductsGallery = ({ brandId }: Props) => {
  const [products, setProducts] = useState<Product[]>([]);

  useEffect(() => {
    const fetchProductsByBrandId = async () => {
      const response = await fetch(
        `http://localhost:8080/api/v1/products/brand/${brandId}`
      );
      const responseToJson = await response.json();
      setProducts(responseToJson.products);
    };
    fetchProductsByBrandId();
  }, []);
  return (
    <div>
      {products.map((product, index) => (
        <Link
          href={`/products/${product.category}/product/${product.id}`}
          key={index}
        >
          <ProductCard product={product} />
        </Link>
      ))}
    </div>
  );
};
