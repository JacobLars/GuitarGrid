import React, { useEffect, useState } from "react";
import { GuitarCard } from "./GuitarCard";
import { Guitar } from "@/app/types/Types";
import { useParams } from "next/navigation";
import { ProductCard } from "../products/ProductCard";
type Props = {
  type: string;
};
export const GuitarGallery = ({ type }: Props) => {
  const [guitars, setGuitars] = useState<Guitar[]>([]);
  const [isLoading, setIsloading] = useState<boolean>(true);
  const guitarType = useParams();
  console.log(guitarType);
  useEffect(() => {
    const fetchGuitars = async () => {
      const response = await fetch(
        `http://localhost:8080/api/v1/guitars/type/${type}`
      );
      const jsonResponse = await response.json();
      setGuitars(jsonResponse.guitars);
      setIsloading(false);
    };
    fetchGuitars();
  }, []);

  return (
    <div>
      {isLoading ? (
        <img className="h-20 mx-auto my-40" src="/loading.gif" />
      ) : (
        guitars.map((guitar, index) => (
          <ProductCard
            key={index}
            id={guitar.id}
            name={guitar.name}
            price={guitar.price}
            rating={guitar.rating}
            product_quantity={guitar.product_quantity}
            images={guitar.images}
            brandName={guitar.brandName}
          />
        ))
      )}
    </div>
  );
};
