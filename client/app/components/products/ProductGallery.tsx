import { Product } from "@/app/types/Types";
import { useParams } from "next/navigation";
import React, { useEffect, useState } from "react";
import { ProductCard } from "./ProductCard";
type Props = {
  category: string;
};
export const ProductGallery = ({ category }: Props) => {
  const [products, setProducts] = useState<Product[]>([]);
  const [isLoading, setIsloading] = useState<boolean>(true);

  useEffect(() => {
    const fetchTuners = async () => {
      const response = await fetch(`http://localhost:8080/api/v1/${category}`);
      const jsonResponse = await response.json();
      if (category === "guitars") {
        setProducts(jsonResponse.guitars);
      } else if (category === "tuners") {
        setProducts(jsonResponse.tuners);
      }

      setIsloading(false);
    };
    fetchTuners();
  }, []);
  return (
    <div>
      {isLoading ? (
        <img className="h-20 mx-auto my-40" src="/loading.gif" />
      ) : (
        products.map((product, index) => (
          <ProductCard key={index} product={product} />
        ))
      )}
    </div>
  );
};
