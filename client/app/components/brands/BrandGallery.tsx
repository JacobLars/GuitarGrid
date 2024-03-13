import { Brand } from "@/app/types/Types";
import React, { useEffect, useState } from "react";
import { BrandCard } from "./BrandCard";

export const BrandGallery = () => {
  const [brands, setBrands] = useState<Brand[]>([]);
  useEffect(() => {
    const fetchAllBrands = async () => {
      const response = await fetch("http://localhost:8080/api/v1/brands");
      const responseToJson = await response.json();
      console.log(responseToJson);
      setBrands(responseToJson.brands);
    };
    fetchAllBrands();
  }, []);

  return (
    <div>
      {brands.map((brand) => (
        <BrandCard brand={brand} />
      ))}
    </div>
  );
};
