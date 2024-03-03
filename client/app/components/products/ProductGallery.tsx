import { Product } from "@/app/types/Types";
import { useParams } from "next/navigation";
import React, { useEffect, useState } from "react";
import { ProductCard } from "./ProductCard";
type Props = {
  category: string;
  guitarType: string;
};
export const ProductGallery = ({ category, guitarType }: Props) => {
  const [products, setProducts] = useState<Product[]>([]);
  const [isLoading, setIsloading] = useState<boolean>(true);
  let url = "";
  if (guitarType === "electric" || guitarType === "acoustic") {
    url = `http://localhost:8080/api/v1/${category}/type/${guitarType}`;
  } else {
    url = `http://localhost:8080/api/v1/${category}`;
  }
  useEffect(() => {
    const fetchTuners = async () => {
      const response = await fetch(url);
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